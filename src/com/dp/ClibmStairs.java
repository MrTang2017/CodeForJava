package com.dp;

public class ClibmStairs {
	
	/**
	 * ÅÀÂ¥Ìİ
	 * @param n
	 * @return
	 */

	public int climbStsirs(int n) {
		//µİ¹é
/*		if (n<=2) {
			return n;
		}		
		return climbStsirs(n-1)+climbStsirs(n-2);*/
		
		//¶¯Ì¬¹æ»®
		int[] states=new int[n+1];
		states[0]=1;
		for(int i=1;i<=n;i++) {
			states[i]=(i>=1?states[i-1]:0)+(i>=2?states[i-2]:0);
		}
		
		return states[n];
			
	}
	
	public static void main(String[] args) {
		

	}

}
