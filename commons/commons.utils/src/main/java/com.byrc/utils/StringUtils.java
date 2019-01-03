package com.byrc.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static boolean isNull(Object str){
		if ( str==null )
			return true;
		return false;
	}
	
    public static boolean equals(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }
	
	public static boolean isEmpty(String str){
		if ( str==null || str.trim().equals("") || str.equals("null") )
			return true;
		return false;
	}
	
	public static boolean isNotNull(Object str){
		return !isNull(str);
	}
	
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	public static String toUpperFirst(String src) {
		
		char l = Character.toUpperCase(src.charAt(0));
		return src.replaceFirst(String.valueOf(src.charAt(0)), String.valueOf(l));
	}
	
	public static String toLowerFirst(String src) {
		
		char l = Character.toLowerCase(src.charAt(0));
		return src.replaceFirst(String.valueOf(src.charAt(0)), String.valueOf(l));
	}
	
	public static String convertStackTrace(Exception e) {
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		
		return stringWriter.toString();
	}
	
	public static boolean isNumeric(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();
	}
	
	
	public static boolean match(String str) {
		Pattern p = Pattern.compile("^[0-9]+(.[0-9]*)?$");
		Matcher m = p.matcher(str.trim());
		return m.find();
	}
	
	// 随机6位数字
	public static String Random6(){
		
		Random random = new Random();
		
		int x = random.nextInt(899999);
		
		x = x + 100000;
		
		return String.valueOf(x);
	}
	public static String getIdByList(List<String> ids){
		StringBuffer sb = new StringBuffer();
		if(ids.size()>0){
			for(String id : ids){
				
				if(id.equals("8a8293b658512f8a0158515945240021")){
					System.out.println();
				}
				
				sb.append("'").append(id).append("',");
			}
		}else{
			sb.append("");
		}
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}else{
			return "";
		}
	}
	
	public static String getIdByList2(List<String> ids){
		StringBuffer sb = new StringBuffer();
		if(ids.size()>0){
			for(String id : ids){
				
				if(id.equals("8a8293b658512f8a0158515945240021")){
					System.out.println();
				}
				
				sb.append(id).append(",");
			}
		}else{
			sb.append("");
		}
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}else{
			return "";
		}
	}
	
	public static String getIdByList(String[] ids){
		StringBuffer sb = new StringBuffer();
		if(ids.length>0){
			for(String id : ids){
				sb.append("'").append(id).append("',");
			}
		}else{
			sb.append("");
		}
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}else{
			return "";
		}
	}
	
	public static String getIdByList(String[] ids, String separator){
		StringBuffer sb = new StringBuffer();
		if(ids.length>0){
			for(String id : ids){
				sb.append(id).append(separator);
			}
		}else{
			sb.append("");
		}
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}else{
			return "";
		}
	}
	
	public static String nullToEmp(String str){
		String blStr = null;
		if ( str==null || str.trim().equals("null")){
			blStr =  "";
		}else{
			blStr = str;
		}
		return blStr;
	}
	
	/**
     * 判断字符是否是中文
     *
     * @param c 字符
     * @return 是否是中文
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
	
	
	/**
     * 判断字符串是否是乱码
     *
     * @param strName 字符串
     * @return 是否是乱码
     */
    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|t*|r*|n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = ch.length;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
            }
        }
        float result = count / chLength;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }
 
    }
	
	
}
