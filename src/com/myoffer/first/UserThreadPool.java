package com.myoffer.first;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadPool {

	public static void main(String[] args) {
		// 缓存队列大小设置为2，尽快触发rejectHandler
		BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(2);

		// 假设外部任务线程的来源由机房1和机房2混合调用
		UserThreadFactory f1 = new UserThreadFactory("第一机房");
		UserThreadFactory f2 = new UserThreadFactory("第二机房");

		UserRejectHandler handler = new UserRejectHandler();
		// 利用第一个用户线程工厂创建第一个线程池
		ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);
		// 利用第二个线程工厂创建第二个线程池
		ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

		// 任务执行体
		Runnable task = new Runnable() {
			private final AtomicInteger count = new AtomicInteger(0);

			@Override
			public void run() {
				System.out.println("running" + count.getAndIncrement());
			}
		};

		// 创建400个线程
		for (int i = 0; i < 200; i++) {
			threadPool1.execute(task);
			threadPool2.execute(task);
		}

	}

}
