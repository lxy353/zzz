import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
 * ������
 * д�����ȡ
 * ��ȡ��˳���д���ı���һ��
 * data output stream
 * data input stream
 */
public class DatesTest {
	public static void main(String[] args) throws IOException {
		//д��
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		//������������+����
		dataOutputStream.writeUTF("lxy");
		dataOutputStream.write(18);
		dataOutputStream.writeChar('a');
		dataOutputStream.flush();
		byte[] datas = byteArrayOutputStream.toByteArray();
		System.out.println(datas.length);
		//��ȡ
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//˳��һ��
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		//
		//
		
		System.out.println(msgString);
	}

}
