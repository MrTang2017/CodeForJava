package com.myoffer.first;

public class RobotPath {
	static int count = 0;

	public static int movingCount(int threshold, int rows, int cols) {

		boolean[] flag = new boolean[rows * cols];
		boolean isFlag=lessThreshold(rows, cols, 0, 0, flag, threshold);
		if (isFlag) {
			return count;
		}
		return count;
	}

	public static boolean lessThreshold(int rows, int cols, int i, int j, boolean[] flag, int threshold) {
		int index = i * cols + j;
		int sum = xySum(i, j);
		if (i < 0 || i >= rows || j < 0 || j >= cols || sum > threshold || flag[index] == true)
			return false;
		count++;
		flag[index] = true;
		if (lessThreshold(rows, cols, i, j - 1, flag, threshold) || lessThreshold(rows, cols, i, j + 1, flag, threshold)
				|| lessThreshold(rows, cols, i - 1, j, flag, threshold)
				|| lessThreshold(rows, cols, i + 1, j, flag, threshold))
			return true;
		//这一条路已经走完，不必再走其他路
		//flag[index] = false;
		return false;
	}

	public static int xySum(int x, int y) {
		// x和y的数位之和
		int sum = 0;
		while (x != 0) {
			sum += x % 10;
			x = x / 10;
		}
		while (y != 0) {
			sum += y % 10;
			y = y / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(RobotPath.movingCount(4, 4, 4));

	}

}
