package com.lxy.chat03;
/**
 * ʹ�ö��̷߳�װ�����ܶ�
 * 1.������Ϣ
 * 2.�ͷ���Դ
 * 3.��дrun
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket clientSocket;
	private boolean isBoolean;
	public Receive(Socket clientSocket) {
		this.clientSocket =clientSocket;
		try {
			dis= new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			System.out.println("==4==");
			release();	
		}
	}
	private String receive() {
		String msg= "";
		try {
			msg = dis.readUTF();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("");
			release();
		}
		return msg;
	}
	@Override
	public void run() {
		while (isBoolean) {
			String msg = receive();
			if (!msg.equals("")) {
				System.out.println(msg);
			}
		}	
	}
	private void release() {
		this.isBoolean = false;
		Util.close(dis,clientSocket);
			}
}
