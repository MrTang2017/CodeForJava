package com.greedy;

/**
 *  ������ 1 ��ʾ�Ѿ������˻��䡣����֮��������Ҫһ����λ�ļ��������Ƿ������� n �仨
 * @author ����
 * ���磺[1,0,0,0,1],1
 * �����true
 * ���룺[1,0,0,0,1],2
 * �����false
 *
 */

public class PlaceFlowers {

	public static boolean canPlaceFlowers(int[] flowered,int n) {
		int count=0;//����ֲ�ĸ���
		for(int i=0;i<flowered.length && count<n;i++) {
			if (flowered[i]==1) {
				continue;
			}		
			//��ʱ����0��������ڵ���ֲ���
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
