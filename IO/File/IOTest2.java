import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 第一个程序
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author lxz35
 *
 */
public class IOTest2 {
	public static void main(String[] args) throws IOException {
		//1
		File srcFile = new File("abc.txt");
		
		//2
		InputStream iStream =null;
		try {
			 iStream = new FileInputStream(srcFile);
			int temp;
			//3
			while ((temp=iStream.read())!=-1) {
				System.out.println((char)temp);
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
