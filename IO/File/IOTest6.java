import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 文件字符输出流
 * @author lxz35
 * * 1.创建源
 * 2.选择流
 * 3.操作 写出内容
 * 4.释放资源

 */
public class IOTest6 {
	public static void main(String[] args) {
		File srcFile= new File("Dest.txt");
		Writer oStream = null;
		try {
			oStream=new FileWriter(srcFile,false);
//			String mString ="IO is so easy";
//			char[] datas = mString.toCharArray(); //字符串 到数组 编码
//			oStream.write(datas,0,datas.length);
//			oStream.flush();
			

//			String mString ="IO is so easy";			
//			oStream.write(mString);
//			oStream.flush();
			
			oStream.append("dadadad").append("dadadad");
			oStream.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (null!=oStream) {
					oStream.close();
				}
			} catch (Exception e2) {
			}
		}
		
	}

}
