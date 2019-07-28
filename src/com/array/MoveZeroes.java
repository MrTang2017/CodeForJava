package com.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @author 汤吉
 *
 */
public class MoveZeroes {

	
    public void moveZeroes(int[] nums) {
       // Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++) {
        	if (nums[i]==0) {
        		count+=1;
				continue;
			}
        	if (count!=0) {
        		//交换
        		int temp=nums[i];
        		nums[i]=nums[i-count];
        		nums[i-count]=temp;			
			}
        }
    	
    	
    }
	
	
	public static void main(String[] args) {

		int nums[] = { 2,1};
		new MoveZeroes().moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}
