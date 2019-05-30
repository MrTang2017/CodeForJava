package com.myoffer.first;

/**
 * ����һ��ֻ�����������������飬 ÿ��Ԫ�ض���������Σ� Ψ��һ����ֻ�����һ�Σ��ҳ��������
 * 
 * @author ����
 *
 */
public class SingleNonDuplicate {

	public static int singleNonDuplicate(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1])
				l = mid + 2;
			else
				r = mid;
		}
		return nums[l];

	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		System.out.println(singleNonDuplicate(nums));
	}

}
