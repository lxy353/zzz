package com.lxy.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺ʵ��һ���ͻ����������׷���Ϣ
 * @author jakel
 *
 */

public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.ָ���˿� ʹ��server socket ����������
		ServerSocket socket = new ServerSocket(9999);
		//2�����ǵȴ�����accept
		Socket clientSocket = socket.accept();
		System.out.println("һ���ͻ�����������");
		//3������Ϣ
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
		String msg = dis.readUTF();
		//4������Ϣ
		DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());		
		dos.writeUTF(msg);
		//�ͷ���Դ
		dos.flush();
		dos.close();
		dis.close();
		clientSocket.close();
	}

}
