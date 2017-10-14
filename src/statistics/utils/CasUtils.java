package statistics.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CasUtils {

	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
	}else{
		return false;
	}
	}
	
	/**
	 * 判断不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim())){
			return true;
	    }else{
		return false;
	    }
	}
	
    //验证数字
    public static boolean isNumeric(String str){ 
 	   Pattern pattern = Pattern.compile("[0-9]*"); 
 	   Matcher isNum = pattern.matcher(str);
 	   if( !isNum.matches() ){
 	       return false; 
 	   } 
 	   return true; 
 	}
	
    /**
     * get postfix of the path
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || StatisticsConstants.EMPTY.equals(path.trim())) {
            return StatisticsConstants.EMPTY;
        }
        if (path.contains(StatisticsConstants.POINT)) {
            return path.substring(path.lastIndexOf(StatisticsConstants.POINT) + 1, path.length());
        }
        return StatisticsConstants.EMPTY;
    }
	
}
