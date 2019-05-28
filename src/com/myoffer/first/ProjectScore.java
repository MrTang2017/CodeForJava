package com.myoffer.first;

import java.util.Arrays;

public class ProjectScore {
	
	public static int minNumbers(int nums,int p,int r,int[] scores) {
		int count=0;
		while(!isZeros(scores)) {
			int max=0;
			Arrays.sort(scores);
			max=scores[nums-1];
			update(scores,max,p,r);
			count++;			
		}
		return count;
	}
	
	private static void update(int[] scores, int max, int p, int r) {
		boolean flag=false;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i]>0) {
				if (!flag && scores[i]==max && max>=p) {
					scores[i]-=p;
					flag=true;
				}
				else
					scores[i]-=r;
			}
		}	
	}

	private static boolean isZeros(int[] scores) {
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i]!=0) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		int[] a= {5,3,2,4};
		System.out.println(ProjectScore.minNumbers(4, 2, 1, a));
	}

}
