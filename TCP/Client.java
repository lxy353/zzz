import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ��Ϥ����
 * ����������
 * 
 * ָ���˿� ʹ��socket ����������+ ��������ַ�Ͷ˿�
 * �����������������
 * �ͷ���Դ
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client");
		Socket clientSocket = new Socket("localhost",9999);
		DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		String dataString = "lxy";
		dataOutputStream.writeUTF(dataString);
		dataOutputStream.flush();
		dataOutputStream.close();
	}

}
