package com.myoffer.first;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadFactory implements ThreadFactory {

	private final String namePreix;//�߳�������
	private final AtomicInteger nextId = new AtomicInteger(1);

	public UserThreadFactory(String whatFeatureOfGroup) {
		namePreix = "UserThreadFactory" + whatFeatureOfGroup + "-Worker-";

	}

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		String name = namePreix + nextId.getAndIncrement();
		Thread thread = new Thread(null, r, name, 0);
		System.out.println(thread.getName());
		return thread;
	}

}
