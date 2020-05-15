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
 * Ð´³ö
 * @author lxz35
 *
 */
public class CIOTest4 {
	public static void main(String[] args) throws IOException {
		FileUtils.write(new File("add.sxt"), "llxxyy\r\n","UTF-8");
		FileUtils.writeStringToFile(new File("add.sxt"), "llxxyy\r\n","UTF-8",true);
		FileUtils.writeByteArrayToFile(new File("add.sxt"),"llxxyy".getBytes("UTF-8"));
		
		List<String>dataStrings= new ArrayList<String>();
		dataStrings.add("111");
		dataStrings.add("222");
		dataStrings.add("333");
		
		FileUtils.writeLines(new File("add.sxt"), dataStrings,"UTF-8",true);
	}

}
