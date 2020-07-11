package com.lxy.chat02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TClient3 {
	public static void main(String[] args) throws UnknownHostException, IOException  {
		System.out.println("-----client-----");
		Socket clientSocket = new Socket("localhost",9999);
		// 客户端发送消息
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());		
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
		Boolean isBoolean=true;
		while (isBoolean) {
		String msg =bufferedReader.readLine();
		dos.writeUTF(msg);
		dos.flush();
		//获取消息
		 msg = dis.readUTF();
		 System.out.println(msg);
	}
		 dos.close();
		 dis.close();
		 clientSocket.close();
	}
}
