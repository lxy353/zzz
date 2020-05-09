import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件输出流和输入流
 * @author lxz35
 *
 */
public class Copy {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		copy(srcPath, destPath);
		long t2 = System.currentTimeMillis();
		System.out.println( t2 -t1);
		
	}
	/**
	 * 文件拷贝
	 * 思考，利用递归，制作文件夹的拷贝
	 * 
	 * @param srcPath
	 * @param destPath
	 */
	public static void copy(String srcPath,String destPath) {

		
		File srcFile = new File("p.png");
		File destFile= new File("pcopy.png");
		
		
		try (InputStream iStream = new BufferedInputStream(new FileInputStream(srcFile));
				OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destFile));){
			
			
			byte[] flush  = new byte[1024];// 缓存容器
			//长度
			int len = -1;
			while ((len=iStream.read(flush))!=-1) {
				//decode
				oStream.write(flush,0,len);
			}
			oStream.flush();		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
	}
public static void copy2(String srcPath,String destPath) {

		
		File srcFile = new File("p.png");
		File destFile= new File("pcopy.png");
		
		
		try (InputStream iStream = new FileInputStream(srcFile);
				OutputStream oStream = new FileOutputStream(destFile);){
		
			
			byte[] flush  = new byte[1024];// 缓存容器
			//长度
			int len = -1;
			while ((len=iStream.read(flush))!=-1) {
				//decode
				oStream.write(flush,0,len);
			}
			oStream.flush();		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	
		
	}
	

