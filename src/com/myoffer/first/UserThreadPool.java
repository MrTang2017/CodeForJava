package com.myoffer.first;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadPool {

	public static void main(String[] args) {
		// ������д�С����Ϊ2�����촥��rejectHandler
		BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(2);

		// �����ⲿ�����̵߳���Դ�ɻ���1�ͻ���2��ϵ���
		UserThreadFactory f1 = new UserThreadFactory("��һ����");
		UserThreadFactory f2 = new UserThreadFactory("�ڶ�����");

		UserRejectHandler handler = new UserRejectHandler();
		// ���õ�һ���û��̹߳���������һ���̳߳�
		ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);
		// ���õڶ����̹߳��������ڶ����̳߳�
		ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

		// ����ִ����
		Runnable task = new Runnable() {
			private final AtomicInteger count = new AtomicInteger(0);

			@Override
			public void run() {
				System.out.println("running" + count.getAndIncrement());
			}
		};

		// ����400���߳�
		for (int i = 0; i < 200; i++) {
			threadPool1.execute(task);
			threadPool2.execute(task);
		}

	}

}
