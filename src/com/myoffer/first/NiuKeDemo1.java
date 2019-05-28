package com.myoffer.first;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ�����������������飬Ҫ�󷵻��ۼƺ�Ϊk�����е������
 * 
 * @author ����
 *
 */
public class NiuKeDemo1 {

	public static int LongestSumSubArrayLength(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;// ��ǰԪ�ص�ǰ׺��
		int len = 0;// ��¼��󳤶�
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];// ���
			//�ж��Ƿ������ǰԪ�ؽ�β���������(sum-k)
			if (map.containsKey(sum - k)) {
				//��¼��󳤶�
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
