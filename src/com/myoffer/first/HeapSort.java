package com.myoffer.first;

/**
 * �������ѣ����д�С��������
 * 
 * @author ����
 *
 */
public class HeapSort {

	public static void myHeapSort(int[] nums) {
		int len = nums.length;
		// ��С����
		for (int i = len / 2 - 1; i >= 0; i--) {
			//�ϸ�����
			adjustHeap(i, len, nums);
		}
		// �³�����
		for (int j = len - 1; j >= 0; j--) {
			swap(0, j, nums);
			adjustHeap(0, j, nums);
		}
	}

	private static void adjustHeap(int i, int len, int[] nums) {
		while (2 * i + 1 < len) {
			int child = 2 * i + 1;// ���ӽڵ�
/*			if (child < len && (child + 1 < len && nums[child] > nums[child + 1]))
				child++;
			// �ӽڵ㵱����С��һ�����ڸ��ڵ�
			if (nums[child] > nums[i])
				break;
			swap(i, child, nums);*/
			if (child < len && (child + 1 < len && nums[child] < nums[child + 1]))
				child++;
			// �ӽڵ㵱������һ��С�ڸ��ڵ�
			if (nums[child] < nums[i])
				break;
			swap(i, child, nums);
			i = child;
		}
	}

	private static void swap(int i, int child, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[child];
		nums[child] = temp;
	}

	public static void main(String[] args) {

		int[] nums = { 5, 4, 9, 8, 7, 6, 0, 1, 3, 2 };
		myHeapSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

}
