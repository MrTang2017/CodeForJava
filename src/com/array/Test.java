package com.array;

import java.util.PriorityQueue;

public class Test implements Comparable<Test>{
	int val;
	public Test(int value) {
		this.val=value;
	}
	
	@Override
     public int compareTo(Test that) {
	
	     return that.val-this.val;
	}

	public static void main(String[] args) {
		Test tuple=new Test(4);
		Test tuple2=new Test(5);
		PriorityQueue<Test> priorityQueue=new PriorityQueue<>();
		priorityQueue.offer(tuple);
		priorityQueue.offer(tuple2);
		System.out.println(priorityQueue.peek().val);
		
	}

}
