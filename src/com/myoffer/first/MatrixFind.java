package com.myoffer.first;

/**
 * 
 * ��ָOffer������4���������в�������(ÿһ�е�����ÿһ�е���)
 * 
 * @author ����
 *
 */
public class MatrixFind {

	/**
	 * �ж϶�λ�������Ƿ��в��ҵ���
	 * 
	 * @param matrix����λ����
	 * @param rows������
	 * @param columns������
	 * @param number�����ҵ���
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
		// ����
		int[][] numbers = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }};
		System.out.println(numbers.length);
		System.out.println(findNumber(numbers, 3, 3, 5));

	}

}
