package com.array;

/**
 *
 * @author ����
 *
 */
public class RemoveDuplicates {
	
	
	
	/**
	 * ����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�
	 * ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³���
	 * @param nums
	 * @return
	 */
	 public int removeDuplicates(int[] nums) {
	   if (nums.length==0) {
			return 0;
		}
	    int size=nums.length;
	    int point=1;
	    for(int i=1;i<nums.length;i++) {
	    	if (nums[i]==nums[i-1]) {
	    		size--;
			}
	    	else {
				nums[point++]=nums[i];
			}
	    	
	    }
	  return size;
	 
	 }
	public static void main(String[] args) {
		int[] nums= {0,0,1,1,1,2,2,3,3,4};
		System.out.println(new RemoveDuplicates().removeDuplicates(nums));
	
	}

}
