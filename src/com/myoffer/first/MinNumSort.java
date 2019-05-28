package com.myoffer.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最少移动次数使数组排序
 * @author 汤吉
 *
 */
public class MinNumSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int i = 0;
		while (n-- > 0) {
			nums[i++] = sc.nextInt();
		}
		int[] copyNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyNums);
		int j = 0;
		int count = 0;
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] == copyNums[j]) {
				count++;
				j++;
			}
		}
		System.out.println(nums.length-count);
		sc.close();
	}

}
