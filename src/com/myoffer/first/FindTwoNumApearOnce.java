package com.myoffer.first;

/**
 * Ѱ��������ֻ����һ�ε��������������鶼����2��
 * 
 * @author ����
 *
 */
public class FindTwoNumApearOnce {

	public static int[] findTwoNumsApearOnce(int[] nums) {
		int[] result = new int[2];
		int resultOR = 0;
		for (int i = 0; i < nums.length; i++) {
			resultOR ^= nums[i];
		}
		//�ҵ����ұߵ�1��λ��
		int index = findBit1(resultOR);
		System.out.println(index);
		//���ݸ�λ����1����0���з���
		int result1OR = 0;
		int result2OR = 0;
		for (int i = 0; i < nums.length; i++) {
			//�жϸ�Ϊ�Ƿ�Ϊ1
			if (isBit1(nums[i],index))
				result1OR ^= nums[i];
			else
				result2OR ^= nums[i];
		}
		result[0] = result1OR;
		result[1] = result2OR;
		return result;
	}

	private static boolean isBit1(int i, int index) {
		/**
		 * �ж�i���������ұ�1��λ���Ƿ���index
		 */
		i=i>>index;
		return (i & 1)!=0?true:false;
	}

	private static int findBit1(int resultOR) {
		/**
		 * �жϴ��ұ��𣬶�����1��λ��
		 */
		int indexOf1 = 0;
		while ((resultOR & 1) == 0 && (indexOf1 < 32)) {
			resultOR = resultOR >> 1;
			indexOf1 += 1;
		}
		return indexOf1;
	}

	public static void main(String[] args) {
		int[] test = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] result = findTwoNumsApearOnce(test);
		System.out.println(result[0] + " " + result[1]);
	}

}
