import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * ���Ͷ�
 *  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
 * 2.׼�����ݣ�һ��Ҫת���ֽ����� 
 * 3��װ���� datagrampacket����Ҫָ��λ��
 * 4.���Ͱ���send datagrampacket
 * 5.�ͷ���Դ
 */
public class UDPClient {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ������С�����������");
//		  1.ʹ��datagramSocket  ָ���˿� �������ܶ�
		DatagramSocket clientSocket = new DatagramSocket(8888);
//		 * 2.׼�����ݣ�һ��Ҫת���ֽ����� 
		String dataString = "lxy";
		byte[] datas = dataString.getBytes();
//		 * 3��װ���� datagrampacket����Ҫָ��λ��
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress("localhost",9999));
//		 * 4.���Ͱ���send datagrampacket
		clientSocket.send(packet);
//		 * 5.�ͷ���Դ
		clientSocket.close();
//		
	}

}
