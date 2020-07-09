package com.lxy.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：使用多线程实现多个客户可以正常首发多条消息
 * 问题：其他客户必须等待，才可以继续
 * 1代码太多不好维护
 * 2客户端读写没有分开 必须先写houdu
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
		//3接受消息
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
				//4换回消息
				dos.writeUTF(msg);
				//释放资源
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
