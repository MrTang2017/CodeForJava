package com.MQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
	// 定义消息队列的最大容量
	public static final int MAX_SIZE = 3;

	public static ArrayBlockingQueue<String> message = new ArrayBlockingQueue<>(MAX_SIZE);

	// 接受消息
	public static void accept(String msg) throws Exception {
		if (message.offer(msg)) {
			System.out.println("成功接收到消息" + msg + "当前存储的消息大小" + message.size());

		} else {
			System.out.println("消息队列容量已满！！！");
		}
		System.out.println("---------------------------");
	}

	// 转发消息
	public static String forward() throws Exception {
		String msg = message.poll();
		if (msg != null) {
			System.out.println("已经转发出消息" + msg + "当前容器大小" + message.size());

		} else {
			System.out.println("没有消息可供转发");
		}

		return msg;

	}

}
