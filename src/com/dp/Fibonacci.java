package com.dp;

public class Fibonacci {
	
	
	/**
	 * 쳲���������
	 * @param args
	 */
	public int fibonacci(int n) {
		//�ݹ�ʵ�֣�top-down����)
		/*if (n<=1) {
			return n;
		}
	   return fibonacci(n-1)+fibonacci(n-2);*/
		
		//bottom-up����
		if (n==1 || n==2) {
			return 1;
		}
		int a1=1;
		int a2=1;
		int sum=0;
		for(int i=3;i<=n;i++) {
			sum=sum+a1+a2;
			a1=a2;
			a2=sum;	
		}
		return sum;
	}
	
	

	public static void main(String[] args) {

	}

}
