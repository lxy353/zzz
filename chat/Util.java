package com.lxy.chat03;

import java.io.Closeable;

public class Util {
	/**
	 * สอทลืสิด
	 */
	public static void close(Closeable...targets) {
		for (Closeable target:targets) {
			try {
				if (null!=target) {
					target.close();
				}
			} catch (Exception e) {
				
			}
			
		}
	}

}
