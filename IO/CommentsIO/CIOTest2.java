package com.lxy.commentIO;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
/**
 * 列出子孙及
 * @author lxz35
 *
 */
public class CIOTest2 {
	public static void main(String[] args) {
		Collection<File>files=FileUtils.listFiles(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"), 
				EmptyFileFilter.NOT_EMPTY, null);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------");
		files=FileUtils.listFiles(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"),
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------");
		files=FileUtils.listFiles(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"), 
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------");
		files=FileUtils.listFiles(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"), 
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), 
				DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------");
		files=FileUtils.listFiles(new File("C:/Users/lxz35/eclipse-workspace/Comments-IO"), 
				FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY), 
				DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
