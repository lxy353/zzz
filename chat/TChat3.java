package com.lxy.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺ʹ�ö��߳�ʵ�ֶ���ͻ����������׷�������Ϣ
 * ���⣺�����ͻ�����ȴ����ſ��Լ���
 * 1����̫�಻��ά��
 * 2�ͻ��˶�дû�зֿ� ������дhoudu
 * @author 
 *
 */

public class TChat3 {
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.ָ���˿� ʹ��server socket ����������
		ServerSocket socket = new ServerSocket(9999);
		//2�����ǵȴ�����accept
		while (true) {
		Socket clientSocket = socket.accept();
		System.out.println("һ���ͻ�����������");
		//3������Ϣ
		new Thread(()->{
			DataInputStream dis=null;
			DataOutputStream dos =null;
			try {
				dis = new DataInputStream(clientSocket.getInputStream());
				 dos = new DataOutputStream(clientSocket.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Boolean isBoolean=true;
			while (isBoolean) {
			String msg;
			try {
				msg = dis.readUTF();
				//4������Ϣ
				dos.writeUTF(msg);
				//�ͷ���Դ
				dos.flush();
			} catch (IOException e) {
				
				isBoolean = false;
			}
			}
			try {
				if (null!=dos) {
				dos.close();
			}
				if (null!=dis) {
					dis.close();
				}
				if (null!=clientSocket) {
					clientSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}).start();
	
		
		
		}
		
	}

}
