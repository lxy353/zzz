import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.print.attribute.Size2DSyntax;

/**
 * 随机读取和写入流 random access file
 * @author lxz35
 *
 */
public class RandTest {
	public static void main(String[] args) throws IOException {
		//分多少快
		File sFile = new File("C:/Users/lxz35/eclipse-workspace/IO-3/src/Copy.java");
		// 总长度
		long len = sFile.length();
		//每块大小
		int blockSize =1024;
		//多少块
		int size = (int)Math.ceil(len*1.0/blockSize);
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
			System.out.println(i+"---"+begin + "----"+actualsize);
			split(i, begin, actualsize);
			
		}
			
	}
	//指定起始位置，读取剩下内容
	
	public void test1() throws IOException {
		RandomAccessFile radAccessFile= new RandomAccessFile(new File("C:/Users/lxz35/eclipse-workspace/IO-3/src/Copy.java"), "r");
		//随机读取
		radAccessFile.seek(2);
		byte[] flush  = new byte[1024];// 缓存容器
		//长度
		int len = -1;
		while ((len=radAccessFile.read(flush))!=-1) {
			//decode
			System.out.println(new String(flush,0,len));
		}
		radAccessFile .close();
	}
	//分块思想，开始和实际大小
	
	public static void test2() throws IOException {
		RandomAccessFile radAccessFile= new RandomAccessFile(new File("C:/Users/lxz35/eclipse-workspace/IO-3/src/Copy.java"), "r");
		//起始位置
		int begin=2;
		//实际大小
		int size =1026;
		//随机读取
		radAccessFile.seek(2);
		byte[] flush  = new byte[1024];// 缓存容器
		//长度
		int len = -1;
		while ((len=radAccessFile.read(flush))!=-1) {
			//decode
			if (size>len) {
				System.out.println(new String(flush,0,len));
				size-=len;
			}
			else {
				System.out.println(new String(flush,0,size));
				break;
			}
			
		}
		radAccessFile .close();
	}
	/**
	 *  指定起始位置和实际长度
	 * @param i
	 * @param began
	 * @param actaualsize
	 * @throws IOException
	 */
	public static void split(int i,int began,int actaualsize) throws IOException {

		RandomAccessFile radAccessFile= new RandomAccessFile(new File("C:/Users/lxz35/eclipse-workspace/IO-3/src/Copy.java"), "r");
	
		radAccessFile.seek(2);
		byte[] flush  = new byte[1024];// 缓存容器
		//长度
		int len = -1;
		while ((len=radAccessFile.read(flush))!=-1) {
			//decode
			if (actaualsize>len) {
				System.out.println(new String(flush,0,len));
				actaualsize-=len;
			}
			else {
				System.out.println(new String(flush,0,actaualsize));
				break;
			}
			
		}
		radAccessFile .close();
	
	}
		
	}

