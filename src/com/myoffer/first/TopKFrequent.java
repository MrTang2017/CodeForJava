package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定一个非空的整数数组，返回其中出现频率前 k 高的元素
 * 
 * @author 汤吉
 *
 */
public class TopKFrequent {

	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		// 先统计每个元素的频率
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		// 初始化数个桶,下标为频率
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(key);
		}

		// 求topK
		List<Integer> result = new ArrayList<>();
		for (int j = buckets.length - 1; j >= 1 && result.size() < k; j--) {
			if (buckets[j] != null) {
				if (buckets[j].size() <= (k - result.size())) {
					result.addAll(buckets[j]);
				} else {
					result.addAll(buckets[j].subList(0, k - result.size()));
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1, 1, 1, 2, 4, 2, 3, 4, 5, 6, 3, 4, 5, 6 };
		List<Integer> list = topKFrequent(nums, 3);
		for (int k : list)
			System.out.println(k + " ");
	}

}
