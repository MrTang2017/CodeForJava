package com.MQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
	
	//������Ϣ
	public static void produce(String msg) throws Exception{
		
		Socket socket=new Socket(InetAddress.getLocalHost(),BrokerServer.SERVER_PORT);
		try {
			
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			out.println(msg);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		socket.close();
		
	}

	// ������Ϣ
	public static String consume() throws Exception {

		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVER_PORT);
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("CONSUME");
			out.flush();
			// ����
			String message = reader.readLine();

			return message;

		} catch (Exception e) {
			e.printStackTrace();
		}
		socket.close();
		return null;

	}
	
	
	
	
	

}
