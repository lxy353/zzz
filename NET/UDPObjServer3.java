import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
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
public class UDPObjServer3 {
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
		
		ObjectInputStream dataInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(container)));
		//˳��һ��
		String msgString = dataInputStream.readUTF();
		int age = dataInputStream.readInt();
		//
		//
		
		System.out.println(msgString);
		//��������ݻ�ԭ
		Object strObject = dataInputStream.readObject();
		Object emplObject = dataInputStream.readObject();
		
		if (strObject instanceof String) {
	        strObject =(String)strObject;
	        System.out.println(strObject);
		}
		if (strObject instanceof Employee) {
	        emplObject =(String)emplObject;
	        System.out.println(emplObject);
		}
//		 * 5.�ͷ���Դ
		datagramSocket.close();
		
	}

}
