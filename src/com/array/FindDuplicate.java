package com.array;

import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * 寻找重复的数
 * @author 汤吉
 *给定一个包含 n + 1 个整数的数组 nums，
 *其数字都在 1 到 n 之间（包括 1 和 n），
 *可知至少存在一个重复的整数。假设只有一个重复的整数，
 *找出这个重复的数。

 */

public class FindDuplicate {
	
	/*
	 * 2ms，o(n)空间
	 */
	 public int findDuplicate(int[] nums) {
		     int dup=0; 
	        int countOfNums[]=new int[nums.length];
	        for(int i=0;i<nums.length;i++) {
	        	countOfNums[nums[i]]++;
	        }
	        
	        for(int i=1;i<countOfNums.length;i++) {
	        	if (countOfNums[i]>1) {
	        		dup=i;
	        		break;
				}
	        }
	             
	      return dup;  
 
	 }
	 
	 /**
	  * 1ms,O(1)空间
	  * @param nums
	  * @return
	  */
	 public int findDuplicate2(int[] nums) {
	  int slow=0,fast=0;
	  while(true) {
		  fast=nums[nums[fast]];
		  slow=nums[slow];
		  if (fast==slow) {
			fast=0;
			while(nums[slow]!=nums[fast]) {
				fast=nums[fast];
				slow=nums[slow];
			}
			return nums[slow];
		}
	  }
		 

 }
	
	

}
