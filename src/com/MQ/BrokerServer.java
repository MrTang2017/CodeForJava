package com.MQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 对外提供Broker的功能
 * 
 * @author 汤吉
 *
 */
public class BrokerServer implements Runnable {

	public static final int SERVER_PORT = 9999;
	private final Socket socket;

	public BrokerServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String msg = reader.readLine();
				if (msg == null) {
					continue;
				}
				System.out.println("接受到原始数据" + msg);
				if (msg.equals("CONSUME")) {
					String message = Broker.forward();
					out.println(message);
					out.flush();
				} else {
					Broker.accept(msg);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket=new ServerSocket(SERVER_PORT);
		while(true) {
			BrokerServer brokerServer=new BrokerServer(serverSocket.accept());
			new Thread(brokerServer).start();
			
		}
		

	}

}
