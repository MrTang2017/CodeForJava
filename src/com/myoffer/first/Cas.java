package com.myoffer.first;

import java.util.concurrent.atomic.AtomicInteger;

public class Cas {

//	public static int count = 0;
    public static AtomicInteger count=new AtomicInteger(0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					for (int j = 0; j < 100; j++) {
						count.incrementAndGet();
					}
				}
			}).start();

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count.get());
	}
}
