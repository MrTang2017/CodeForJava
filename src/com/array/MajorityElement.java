package com.array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * @author 汤吉
 *
 */
public class MajorityElement {
	
	
	
     public int majorityElement(int[] nums) {
        
        
        Arrays.sort(nums);
        return nums[nums.length/2];
        
        
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
