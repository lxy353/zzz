package com.lxy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author lxz35
 *
 */
public class WebDownloader {
	public void download(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url),new File("111.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不合法的url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片下载失败");
		}
		
		
	}

}
