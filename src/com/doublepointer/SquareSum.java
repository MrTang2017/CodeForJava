package com.doublepointer;

public class SquareSum {
	
	public boolean squareSum(int target) {
		int i = 1, j = (int) Math.sqrt(target);
		
		while(i<j) {
			int sum=i*i+j*j;
			if (sum==target) {
				return true;
			}
			if (sum>target) {
				j--;
			}
			else {
				i++;
			}
			
			
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new SquareSum().squareSum(10));

	}

}
