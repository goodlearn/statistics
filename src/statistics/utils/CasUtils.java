package statistics.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CasUtils {

    //ÑéÖ¤Êý×Ö
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
