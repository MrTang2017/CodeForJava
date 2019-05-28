package com.myoffer.first;

/**
 * 
 * �����ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·���� ·�����ԴӾ����е�����һ�����ӿ�ʼ�� ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ� ��֮�����ٴν���������ӡ� ���� a b c e s f c s a d e e ������3 X 4
 * �����а���һ���ַ���"bcced"��·���� ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
 * ·�������ٴν���ø��ӡ�
 * 
 * @author ����
 *
 */
public class MatrixContainStr {

	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		boolean[] flag = new boolean[matrix.length];// ������飬�߹����ַ�Ϊtrueδ���ʹ���false
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (searchStr(matrix, rows, cols, i, j, flag, 0, str)) {
					return true;
				}
			}
		}
		return false;

	}

	// �ݹ�����
	private static boolean searchStr(char[] matrix, int rows, int cols, int i, int j, boolean[] flag, int k,
			char[] str) {

		int index = i * cols + j;// �����е��±�
		if (i < 0 || i >= rows || j < 0 || j >= cols || 
				matrix[index] != str[k] || flag[index] == true) {
			return false;
		}
		if (k == str.length-1) {
			return true;
		}
		flag[index] = true;
		if (searchStr(matrix, rows, cols, i - 1, j, flag, k + 1, str)
				|| searchStr(matrix, rows, cols, i + 1, j, flag, k + 1, str)
				|| searchStr(matrix, rows, cols, i, j + 1, flag, k + 1, str)
				|| searchStr(matrix, rows, cols, i, j - 1, flag, k + 1, str))
			return true;

		flag[index] = false;
		return false;
	}

	public static void main(String[] args) {

	}

}
