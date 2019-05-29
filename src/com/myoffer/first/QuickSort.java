package com.myoffer.first;
/**
 * 快速排序
 * @author 汤吉
 *
 */
public class QuickSort {

	public static void quickSort(int start, int end, int[] nums) {
		if (start < end) {
			//返回关键字排好序的位置
			int index = partition(start, end, nums);
			//对左边的序列递归排序
			quickSort(start, index - 1, nums);
			//对右边的序列递归排序
			quickSort(index + 1, end, nums);
		}
	}

	private static int partition(int start, int end, int[] nums) {
		//选取序列中第一个元素为关键字
		int key = nums[start];
		int i = start;
		int j = end;
		while (i <= j) {
			//找到第一个大于key的元素
			while (i < nums.length && nums[i] <= key) {
				i++;
			}
			//找到第一个不大于Key的元素
			while (j >= 0 && nums[j] > key) {
				j--;
			}
		   //交换
			if (i < j) {
				int swap = nums[i];
				nums[i] = nums[j];
				nums[j] = swap;
				i++;
				j--;
			}
		}
		// 交换
		if (j != start) {
			int swap = nums[j];
			nums[j] = key;
			nums[start] = swap;
		}
		return j;
	}

	public static void main(String[] args) {
		int[]a= {3,4,5,1,2,7,8,6,9,0,5,9,0,7,6,5,8,4,3,2,1,9,8,7,6};
		quickSort(0, a.length-1, a);
		for (int i = 0; i < a.length; i++) {	
			System.out.print(a[i]+" ");
		}

	}

}
