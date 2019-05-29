package com.myoffer.first;
/**
 * ��������
 * @author ����
 *
 */
public class QuickSort {

	public static void quickSort(int start, int end, int[] nums) {
		if (start < end) {
			//���عؼ����ź����λ��
			int index = partition(start, end, nums);
			//����ߵ����еݹ�����
			quickSort(start, index - 1, nums);
			//���ұߵ����еݹ�����
			quickSort(index + 1, end, nums);
		}
	}

	private static int partition(int start, int end, int[] nums) {
		//ѡȡ�����е�һ��Ԫ��Ϊ�ؼ���
		int key = nums[start];
		int i = start;
		int j = end;
		while (i <= j) {
			//�ҵ���һ������key��Ԫ��
			while (i < nums.length && nums[i] <= key) {
				i++;
			}
			//�ҵ���һ��������Key��Ԫ��
			while (j >= 0 && nums[j] > key) {
				j--;
			}
		   //����
			if (i < j) {
				int swap = nums[i];
				nums[i] = nums[j];
				nums[j] = swap;
				i++;
				j--;
			}
		}
		// ����
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
