package com.myoffer.first;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinRefulStops {

	public static int minRefulStops(int nums,int[] miles,int[] gas, int dis, int initGas) {
		int res;
		Queue<Integer> queue=new PriorityQueue<>();
		int i=0;
		for (res = 0; initGas<dis; res++) {
			while(i<nums && miles[i]<=initGas) {			
				queue.offer(-gas[i++]);
			}		
			if (queue.isEmpty()) {
				return -1;
			}
			initGas-=queue.poll();		
		}
		return res;
		
	}
	public static void main(String[] args) {
		int[] a= {5,7,10};
		int[] b= {2,3,3};
		int result=MinRefulStops.minRefulStops(3, a, b, 15, 10);
		System.out.println(result);

	}

}
