package com.myoffer.first;

import java.util.Scanner;

public class ShuiXianHua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		while(true) {
			int m=in.nextInt();
			int n=in.nextInt();
			int k=(int)Math.pow(n, 1.0/3);
			boolean isE=false;
			for(int i=1;i<=k;i++) {
				for(int j=i+1;j<=k;j++) {
					for(int s=j+1;s<=k;s++) {
						int sum=i*i*i+j*j*j+s*s*s;
						if(sum>=m && sum<=n) {
							isE=true;
							System.out.print(sum+" ");
						}
		
					}
				}
			}
			if(!isE)
				System.out.println("no");
			System.out.println();		
		}
	}
}
