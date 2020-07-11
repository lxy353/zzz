package com.lxy.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 在线聊天室：客户端
 * 目标：加容器实现群聊
 * 
 * @author 
 *
 */

public class TChat4 {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.指定端口 使用server socket 创建服务器
		ServerSocket socket = new ServerSocket(9999);
		//2阻塞是等待连接accept
		while (true) {
			Socket clientSocket = socket.accept();
			System.out.println("一个客户建立了连接");
			Channel channel = new Channel();
			all.add(channel);//管理所以成员
			new Thread(channel).start(); ;
		}
		
	}
	//一个客户代表一个channel；
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos ;
		private Socket clientSocket ;
		private Boolean isBoolean=true;
		public Channel() {
			this.clientSocket=clientSocket;
			try {
				dis = new DataInputStream(clientSocket.getInputStream());
				dos = new DataOutputStream(clientSocket.getOutputStream());
				isBoolean = true;
			} catch (IOException e1) {
				release();
			}
		}
		//接受消息
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				release();
			}
			return msg;
		}
		//释放消息
		private String Send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				release();
			}
			return msg;
		}
		//发给其他人
		/*
		 * 获取自己的消息发给其他人
		 */
		private void SendOthers(String msg) {
			for (Channel other:all) {
				if (other == this) {
					continue;
				}
				other.Send(msg);
			}
		}
		//释放资源
		private void release() {
			this.isBoolean = false;
			Util.close(dis,dos,clientSocket);
		}
		@Override
		public void run() {
			while (isBoolean) {
				String msg= receive();
				if (!msg.equals("")) {
					//Send(msg);
					SendOthers(msg);
				}
				
			}
		}
	}

}
