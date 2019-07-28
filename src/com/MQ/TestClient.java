package com.MQ;

public class TestClient {

	public static void main(String[] args) throws Exception {	
		 MyClient.produce("hello world");
		 MyClient.consume();
	}

}
