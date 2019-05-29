package com.myoffer.first;

/**
 * 归并排序
 * 
 * @author 汤吉
 *
 */
public class MergeSort {

	public static void mergeSort(int[] nums, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			// 递归划分
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			// 合并
			merge(nums, left, mid, right);

		}
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int copy[] = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (nums[i] < nums[j]) {
				copy[k++] = nums[i];
				i++;
			} else {
				copy[k++] = nums[j];
				j++;

			}

		}
		while (i <= mid) {
			copy[k++] = nums[i];
			i++;
		}
		while (j <= right) {
			copy[k++] = nums[j];
			j++;
		}

		// 复制
		for (int s = 0; s < copy.length; s++) {
			nums[left++] = copy[s];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 49, 38, 65, 97, 76, 13, 27 };

		mergeSort(nums, 0, nums.length - 1);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
