package com.myoffer.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含正负数的数组，要求返回累计和为k的序列的最长长度
 * 
 * @author 汤吉
 *
 */
public class NiuKeDemo1 {

	public static int LongestSumSubArrayLength(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;// 当前元素的前缀和
		int len = 0;// 记录最大长度
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];// 求和
			//判断是否包含以前元素结尾的最早出现(sum-k)
			if (map.containsKey(sum - k)) {
				//记录最大长度
				len = Math.max(i - map.get(sum - k), len);
				map.put(sum, i);
			} else if (!map.containsKey(sum-k)) {
				map.put(sum, i);
			}
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1, 0, 1, 2, 1, 2, 1, 1, 4, -1, 0, 1, 2 };
		int result = LongestSumSubArrayLength(arr, 6);
		System.out.println(result);
	}
}
