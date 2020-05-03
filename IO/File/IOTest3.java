import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**分段读取
 * 第一个程序
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author lxz35
 *
 */
public class IOTest3 {
	public static void main(String[] args) throws IOException {
		//1
		File srcFile = new File("abc.txt");
		
		//2
		InputStream iStream =null;
		try {
			 iStream = new FileInputStream(srcFile);
			//3
			byte[] flush  = new byte[1024];// 缓存容器
			//长度
			int len = -1;
			while ((len=iStream.read(flush))!=-1) {
				//decode
				String string = new String(flush,0,len);
				System.out.println(string);
			}
			//4
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (null!=iStream) {
				iStream.close();
			}
			iStream.close();
			
		}
		
	}

}
