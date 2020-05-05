import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节数组输出流ByteArrayouputstring
 * @author lxz35
 * * 1.创建源 内部维护
 * 2.选择流  不关联源头
 * 3.操作 写出内容
 * 4.释放资源
获取数据， tobytearray
 */
public class IOTest8 {
	public static void main(String[] args) {
		byte[] dest =null;
		ByteArrayOutputStream oStream = null;
		try {
			oStream=new ByteArrayOutputStream();
			String mString ="IO is so easy";
			byte[] datas = mString.getBytes(); //字符串 到数组 编码
			oStream.write(datas,0,datas.length);
			oStream.flush();
			dest=oStream.toByteArray();
			System.out.println(dest.length+"---"+ new String(dest,0,oStream.size()));
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
