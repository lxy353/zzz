import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��Ϥ����
 * ����������
 * 
 * ָ���˿� ʹ��serversocket ����������
 * �����ȴ�����accept
 * �����������������
 * �ͷ���Դ
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		ServerSocket socket = new ServerSocket(9999);
		Socket clientSocket = socket.accept();
		System.out.println("һ���˴���������");
		DataInputStream dataOutputStream = new DataInputStream(clientSocket.getInputStream());
		String daString = dataOutputStream.readUTF();
		dataOutputStream.close();
		
		socket.close();
		
		
	}

}
