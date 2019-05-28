package com.myoffer.first;

public class MaxGiftPlace {

	
	public static int maxGiftPlace(int[][] values,int cols,int rows) {
		int sum=0;
		for (int i = 0; i < rows; i++) {
			sum=sum+values[0][i];
			values[0][i]=sum;
		}
		sum=0;
		for(int j=0;j<cols;j++) {
			sum=sum+values[j][0];
			values[j][0]=sum;
		}
		int max=0;
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				max=values[i-1][j]>values[i][j-1]?values[i-1][j]:values[i][j-1];
				values[i][j]=max+values[i][j];	
			}
		}
		return values[rows-1][cols-1];	
	}
	public static int maxGiftPlace2(int[][] values,int cols,int rows) {
		
		int[] maxValues=new int[cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				int up=0;
				int left=0;
				if (i>0) {
					up=maxValues[j];
				}
				if (j>0) {
					left=maxValues[j-1];
				}	
				maxValues[j]=Math.max(up, left)+values[i][j];			
			}
		}
		return maxValues[cols-1];	
	}
	
	
	public static void main(String[] args) {
		int[][] test= {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		System.out.println(maxGiftPlace2(test, 4, 4));
		

	}

}
