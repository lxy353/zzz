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
		copy(srcPath, destPath);
		
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
		
		OutputStream oStream = null;
		InputStream iStream =null;
		try {
			iStream = new FileInputStream(srcFile);
			oStream=new FileOutputStream(destFile,false);
		
			
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
		finally {
			// 释放资源。先打开的后关闭
			try {
				if (null!=oStream) {
					oStream.close();
				}
			} catch (IOException e) {
			}
			try {
				if (null!=iStream) {
					iStream.close();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
	}
	}

