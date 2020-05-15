package com.lxy.commentIO;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
/**
 * 读取文件
 * @author lxz35
 *
 */
public class CIOTest3 {
	public static void main(String[] args) throws IOException {
		String mString =FileUtils.readFileToString(new File("adc.txt"),"utf-8");
		System.out.println(mString);
		byte[]datas= FileUtils.readFileToByteArray(new File("adc.txt"));
		System.out.println(datas.length);
		
		//逐行读取
		List<String> mStrings = FileUtils.readLines(new File("adc.txt"),"UTF-8");
		for(String string:mStrings) {
			System.out.println(string);
			
		}
		LineIterator it = FileUtils.lineIterator(new File("adc.txt"),"UTF-8");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}

}
