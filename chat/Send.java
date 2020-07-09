package com.lxy.chat03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader bufferedReader; 
	private DataOutputStream dos;
	private Socket clientSocket;
	private boolean isBoolean;
	public Send(Socket clientSocket) {
		this.clientSocket = clientSocket;
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		 try {
			dos = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println("==1==");
			this.release();
		}		
	}

	@Override
	public void run() {
		while (isBoolean) {
			String msg = getStrFromString();
			if (!msg.equals("")) {
				Send(msg);
				
			}
			
		}
		
	}
	private void Send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("==3==");
			release();
		}
		
	}
	/*
	 * 从控制台获取消息
	 */
	private String getStrFromString() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"";
	}
	//释放资源
	private void release() {
		this.isBoolean = false;
		Util.close(dos,clientSocket);
			}

}
