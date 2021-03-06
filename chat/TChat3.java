package com.lxy.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Struct;

/**
 * 在线聊天室：客户端
 * 目标：封装使用多线程实现多个客户可以正常首发多条消息
 * 问题：其他客户必须等待，才可以继续
 * 1代码太多不好维护
 * 2客户端读写没有分开 必须先写houdu
 * 
 * @author 
 *
 */

public class TChat3 {
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.指定端口 使用server socket 创建服务器
		ServerSocket socket = new ServerSocket(9999);
		//2阻塞是等待连接accept
		while (true) {
			Socket clientSocket = socket.accept();
			System.out.println("一个客户建立了连接");
			new Thread(new Channel()).start(); ;
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
					Send(msg);
					
				}
				
			}
		}
	}

}
