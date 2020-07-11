package com.lxy.chat04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * ���������ң��ͻ���
 * Ŀ�꣺������ʵ��Ⱥ��
 * 
 * @author 
 *
 */

public class TChat5 {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.ָ���˿� ʹ��server socket ����������
		ServerSocket socket = new ServerSocket(9999);
		//2�����ǵȴ�����accept
		while (true) {
			Socket clientSocket = socket.accept();
			System.out.println("һ���ͻ�����������");
			Channel channel = new Channel();
			all.add(channel);//�������Գ�Ա
			new Thread(channel).start(); ;
		}
		
	}
	//һ���ͻ�����һ��channel��
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos ;
		private Socket clientSocket ;
		private Boolean isBoolean=true;
		private String name;
		public Channel() {
			this.clientSocket=clientSocket;
			try {
				dis = new DataInputStream(clientSocket.getInputStream());
				dos = new DataOutputStream(clientSocket.getOutputStream());
				isBoolean = true;
				//��ȡ����
				this.name = receive();
				this.Send("Welcome");
				this.SendOthers(this.name+"111",true);
			} catch (IOException e1) {
				release();
			}
		}
		//������Ϣ
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				release();
			}
			return msg;
		}
		//�ͷ���Ϣ
		private String Send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				release();
			}
			return msg;
		}
		//����������
		/*
		 * ��ȡ�Լ�����Ϣ����������
		 */
		private void SendOthers(String msg,boolean isSys) {
			for (Channel other:all) {
				if (other == this) {
					continue;
				}
				if (!isSys) {
					other.Send(this.name +":"+msg);
				}
				other.Send(msg);//system message
			}
		}
		//�ͷ���Դ
		private void release() {
			this.isBoolean = false;
			Util.close(dis,dos,clientSocket);
			//tuichu
			all.remove(this);
			SendOthers(this.name+"leave", false);
		}
		@Override
		public void run() {
			while (isBoolean) {
				String msg= receive();
				if (!msg.equals("")) {
					//Send(msg);
					SendOthers(msg,false);
				}
				
			}
		}
	}

}
