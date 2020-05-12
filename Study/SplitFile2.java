import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.print.attribute.Size2DSyntax;
import javax.sound.midi.Sequence;

/**封装
 * 随机读取和写入流 random access file
 * @author lxz35
 *
 */
public class SplitFile2 {
	//源头
	private File srFile;
	//目的地（问价夹）
	private String destDirString;
	//所有分割后的文件存储路径
	private ArrayList<String> destPaths;
	//每块大小
	private int blockSize ;
	//多少块
	private int size;
	
	public SplitFile2(String srFile, String destDirString, int blockSize) {
		// TODO Auto-generated constructor stub
		this.srFile= new File(srFile);
		this.destDirString=destDirString;
		this.blockSize=blockSize;
		this.destPaths = new ArrayList<String>();
		//初始化
		init();
	}
	
	private void init() {
		// 总长度
		long len = this.srFile.length();
		//多少块
		this.size = (int)Math.ceil(len*1.0/blockSize);
		//lujing
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDirString+"i"+"-"+this.srFile.getName());
			
		}
		
	}
	/**
	 * 分割
	 * 计算每一快的起诉位置和大小
	 * 分割
	 * @throws IOException 
	 */
	public void split() throws IOException {
	
		// 总长度
		long len = srFile.length();
		
		int begin =0;
		int actualsize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			begin=i*blockSize;
			if (i==size-1) {//最后一块
				actualsize=(int)len;
			}else {
				actualsize=blockSize;
						len-=actualsize;//剩余量
			}
			
			splitDetail(i, begin, actualsize);
		
	}
	}
	
	//指定起始位置，读取剩下内容

	/**
	 *  指定起始位置和实际长度
	 * @param i
	 * @param began
	 * @param actaualsize
	 * @throws IOException
	 */
	public  void splitDetail(int i,int began,int actaualsize) throws IOException {

		RandomAccessFile radAccessFile= new RandomAccessFile(this.srFile, "r");
		RandomAccessFile radAccessFile2= new RandomAccessFile(this.destPaths.get(i), "rw");

		radAccessFile.seek(2);
		byte[] flush  = new byte[1024];// 缓存容器
		//长度
		int len = -1;
		while ((len=radAccessFile.read(flush))!=-1) {
			//decode
			if (actaualsize>len) {
				System.out.println(new String(flush,0,len));
				radAccessFile2.write(flush,0,len);
				actaualsize-=len;
			}
			else {
				radAccessFile2.write(flush,0,actaualsize);
				break;
			}
			
		}
		radAccessFile2.close();
		radAccessFile.close();
	
	}
	//文件的合并
	public void merge(String destPath) throws IOException {
		//输出流
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream>vInputStreams  =new Vector<InputStream>();
		SequenceInputStream siSequenceInputStream= null;
		//输入流
		for (int i = 0; i < destPaths.size(); i++) {
			vInputStreams.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		siSequenceInputStream = new SequenceInputStream(vInputStreams.elements());
			//copy
			byte[]flush = new byte[1024];
			int len = -1;
			while ((len = siSequenceInputStream.read(flush))!=-1) {
				oStream.write(flush, 0, len);
			}
			oStream.flush();
			siSequenceInputStream.close();
		oStream.close();
		
	}
	public static void main(String[] args) throws IOException {
		SplitFile2 splitFile = new SplitFile2("C:/Users/lxz35/eclipse-workspace/IO-3/src/100 (1).jpg","dest",1024*10);
		splitFile.split();
	}
	}

