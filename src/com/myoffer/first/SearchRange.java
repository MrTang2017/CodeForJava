package com.myoffer.first;

public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		int length = nums.length;
		int left = binarySearch(nums, target);
		int right = binarySearch(nums, target+1)-1;
		if (left==length || nums[right]!=target) {
			return new int[]{-1,-1};
		}
		else {
			return new int[] {left,Math.max(left, right)};
		}
	}
      private int binarySearch(int[] nums, int target) {
		int l=0,r=nums.length;//注意r的取值
		//如果l==r就出现循环，退不出结果
		while(l<r) {
			
			int mid=l+(r-l)/2;
			if (nums[mid]>=target) {
				r=mid;
			}else {
				l=mid+1;
			}	
		}
		return l;
	}

	public static void main(String[] args) {

		
		int[] nums= {2,3,3,4,4,5,6,7,8,9,9};
		int[] result=new SearchRange().searchRange(nums, 9);
		System.out.println(result[0]+" "+result[1]);
	}

}
