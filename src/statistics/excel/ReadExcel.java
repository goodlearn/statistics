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
        	//�������
        	if(null!=dailyEntities) {
        		dailyEntities.clear();
        	}
        	dailyEntities = null;
            String postfix = CasUtils.getPostfix(path);
            if (!StatisticsConstants.EMPTY.equals(postfix)) {
                if (StatisticsConstants.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return null;
                } else if (StatisticsConstants.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                	String showError = checkExcel(path);//��������Ϣ
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

    //���Excel
    public String checkExcel(String path) {
    	StringBuffer errMsg = new StringBuffer();//������Ϣ
    	/**
    	 * �������
    	 * 1����������ͱ�׼�����ϣ��ݶ�Ϊ30��
    	 * 2����������кͱ�׼�����ϣ��ݶ�Ϊ32��
    	 * 3����������кͱ�׼�����ϣ��ݶ�Ϊ11��
    	 * 4�������ϸ�м���
    	 * 	    	��Ӫ���� ~ ��.ú̿���ۣ���֣�
		 * 				����������ƻ�����������
		 * 				���������ʵ�ʱ���������
		 *     			����������ƻ�����������
		 * 				���������ʵ�ʱ���������
		 *     			����������ƻ�����������
		 * 				���������ʵ�ʱ���������
    	 */
    	
    	try {
    		System.out.println(StatisticsConstants.PROCESSING + path);
    		
    		int endNum = 0;
    		String sheetName = null;//�������
    		//��ȡExcel
    		InputStream is = new FileInputStream(path);
    	    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
    	    int numSheets = xssfWorkbook.getNumberOfSheets();
    	    
    	    //��������ͱ�׼�����ϣ��ݶ�Ϊ30��
    		if(numSheets>=StatisticsConstants.NUM_SHEET) {
    			errMsg.append(StatisticsConstants.NUM_SHEET_ERROR);
    			return errMsg.toString();
    		}
    		
    		//��ȡ���
    		for (int numSheet = 0; numSheet < numSheets; numSheet++) {
			  
    		  //�����
			  XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
	          if (xssfSheet == null) {
	              continue;
	          }
	          
	          sheetName = xssfSheet.getSheetName();//�������
	          endNum = xssfSheet.getPhysicalNumberOfRows();//�������
	          
	          //��������кͱ�׼�����ϣ��ݶ�Ϊ32��
	          if(endNum!=StatisticsConstants.END_NUM) {
	        	  errMsg.append(StatisticsConstants.NUM_ROW_ERROR);
	        	  errMsg.append(StatisticsConstants.RN);
	        	  errMsg.append(StatisticsConstants.NUM_SHEET_ERROR_SHOW + sheetName);
	    		  return errMsg.toString();
	          }
	          
	        //��������кͱ�׼�����ϣ��ݶ�Ϊ11��
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
	                		 * һ.�ɰ������� �� ��m3��  
	                		 * ��.ú̿���ۣ���֣�
	                		 * ��.�ִ棨��֣�  
	                		 * �Թ�
	                		 */
	                		continue;
	                	}
	                	

	                	//��������������Χ��
	                	if(rowNum <= StatisticsConstants.SELL_NUM) {
	                		String error = dayMonthYearNumberCheck(xssfRow,rowNum,sheetName);
	                		if(null!=error) {
	                			return error;
	                		}
	                	}
	                	
	                	//��ú��
	                	if(rowNum <= StatisticsConstants.JUMP_NUM_23) {
	                		String error = cmlCheck(xssfRow,rowNum,sheetName);
	                		if(null!=error) {
	                			return error;
	                		}
	                	}
	                	
	                	//��.ú�ʻ���
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
    	return null;//�ɹ����ؿ���
    }
    
    
    /**
     * ú�ʻ���
     * ����������
     * 1#
     * 2#
     * 3#
     * 7#
     * 8#
     * ���ɹŴ��ƹ��ʿ�ʲ����ú����Ȼ���������ι�˾
     * �������ɹŶ���ú�������޹�˾
     * ������������ú̿�������޹�˾
     * ���ɹź�ͨ��·ר����ά���޹�˾
     * ���ɹŻ����ȵ��������ι�˾
     */
    private String mzhjCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//������Ϣ
	   	 for(int i=1;i<12;i++) {
	   		 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,i);
		   	 if(null!=errMsg) {
		   		 return errMsg;
		   	 }
	   	 }
	   	 return null;
    }
    
    /**
     * ��ú��
     * ����������
     * 4#ú ����6#ú 6#ú 1#��ú�� 2#��ú�� 3#��ú�� 7#��ú�� 8#��ú��
     */
    private String cmlCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//������Ϣ
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
	 * 		����������ƻ�����������
	 * 		���������ʵ�ʱ���������
	 *     	����������ƻ�����������
	 * 		���������ʵ�ʱ���������
	 *     	����������ƻ�����������
	 * 		���������ʵ�ʱ���������
	 */
    private String dayMonthYearNumberCheck(XSSFRow xssfRow,int rowNum,String sheetName) {
    	 String errMsg = null;//������Ϣ
	   	 int cellValue = 0;//��Ԫ�������
	   	 
	   	  //���������
	   	 cellValue++;//�ƻ�
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//ʵ��
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//����
	   	 
	   	 
	        //���ۼ����
	   	 cellValue++;//�ƻ�
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//ʵ��
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//����
	       
	        //���ۼ����
	   	 cellValue++;//�ƻ�
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//ʵ��
	   	 errMsg = checkCellNumber(xssfRow,rowNum,sheetName,cellValue);
	   	 if(null!=errMsg) {
	   		 return errMsg;
	   	 }
	   	 cellValue++;//����
	        
	   	return null;//�ɹ����ؿ���
    }
    
    //��Ԫ�����ּ��
    private String checkCellNumber(XSSFRow xssfRow,int rowNum,String sheetName,int cell) {
    	 XSSFCell cellData = xssfRow.getCell(cell);
    	 if(cellData.getCellType()!=XSSFCell.CELL_TYPE_NUMERIC) {
        	 return getErrorSheetNameRowCell(sheetName,rowNum,cell);
         }else {
        	 String stringValue = cellData.getStringCellValue();
        	 
        	 //��ֵ�Ϳո���Դ��� �ǿո�����������
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
    
    //������� ���� ��Ԫ����
    private String getErrorSheetNameRowCell(String sheetName,int rowNum,int cell) {
    	 StringBuffer errMsg = new StringBuffer();//������Ϣ
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
            
            
            // ������ �ӵ�4�п�ʼ rowNum <= xssfSheet.getLastRowNum() �ȵ�15��
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
                		 * һ.�ɰ������� �� ��m3��  
                		 * ��.ú̿���ۣ���֣�
                		 * ��.�ִ棨��֣�  
                		 * �Թ�
                		 */
                		continue;
                	}
                	
                	//��������������Χ��
                	if(rowNum <= StatisticsConstants.SELL_NUM) {
                		dailyEntity.getStrips().put(rowNum, createStrip(xssfRow, rowNum));
                	}
                	
                	//��ú��
                	if(rowNum <= StatisticsConstants.JUMP_NUM_23) {
                		dailyEntity.getRepositorys().put(rowNum, createRepository(xssfRow, rowNum));
                	}
                	
                	//��.ú�ʻ���
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
    //��.ú�ʻ���
    private CoalQualityAnalysis createMzhj(XSSFRow xssfRow,int row) {
    	CoalQualityAnalysis cqa = new CoalQualityAnalysis();
    	
    	XSSFCell name = xssfRow.getCell(0);//����
      	//1#��ú��
	   	XSSFCell coal1 = xssfRow.getCell(1);
	   	//2#��ú��
	   	XSSFCell coal2 = xssfRow.getCell(2);
	   	//3#��ú��
	   	XSSFCell coal3 = xssfRow.getCell(3);
	   	//7#��ú��
	   	XSSFCell coal7 = xssfRow.getCell(4);
	   	//8#��ú��
	   	XSSFCell coal8 = xssfRow.getCell(5);
    	//���ɹŴ��ƹ��ʿ�ʲ����ú����Ȼ���������ι�˾
    	XSSFCell dtksktCoal = xssfRow.getCell(6);
	   	//�������ɹŶ���ú�������޹�˾
	   	XSSFCell dtdlCoal = xssfRow.getCell(7);
	   	//���ɹź�ͨ��·ר����ά���޹�˾
	   	XSSFCell nmht = xssfRow.getCell(8);
	   	//������������ú̿�������޹�˾
	   	XSSFCell klqqCoal = xssfRow.getCell(9);
	   	//���ɹŻ����ȵ��������ι�˾
	   	XSSFCell hnrd = xssfRow.getCell(10);
	    XSSFCell remark = xssfRow.getCell(9);//��ע
	   	 
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
    
    //ú����
    private Repository createRepository(XSSFRow xssfRow,int row) {
    	Repository rep = new Repository();
    	XSSFCell name = xssfRow.getCell(0);//����
        XSSFCell coal4 = xssfRow.getCell(1);//4#ú
        XSSFCell coalLow6 = xssfRow.getCell(2);//����6#ú
        XSSFCell coal6 = xssfRow.getCell(3);//6#ú
        XSSFCell coal1 = xssfRow.getCell(4);//1#��ú��
        XSSFCell coal2 = xssfRow.getCell(5);//2#��ú��
        XSSFCell coal3 = xssfRow.getCell(6);//3#ú
        XSSFCell coal7 = xssfRow.getCell(7);//7#��ú��
        XSSFCell coal8 = xssfRow.getCell(8);//8#��ú��
        XSSFCell remark = xssfRow.getCell(9);//��ע
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
    
    //�ɰ�����
    private Strip createStrip(XSSFRow xssfRow,int row) {
    	Strip strip = new Strip();
    	
    	XSSFCell name = xssfRow.getCell(0);//����
        //���������
        XSSFCell dayPlan = xssfRow.getCell(1);//�ƻ�
        XSSFCell dayFact = xssfRow.getCell(2);//ʵ��
        
        //���ۼ����
        XSSFCell monthPlan = xssfRow.getCell(4);//�ƻ�
        XSSFCell monthFact = xssfRow.getCell(5);//ʵ��
       
        //���ۼ����
        XSSFCell yearPlan = xssfRow.getCell(7);//�ƻ�
        XSSFCell yearFact = xssfRow.getCell(8);//ʵ��
        
        XSSFCell remark = xssfRow.getCell(9);//��ע
        
        strip.setOrder(row);//����
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