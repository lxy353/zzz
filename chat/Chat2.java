package com.lxy.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常首发多条消息
 * @author 
 *
 */

public class Chat2 {
	public static void main(String[] args) throws IOException {
		System.out.println("-----server-----");
		//1.指定端口 使用server socket 创建服务器
		ServerSocket socket = new ServerSocket(9999);
		//2阻塞是等待连接accept
		Socket clientSocket = socket.accept();
		System.out.println("一个客户建立了连接");
		//3接受消息
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
		Boolean isBoolean=true;
		while (isBoolean) {
		String msg = dis.readUTF();
		//4换回消息
				
		dos.writeUTF(msg);
		//释放资源
		dos.flush();
		}
		dos.close();
		dis.close();
		clientSocket.close();
	}

}
