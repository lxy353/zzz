import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 *��ν��� ���ն�
 * 1.ʹ��datagramSocket  ָ���˿� �������ܶ�
 * 2.׼������ ��װdatagrampacket
 * 3�������ܰ��� recieve��datagrampacket p��
 * 4.��������
 * get data 
 * get length
 * 5.�ͷ���Դ
 */
public class UDPServer5 {
	public static void main(String[] args) throws Exception {
		System.out.println("���ܷ�������");
//		 * 1.ʹ��datagramSocket  ָ���˿� �������ܶ�
		DatagramSocket datagramSocket = new DatagramSocket(9999);
//		 * 2.׼������ ��װdatagrampacket
		while (true) {
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0,container.length);
//		 * 3�������ܰ��� recieve��datagrampacket p��
		datagramSocket.receive(packet);
//		 * 4.��������
//		 * get data 
//		 * get length
		byte[] datas = packet.getData();
		int len= packet .getLength();
		System.out.println(new String(datas,0,len));
		if (datas.equals("bye")) {
			break;
		}
//		 * 5.�ͷ���Դ
		datagramSocket.close();
		}		
	}

}
