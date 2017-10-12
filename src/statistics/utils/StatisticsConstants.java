package statistics.utils;

public class StatisticsConstants {
	
	 //数据库
	 public static final String ClassName = "com.hxtt.sql.access.AccessDriver";
	 public static final String ConnPath = "jdbc:Access:///d:/db.accdb";
	 public static final String DBUser = "";
	 public static final String DBPassword = "";

	 //窗体
	 public static final String MainFrameName = "统计";
	 public static final String FileMenuName = "文件";
	 public static final String FileMenuSaveName = "保存";
	 public static final String FileMenuOpenName = "打开";
	 public static final String FileMenuCloseName = "关闭";
	
	 //Excel
	 public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
     public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
     public static final String EMPTY = "";
     public static final String POINT = ".";
     public static final String LIB_PATH = "lib";
     public static final String STUDENT_INFO_XLS_PATH = LIB_PATH + "/student_info" + POINT + OFFICE_EXCEL_2003_POSTFIX;
     public static final String STUDENT_INFO_XLSX_PATH = LIB_PATH + "/student_info" + POINT + OFFICE_EXCEL_2010_POSTFIX;
     public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
     public static final String PROCESSING = "Processing...";
     
     //Excel文字
     public static final String ExcelTitle = "矿业公司生产统计日报";
     public static final String ExcelProjectShow = "项      目";
     public static final String ExcelDayProductCondition = "日生产情况";
     public static final String ExcelMonthProductCondition = "月累计完成";
     public static final String ExcelYearProductCondition = "年累计完成";
     public static final String ExcelRemark = "备注";
     public static final String ExcelProjectFinish = "计划";
     public static final String ExcelFactFinish = "实际";
     public static final String ExcelFactRate = "完成比例";
     public static final String ExcelFactRemark = "变更为验收量";
     
     public static final String ExcelProjectKey_1 = "1";
     public static final String ExcelProjectName_1 = "一.采剥工程量 （ 万立方米）";
     public static final String ExcelProjectKey_2 = "2";
     public static final String ExcelProjectName_2 = "(一).自营剥离";
     public static final String ExcelProjectKey_3 = "3";
     public static final String ExcelProjectName_3 = "（二）.外包清理滑体";
     public static final String ExcelProjectKey_4 = "4";
     public static final String ExcelProjectName_4 = "（三）.自营清理滑体";
     public static final String ExcelProjectKey_5 = "5";
     public static final String ExcelProjectName_5 = "（四）煤炭生产（万吨）";
     public static final String ExcelProjectKey_6 = "6";
     public static final String ExcelProjectName_6 = "自营四煤";
     public static final String ExcelProjectKey_7 = "7";
     public static final String ExcelProjectName_7 = "外包四煤";
     public static final String ExcelProjectKey_8 = "8";
     public static final String ExcelProjectName_8 = "低质六煤";
     public static final String ExcelProjectKey_9 = "9";
     public static final String ExcelProjectName_9 = "自营六煤";
     public static final String ExcelProjectKey_10 = "10";
     public static final String ExcelProjectName_10 = "外包六煤";
     public static final String ExcelProjectKey_11 = "11";
     public static final String ExcelProjectName_11 = "(五).破碎站倒运(万吨)";
}
