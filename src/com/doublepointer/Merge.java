package com.doublepointer;

public class Merge {

	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	   
		 int i=0,j=0;
		 int count=0;
		 while(i<m && j<n) {
			 
			 if (nums1[i]<nums2[j]) {
				 i++;
				
			}
			 else {
				 //i的之后的元素向后移以为
				 backward(nums1,i,m,n);
				 nums1[i]=nums2[j];
				 count++;
				 i++;
				 j++;
			 }
			 	 
		 }
		 i=i+count;
		 while(j<n) {
			 nums1[i++]=nums2[j++];
		 }
		 
		  	  
	 }

	private void backward(int[] nums1, int i, int m,int n) {
		for(int j=m+n;j>i;j--) {
			nums1[j]=nums1[j-1];
		}
		
	} 
	
	public static void main(String[] args) {
		int[] nums1= {1,2,3,0,0,0,0};
		int[] nums2= {2,3,4};
		new Merge().merge(nums1, 3, nums2, 3);
		for(int k=0;k<nums1.length;k++)
			System.out.print(nums1[k]+" ");
	}
}
