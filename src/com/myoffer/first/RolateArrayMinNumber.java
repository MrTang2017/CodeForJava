package com.myoffer.first;

public class RolateArrayMinNumber {
	public static int minNumberInRotateArray(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (array[mid] >= array[left])
				left = mid + 1;
			else
				right = mid;
		}
		return array[mid];
	}

	public static void main(String[] args) {
		int[] array = {3,4,5,1,2};
		System.out.println(minNumberInRotateArray(array));

	}

}
