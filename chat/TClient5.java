package com.lxy.chat04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.lxy.chat02.Receive;
import com.lxy.chat02.Send;

public class TClient5 {
	public static void main(String[] args) throws UnknownHostException, IOException  {
		System.out.println("-----client-----");
		BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("what is your name");
		String name = bufferedReader.readLine();
		Socket clientSocket = new Socket("localhost",9999);
		// 客户端发送消息
		new Thread(new Send(clientSocket,name)).start();
		new Thread(new Receive(clientSocket)).start();
	}
}
