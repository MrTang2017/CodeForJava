package com.myoffer.first;

/**
 * 寻找数组中只出现一次的两个数，其他书都出现2次
 * 
 * @author 汤吉
 *
 */
public class FindTwoNumApearOnce {

	public static int[] findTwoNumsApearOnce(int[] nums) {
		int[] result = new int[2];
		int resultOR = 0;
		for (int i = 0; i < nums.length; i++) {
			resultOR ^= nums[i];
		}
		//找到最右边的1的位置
		int index = findBit1(resultOR);
		System.out.println(index);
		//根据该位置是1还是0进行分组
		int result1OR = 0;
		int result2OR = 0;
		for (int i = 0; i < nums.length; i++) {
			//判断该为是否为1
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
		 * 判断i二进制最右边1的位置是否是index
		 */
		i=i>>index;
		return (i & 1)!=0?true:false;
	}

	private static int findBit1(int resultOR) {
		/**
		 * 判断从右边起，二进制1的位置
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
