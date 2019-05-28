package com.myoffer.first;

/**
 * 
 * 剑指Offer面试题4：在数组中查找数字(每一行递增，每一列递增)
 * 
 * @author 汤吉
 *
 */
public class MatrixFind {

	/**
	 * 判断二位数组中是否有查找的数
	 * 
	 * @param matrix：二位数组
	 * @param rows：行数
	 * @param columns：列数
	 * @param number：查找的数
	 * @return
	 */
	private static boolean findNumber(int[][] matrix, int rows, int columns, int number) {

		if (matrix.length == 0 || number < 0) {
			return false;
		}

		int row = 0, column = columns - 1;
		while (row < rows && column >= 0) {
			if (matrix[row][column] == number) {
				return true;
			} else {
				if (matrix[row][column] < number) {
					row += 1;
				} else {
					column -= 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// 测试
		int[][] numbers = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }};
		System.out.println(numbers.length);
		System.out.println(findNumber(numbers, 3, 3, 5));

	}

}
