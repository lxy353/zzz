package com.lxy;
/**
 * 线程方式3
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Cdownload2 implements Callable<Boolean> {
	private String url;//远程路径
	private String name;//存储名字
	public Cdownload2(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		WebDownloader wDownloader = new WebDownloader();
		wDownloader.download(url, name);
		System.out.println(name);
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Cdownload2 cd1= new Cdownload2("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#grpid=12b63f27961ade82746697f732320274&id=80a1cabb224cf8e5a3a8917f0c025e88&dataindex=119", "1");
		Cdownload2 cd2= new Cdownload2("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=e2e95dda8dd8d672bbc6d5b51c0f0651&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "2");
		Cdownload2 cd3= new Cdownload2("https://image.so.com/z?a=viewPage&ch=beauty&t1=595&src=home_beauty&ancestor=list&clw=326#id=feb8057455ef54e65c35e614388904e5&grpid=12b63f27961ade82746697f732320274&currsn=90&prevsn=60", "3");
		
		//创建执行服务
		ExecutorService service = Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> resultFuture1=service.submit(cd1);
		Future<Boolean> resultFuture2=service.submit(cd2);
		Future<Boolean> resultFuture3=service.submit(cd3);
		//获取结果
		boolean r1 = resultFuture1.get();
		boolean r2 = resultFuture1.get();
		boolean r3 = resultFuture1.get();
		//关闭服务
		service.shutdown();
	}

}
