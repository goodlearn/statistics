package statistics.excel;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import statistics.entity.CoalQualityAnalysis;
import statistics.entity.DailyEntity;
import statistics.entity.Repository;
import statistics.entity.Strip;
import statistics.utils.CasUtils;
import statistics.utils.StatisticsConstants;


public class ReadExcel {
    
	private List<DailyEntity> dailyEntities = null;
	
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public String readExcel(String path) throws IOException {
        if (path == null || StatisticsConstants.EMPTY.equals(path)) {
            return null;
        } else {
        	//清空数据
        	if(null!=dailyEntities) {
        		dailyEntities.clear();
        	}
        	dailyEntities = null;
            String postfix = CasUtils.getPostfix(path);
            if (!StatisticsConstants.EMPTY.equals(postfix)) {
                if (StatisticsConstants.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return null;
                } else if (StatisticsConstants.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                	String showError = checkExcel(path);//检查错误信息
                	if(null!=showError) {
                		return showError;
                	}
                	dailyEntities =  readXlsx(path);
                }
            } else {
                System.out.println(path + StatisticsConstants.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    //检查Excel
    public String checkExcel(String path) {
    	StringBuffer errMsg = new StringBuffer();//错误信息
    	/**
    	 * 错误规则
    	 * 1、表格数量和标准不符合（暂定为30）
    	 * 2、表格数据行和标准不符合（暂定为32）
    	 * 3、表格数据列和标准不符合（暂定为11）
    	 * 4、表格详细行检验
    	 * 	    	自营剥离 ~ 二.煤炭销售（万吨）
		 * 				日生产情况计划必须是数字
		 * 				日生产情况实际必须是数字
		 *     			月生产情况计划必须是数字
		 * 				月生产情况实际必须是数字
		 *     			年生产情况计划必须是数字
		 * 				年生产情况实际必须是数字
    	 */
    	
    	try {
    		System.out.println(StatisticsConstants.PROCESSING + path);
    		
    		int endNum = 0;
    		String sheetName = null;//表格名字
    		//读取Excel
    		InputStream is = new FileInputStream(path);
    	    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
    	    int numSheets = xssfWorkbook.getNumberOfSheets();
    	    
    	    //表格数量和标准不符合（暂定为30）
    		if(numSheets>=StatisticsConstants.NUM_SHEET) {
    			errMsg.append(StatisticsConstants.NUM_SHEET_ERROR);
    			return errMsg.toString();
    		}
    		
    		//读取表格
    		for (int numSheet = 0; numSheet < numSheets; numSheet++) {
			  
    		  //检查表格
			  XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
	          if (xssfSheet == null) {
	              continue;
	          }
	          
	          sheetName = xssfSheet.getSheetName();//表格名字
	          endNum = xssfSheet.getPhysicalNumberOfRows();//表格行数
	          
	          //表格数据行和标准不符合（暂定为32）
	          if(endNum!=StatisticsConstants.END_NUM) {
	        	  errMsg.append(StatisticsConstants.NUM_ROW_ERROR);
	        	  errMsg.append(StatisticsConstants.RN);
	        	  errMsg.append(StatisticsConstants.NUM_SHEET_ERROR_SHOW + sheetName);
	    		  return errMsg.toString();
	          }
	          
	        //表格数据列和标准不符合（暂定为11）
	          if(endNum!=StatisticsConstants.NUM_COLUMN) {
	        	  errMsg.append(StatisticsConstants.NUM_COLUMN_ERROR);
	        	  errMsg.append(StatisticsConstants.RN);
	        	  errMsg.append(StatisticsConstants.NUM_SHEET_ERROR_SHOW + sheetName);
	    		  return errMsg.toString();
	          }
	          
	          for (int rowNum = StatisticsConstants.START_NUM; rowNum <= StatisticsConstants.END_NUM; rowNum++) {
	        	  	XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	                if (xssfRow != null) {
	                	
	                	if(rowNum == StatisticsConstants.START_NUM||
	                			rowNum == StatisticsConstants.JUMP_NUM_16||
	                			rowNum == StatisticsConstants.JUMP_NUM_21||
	                			rowNum == StatisticsConstants.JUMP_NUM_22||
	                			rowNum == StatisticsConstants.JUMP_NUM_24||
	                			rowNum == StatisticsConstants.JUMP_NUM_25||
	                			rowNum == StatisticsConstants.JUMP_NUM_26||
	                			rowNum == StatisticsConstants.JUMP_NUM_27) {
	                		/**
	                		 * 一.采剥工程量 （ 万m3）  
	                		 * 二.煤炭销售（万吨）
	                		 * 三.仓存（万吨）  
	                		 * 略过
	                		 */
	                		continue;
	                	}
	                	

	                	//在销售量行数范围内
	                	if(rowNum <= StatisticsConstants.SELL_NUM) {
	                		String error = dayMonthYearNumberCheck(xssfRow,rowNum,sheetName);
	                		if(null!=error) {
	                			return error;
	                		}
	                	}
	                	
	                	//储煤量
	                	if(rowNum <= StatisticsConstants.JUMP_NUM_23) {
	                		String error = cmlCheck(xssfRow,rowNum,sheetName);
	                		if(null!=error) {
	                			return error;
	                		}
	                	}
	                	
	                	//四.煤质化验
	                	if(rowNum >= StatisticsConstants.JUMP_NUM_27&&
	                			rowNum <= StatisticsConstants.END_NUM) {
	                		String error = mzhjCheck(xssfRow,rowNum,sheetName);
	                		if(null!=error) {
	                			return error;
	                		}
	                	}
	                
	                	
	                }
	         
	          	}
    			
    		}
    	    
    	}catch(Exception e) {
    		errMsg.append(e.getMessage());
    		return errMsg.toString();
    	}
    	return null;//成功返回控制
    }
    
    
    /**
     * 煤质化验
     * 必须是数字
     * 1#
     * 2#
     * 3#
     * 7#
     * 8#
     * 内蒙古大唐国际克什克腾煤制天然气有限责任公司
     * 大唐内蒙古多伦煤化工有限公司
     * 喀喇沁旗润生煤炭物流有限公司
     * 内蒙古恒通铁路专线运维有限公司
     * 内蒙古华宁热电有限责任公司
     */
    private String mzhjCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//错误信息
	   	 for(int i=1;i<12;i++) {
	   		 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,i);
		   	 if(null!=errMsg) {
		   		 return errMsg;
		   	 }
	   	 }
	   	 return null;
    }
    
    /**
     * 储煤量
     * 必须是数字
     * 4#煤 低质6#煤 6#煤 1#储煤仓 2#储煤仓 3#储煤仓 7#储煤仓 8#储煤仓
     */
    private String cmlCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//错误信息
	   	 for(int i=1;i<9;i++) {
	   		 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,i);
		   	 if(null!=errMsg) {
		   		 return errMsg;
		   	 }
	   	 }
	   	 return null;
    }
    
    /**
	 * 
	 * 		日生产情况计划必须是数字
	 * 		日生产情况实际必须是数字
	 *     	月生产情况计划必须是数字
	 * 		月生产情况实际必须是数字
	 *     	年生产情况计划必须是数字
	 * 		年生产情况实际必须是数字
	 */
    private String dayMonthYearNumberCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//错误信息
	   	 int cellValue = 0;//单元格计数器
	   	 
	   	  //日生产情况
	   	 cellValue++;//计划
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//实际
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//比例
	   	 
	   	 
	        //月累计完成
	   	 cellValue++;//计划
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//实际
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//比例
	       
	        //年累计完成
	   	 cellValue++;//计划
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//实际
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//比例
	        
	   	return null;//成功返回控制
    }
    
    //单元格数字检查
    private String checkCellNumber(XSSFRow xssfRow,int rowNum,String sheetName,int cell) {
    	 XSSFCell cellData = xssfRow.getCell(cell);
    	 if(cellData.getCellType()!=XSSFCell.CELL_TYPE_NUMERIC) {
        	 return getErrorSheetNameRowCell(sheetName,rowNum,cell);
         }else {
        	 String stringValue = cellData.getStringCellValue();
        	 
        	 //空值和空格可以存在 非空格数据有问题
        	 if(null == stringValue) {
        		 return null;
        	 }
        	 stringValue = stringValue.trim();
        	 if(""!=stringValue) {
            	 return getErrorSheetNameRowCell(sheetName,rowNum,cell);
        	 }
        	 
         }
    	 return null;
    }
    
    //错误表名 行数 单元格数
    private String getErrorSheetNameRowCell(String sheetName,int rowNum,int cell) {
    	 StringBuffer errMsg = new StringBuffer();//错误信息
    	 errMsg.append(StatisticsConstants.ERROR_NUMBER);
    	 errMsg.append(StatisticsConstants.RN);
    	 errMsg.append(StatisticsConstants.NUM_SHEET_ERROR_SHOW + sheetName);
    	 errMsg.append(StatisticsConstants.RN);
    	 errMsg.append(StatisticsConstants.NUM_ROW_ERROR_SHOW + rowNum);
    	 errMsg.append(StatisticsConstants.RN);
    	 errMsg.append(StatisticsConstants.NUM_CELL_ERROR_SHOW + cell);
    	 return errMsg.toString();
    }
    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    private List<DailyEntity> readXlsx(String path) throws IOException {
        System.out.println(StatisticsConstants.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        
        List<DailyEntity> list = new ArrayList<DailyEntity>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            
            DailyEntity dailyEntity = new DailyEntity();
            
            
            // 读行数 从第4行开始 rowNum <= xssfSheet.getLastRowNum() 先到15行
            for (int rowNum = StatisticsConstants.START_NUM; rowNum <= StatisticsConstants.END_NUM; rowNum++) {
        	  	XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	
                	if(rowNum == StatisticsConstants.START_NUM||
                			rowNum == StatisticsConstants.JUMP_NUM_16||
                			rowNum == StatisticsConstants.JUMP_NUM_21||
                			rowNum == StatisticsConstants.JUMP_NUM_22||
                			rowNum == StatisticsConstants.JUMP_NUM_24||
                			rowNum == StatisticsConstants.JUMP_NUM_25||
                			rowNum == StatisticsConstants.JUMP_NUM_26||
                			rowNum == StatisticsConstants.JUMP_NUM_27) {
                		/**
                		 * 一.采剥工程量 （ 万m3）  
                		 * 二.煤炭销售（万吨）
                		 * 三.仓存（万吨）  
                		 * 略过
                		 */
                		continue;
                	}
                	
                	//在销售量行数范围内
                	if(rowNum <= StatisticsConstants.SELL_NUM) {
                		dailyEntity.getStrips().put(rowNum, createStrip(xssfRow, rowNum));
                	}
                	
                	//储煤量
                	if(rowNum <= StatisticsConstants.JUMP_NUM_23) {
                		dailyEntity.getRepositorys().put(rowNum, createRepository(xssfRow, rowNum));
                	}
                	
                	//四.煤质化验
                	if(rowNum >= StatisticsConstants.JUMP_NUM_27&&
                			rowNum <= StatisticsConstants.END_NUM) {
                		dailyEntity.getCoalQualityAnalysiss().put(rowNum, createMzhj(xssfRow, rowNum));
                	}
                }
            }
            list.add(dailyEntity);
        }
        return list;
    }
    //四.煤质化验
    private CoalQualityAnalysis createMzhj(XSSFRow xssfRow,int row) {
    	CoalQualityAnalysis cqa = new CoalQualityAnalysis();
    	
    	XSSFCell name = xssfRow.getCell(0);//名称
      	//1#储煤仓
	   	XSSFCell coal1 = xssfRow.getCell(1);
	   	//2#储煤仓
	   	XSSFCell coal2 = xssfRow.getCell(2);
	   	//3#储煤仓
	   	XSSFCell coal3 = xssfRow.getCell(3);
	   	//7#储煤仓
	   	XSSFCell coal7 = xssfRow.getCell(4);
	   	//8#储煤仓
	   	XSSFCell coal8 = xssfRow.getCell(5);
    	//内蒙古大唐国际克什克腾煤制天然气有限责任公司
    	XSSFCell dtksktCoal = xssfRow.getCell(6);
	   	//大唐内蒙古多伦煤化工有限公司
	   	XSSFCell dtdlCoal = xssfRow.getCell(7);
	   	//内蒙古恒通铁路专线运维有限公司
	   	XSSFCell nmht = xssfRow.getCell(8);
	   	//喀喇沁旗润生煤炭物流有限公司
	   	XSSFCell klqqCoal = xssfRow.getCell(9);
	   	//内蒙古华宁热电有限责任公司
	   	XSSFCell hnrd = xssfRow.getCell(10);
	    XSSFCell remark = xssfRow.getCell(9);//备注
	   	 
	    cqa.setName(getValue(name));
	    cqa.setOrder(row);
	    cqa.setRemark(getValue(remark));
	    cqa.setCoal1(getValue(coal1));
	    cqa.setCoal2(getValue(coal2));
	    cqa.setCoal3(getValue(coal3));
	    cqa.setCoal7(getValue(coal7));
	    cqa.setCoal8(getValue(coal8));
	    cqa.setDtksktCoal(getValue(dtksktCoal));
	    cqa.setDtdlCoal(getValue(dtdlCoal));
	    cqa.setNmht(getValue(nmht));
	    cqa.setKlqqCoal(getValue(klqqCoal));
	    cqa.setHnrd(getValue(hnrd));
	    return cqa;
    }
    
    //煤储量
    private Repository createRepository(XSSFRow xssfRow,int row) {
    	Repository rep = new Repository();
    	XSSFCell name = xssfRow.getCell(0);//名称
        XSSFCell coal4 = xssfRow.getCell(1);//4#煤
        XSSFCell coalLow6 = xssfRow.getCell(2);//低质6#煤
        XSSFCell coal6 = xssfRow.getCell(3);//6#煤
        XSSFCell coal1 = xssfRow.getCell(4);//1#储煤仓
        XSSFCell coal2 = xssfRow.getCell(5);//2#储煤仓
        XSSFCell coal3 = xssfRow.getCell(6);//3#煤
        XSSFCell coal7 = xssfRow.getCell(7);//7#储煤仓
        XSSFCell coal8 = xssfRow.getCell(8);//8#储煤仓
        XSSFCell remark = xssfRow.getCell(9);//备注
        rep.setName(getValue(name));
        rep.setOrder(row);
        rep.setRemark(getValue(remark));
        rep.setCoal4(getValue(coal4));
        rep.setCoalLow6(getValue(coalLow6));
        rep.setCoal6(getValue(coal6));
        rep.setCoal1(getValue(coal1));
        rep.setCoal2(getValue(coal2));
        rep.setCoal3(getValue(coal3));
        rep.setCoal7(getValue(coal7));
        rep.setCoal8(getValue(coal8));
        return rep;
    }
    
    //采剥对象
    private Strip createStrip(XSSFRow xssfRow,int row) {
    	Strip strip = new Strip();
    	
    	XSSFCell name = xssfRow.getCell(0);//名称
        //日生产情况
        XSSFCell dayPlan = xssfRow.getCell(1);//计划
        XSSFCell dayFact = xssfRow.getCell(2);//实际
        
        //月累计完成
        XSSFCell monthPlan = xssfRow.getCell(4);//计划
        XSSFCell monthFact = xssfRow.getCell(5);//实际
       
        //年累计完成
        XSSFCell yearPlan = xssfRow.getCell(7);//计划
        XSSFCell yearFact = xssfRow.getCell(8);//实际
        
        XSSFCell remark = xssfRow.getCell(9);//备注
        
        strip.setOrder(row);//行数
        strip.setName(getValue(name));
        strip.setDailyPlan(getValue(dayPlan));
        strip.setDailyFact(getValue(dayFact));
        strip.setMonthPlan(getValue(monthPlan));
        strip.setMonthFact(getValue(monthFact));
        strip.setYearPlan(getValue(yearPlan));
        strip.setYearFact(getValue(yearFact));
        strip.setRemark(getValue(remark));
        
        return strip;
    }

    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}