package com.lxy.commentIO;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
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
 * 拷贝
 * @author lxz35
 *
 */
public class CIOTest5 {
	public static void main(String[] args) throws IOException {
		//复制文件
		//FileUtils.copyFile(new File("p.png"), new File("pcopy.png"));
		//复制文件到目录
		FileUtils.copyFileToDirectory(new File("p.png"), new File("lib"));
		//复制目录到目录
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		//复制目录
		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		//拷贝URL
		FileUtils
	}

}
