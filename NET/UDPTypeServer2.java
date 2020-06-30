import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * ���ն�
 * 1.ʹ��datagramSocket  ָ���˿� �������ܶ�
 * 2.׼������ ��װdatagrampacket
 * 3�������ܰ��� recieve��datagrampacket p��
 * 4.�������� ���ֽ����黹ԭ��Ϊ��Ӧ������
 * get data 
 * get length
 * 5.�ͷ���Դ
 */
public class UDPTypeServer2 {
	public static void main(String[] args) throws Exception {
		System.out.println("���ܷ�������");
//		 * 1.ʹ��datagramSocket  ָ���˿� �������ܶ�
		DatagramSocket datagramSocket = new DatagramSocket(9999);
//		 * 2.׼������ ��װdatagrampacket
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0,container.length);
//		 * 3�������ܰ��� recieve��datagrampacket p��
		datagramSocket.receive(packet);
//		 * 4.�������� ���ֽ����黹ԭ��Ϊ��Ӧ������
//		 * get data 
//		 * get length
		byte[] datas = packet.getData();
		int len= packet .getLength();
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//˳��һ��
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		System.out.println(msgString);
		System.out.println(age);
//		 * 5.�ͷ���Դ
		datagramSocket.close();
		
	}

}
