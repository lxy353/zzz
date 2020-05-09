import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**分段读取
 * 第一个程序  文件字符流  加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author lxz35
 *
 */
public class BufferedTest3 {
	public static void main(String[] args) throws IOException {
		//1
		File srcFile = new File("abc.txt");
		
		//2
		BufferedReader iStream =null;
		try {
			 iStream = new BufferedReader(new FileReader(srcFile));
			//3
			 String lineString =null;
			while ((lineString =iStream.readLine())!=null) {
				//decode
				String string = new String(lineString);
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
