package com.lxy.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺ʵ��һ���ͻ����������׷�������Ϣ
 * @author 
 *
 */

public class Chat2 {
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.ָ���˿� ʹ��server socket ����������
		ServerSocket socket = new ServerSocket(9999);
		//2�����ǵȴ�����accept
		Socket clientSocket = socket.accept();
		System.out.println("һ���ͻ�����������");
		//3������Ϣ
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
		Boolean isBoolean=true;
		while (isBoolean) {
		String msg = dis.readUTF();
		//4������Ϣ
				
		dos.writeUTF(msg);
		//�ͷ���Դ
		dos.flush();
		}
		dos.close();
		dis.close();
		clientSocket.close();
	}

}
