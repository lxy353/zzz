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
 * ����
 * @author lxz35
 *
 */
public class CIOTest5 {
	public static void main(String[] args) throws IOException {
		//�����ļ�
		//FileUtils.copyFile(new File("p.png"), new File("pcopy.png"));
		//�����ļ���Ŀ¼
		FileUtils.copyFileToDirectory(new File("p.png"), new File("lib"));
		//����Ŀ¼��Ŀ¼
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		//����Ŀ¼
		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		//����URL
		FileUtils
	}

}
