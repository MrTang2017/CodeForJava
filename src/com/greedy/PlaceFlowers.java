package com.greedy;

/**
 *  数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花
 * @author 汤吉
 * 例如：[1,0,0,0,1],1
 * 输出：true
 * 输入：[1,0,0,0,1],2
 * 输出：false
 *
 */

public class PlaceFlowers {

	public static boolean canPlaceFlowers(int[] flowered,int n) {
		int count=0;//能种植的个数
		for(int i=0;i<flowered.length && count<n;i++) {
			if (flowered[i]==1) {
				continue;
			}		
			//此时等于0，获得相邻的种植情况
			int pre=i==0?0:flowered[i-1];
			int next=i==flowered.length-1?0:flowered[i+1];
			if(pre==0 && next==0) {
				count++;
				flowered[i]=1;
			}				
		}	
		return count>=n;	
	}
	
	public static void main(String[] args) {
		
		int[] flowered= {1,0,0,1,0,0,1,0,1,0,0,0,1};
		System.out.println(canPlaceFlowers(flowered, 1));
		
		

	}

}
