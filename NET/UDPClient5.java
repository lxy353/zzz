import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * ��ν������Ͷ�
 *  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
 * 2.׼�����ݣ�һ��Ҫת���ֽ����� 
 * 3��װ���� datagrampacket����Ҫָ��λ��
 * 4.���Ͱ���send datagrampacket
 * 5.�ͷ���Դ
 */
public class UDPClient5 {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ������С�����������");
//		  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
		DatagramSocket clientSocket = new DatagramSocket(8888);
//		 * 2.׼�����ݣ�һ��Ҫת���ֽ����� 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
		
		String dataString = reader.readLine();
		byte[] datas = dataString.getBytes();
//		 * 3��װ���� datagrampacket����Ҫָ��λ��
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress("localhost",9999));
//		 * 4.���Ͱ���send datagrampacket
		clientSocket.send(packet);
		if (datas.equals("bye")) {
			break;
			
		}
		}
//		 * 5.�ͷ���Դ
		clientSocket.close();
//		
	}

}
