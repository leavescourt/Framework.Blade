package com.bingbinlee.blade.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @Description 获取异常 工具类
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午7:11:09
 * @version 1.0
 */
public class ExceptionUtil {

	/**
	 * 获取异常的堆栈信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
