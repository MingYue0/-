package com.jf;

public class StringUtil {

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else if ("".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ²»Îª¿Õ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

}