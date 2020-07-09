package com.lxy.chat03;

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
		new Thread(new Send(clientSocket)).start();
		new Thread(new Receive(clientSocket)).start();
	}
}
