package com.lxy;

public class Idownload implements Runnable {
	private String url;//Ô¶³ÌÂ·¾¶
	private String name;//´æ´¢Ãû×Ö
	public Idownload(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public void run() {
		// TODO Auto-generated method stub
		WebDownloader wDownloader = new WebDownloader();
		wDownloader.download(url, name);
		
		System.out.println(name);
	}
	public static void main(String[] args) {
		Idownload td1= new Idownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#grpid=12b63f27961ade82746697f732320274&id=80a1cabb224cf8e5a3a8917f0c025e88&dataindex=119", "1");
		Idownload td2= new Idownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=e2e95dda8dd8d672bbc6d5b51c0f0651&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "2");
		Idownload td3= new Idownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=feb8057455ef54e65c35e614388904e5&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "3");
		
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}

}
