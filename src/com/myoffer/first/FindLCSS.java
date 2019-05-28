package com.myoffer.first;

public class FindLCSS {
    public static int findLcs(String s1,String s2) {
    	int l1=s1.length();
    	int l2=s2.length();
    	String[] str1=s1.split("");
    	String[] str2=s2.split("");
    	int[][] dp=new int[l1+1][l2+1];
    	for(int i=1;i<=l1;i++) {
    		for(int j=1;j<=l2;j++) {
    			dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    			if(str1[i-1].equals(str2[j-1]))
    				dp[i][j]=Math.max(dp[i-1][j-1]+1, dp[i][j]);
    		}
    	}
    	return dp[l1][l2];//最长公共子串的长度
    	
	}
	public static void main(String[] args) {
		String str1="1A2C3D4B56";
		String str2="B1D23CA45B6A";
		System.out.println(findLcs(str1, str2));		
	}

}
