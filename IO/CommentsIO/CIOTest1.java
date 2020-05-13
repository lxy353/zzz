package com.lxy.commentIO;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTest1 {
	public static void main(String[] args) {
		//文件大小
		long len =FileUtils.sizeOf(new File("src/com/lxy/commentIO/CIOTest1.java"));
		System.out.println(len);
	
		//目录大小
		len = FileUtils.sizeOf(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"));
		System.out.println(len);
	}

}
