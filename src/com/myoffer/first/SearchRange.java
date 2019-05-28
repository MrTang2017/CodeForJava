package com.myoffer.first;

public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		int length = nums.length;
		int start = 0;
		int end = length - 1;
		int getFirstK = GetFirstK(nums, length, target, start, end);
		int getLastK = GetLastK(nums, length, target, start, end);
		int []result= {getFirstK,getLastK};
		return result;
	}

	public int GetFirstK(int[] nums, int length, int target, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = nums[mid];
		if (midData == target) {
			if ((mid > 0 && nums[mid - 1] != target) || mid == 0)
				return mid;
			else
				end = mid - 1;
		} else if (midData > target)
			end = mid - 1;
		else
			start = mid + 1;
		return GetFirstK(nums, length, target, start, end);
		
	}

	public int GetLastK(int[] nums, int length, int target, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = nums[mid];
		if (midData == target) {
			if ((mid < length - 1 && nums[mid + 1] != target) || mid == length - 1)
				return mid;
			else
				end = mid - 1;
		} else if (midData > target)
			end = mid - 1;
		else
			start = mid + 1;
		return GetLastK(nums, length, target, start, end);
	}

	public static void main(String[] args) {

	}

}
