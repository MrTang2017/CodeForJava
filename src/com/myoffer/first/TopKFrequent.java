package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ��
 * 
 * @author ����
 *
 */
public class TopKFrequent {

	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		// ��ͳ��ÿ��Ԫ�ص�Ƶ��
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		// ��ʼ������Ͱ,�±�ΪƵ��
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(key);
		}

		// ��topK
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
