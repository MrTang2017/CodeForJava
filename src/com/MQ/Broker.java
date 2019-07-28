package com.MQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
	// ������Ϣ���е��������
	public static final int MAX_SIZE = 3;

	public static ArrayBlockingQueue<String> message = new ArrayBlockingQueue<>(MAX_SIZE);

	// ������Ϣ
	public static void accept(String msg) throws Exception {
		if (message.offer(msg)) {
			System.out.println("�ɹ����յ���Ϣ" + msg + "��ǰ�洢����Ϣ��С" + message.size());

		} else {
			System.out.println("��Ϣ������������������");
		}
		System.out.println("---------------------------");
	}

	// ת����Ϣ
	public static String forward() throws Exception {
		String msg = message.poll();
		if (msg != null) {
			System.out.println("�Ѿ�ת������Ϣ" + msg + "��ǰ������С" + message.size());

		} else {
			System.out.println("û����Ϣ�ɹ�ת��");
		}

		return msg;

	}

}
