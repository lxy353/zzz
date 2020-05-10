import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
 * 数据流
 * 写出后读取
 * 读取的顺序和写出的保持一致
 * data output stream
 * data input stream
 */
public class DatesTest {
	public static void main(String[] args) throws IOException {
		//写出
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		//操作数据类型+数据
		dataOutputStream.writeUTF("lxy");
		dataOutputStream.write(18);
		dataOutputStream.writeChar('a');
		dataOutputStream.flush();
		byte[] datas = byteArrayOutputStream.toByteArray();
		System.out.println(datas.length);
		//读取
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序一致
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		//
		//
		
		System.out.println(msgString);
	}

}
