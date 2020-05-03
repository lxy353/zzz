import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个程序
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author lxz35
 *
 */
public class IOTest01 {
	public static void main(String[] args) throws IOException {
		//1
		File srcFile = new File("abc.txt");
		//2
		try {
			InputStream iStream = new FileInputStream(srcFile);
		//3 
			int data1 = iStream.read();
			int data2 = iStream.read();
			int data3 = iStream.read();
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			//4
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
