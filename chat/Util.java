package com.lxy.chat02;

import java.io.Closeable;

public class Util {
	/**
	 * �ͷ���Դ
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
