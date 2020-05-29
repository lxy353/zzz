package com.lxy;

public class Tdownload extends Thread {
	private String url;//Ô¶³ÌÂ·¾¶
	private String name;//´æ´¢Ãû×Ö
	public Tdownload(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		WebDownloader wDownloader = new WebDownloader();
		wDownloader.download(url, name);
		super.run();
		System.out.println(name);
	}
	public static void main(String[] args) {
		Tdownload td1= new Tdownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#grpid=12b63f27961ade82746697f732320274&id=80a1cabb224cf8e5a3a8917f0c025e88&dataindex=119", "1");
		Tdownload td2= new Tdownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=e2e95dda8dd8d672bbc6d5b51c0f0651&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "2");
		Tdownload td3= new Tdownload("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=feb8057455ef54e65c35e614388904e5&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "3");
		
		td1.start();
		td2.start();
		td3.start();
	}

}
