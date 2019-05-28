package com.myoffer.first;

/**
 * 假设有一个象棋盘，棋盘的横坐标有9条线 纵坐标有10条线，假设“马”处的位置为(1，0) 问k步走到(x,y)的方法有多少种
 * 
 * @author 汤吉
 *
 */
public class HorseStepMethodNum {

	public static int getValue(int x, int y, int step) {
		return process(x, y, step);

	}

	/**
	 * 暴力递归求解
	 * 
	 * @param x
	 * @param y
	 * @param step
	 * @return
	 */
	private static int process(int x, int y, int step) {
		// 越界
		if (x < 0 || y < 0 || x > 8 || y > 9) {
			return 0;
		}
		// 在最初位置，不动
		if (step == 0) {
			return (x == 1 && y == 0) ? 1 : 0;
		}
		return process(x - 1, y + 2, step - 1) + process(x - 1, y - 2, step - 1) + process(x - 2, y - 1, step - 1)
				+ process(x - 2, y + 1, step - 1) + process(x + 1, y + 2, step - 1) + process(x + 1, y - 2, step - 1)
				+ process(x + 2, y + 1, step - 1) + process(x + 2, y - 1, step - 1);
	}

	public static void main(String[] args) {
		System.out.println(getValue(2, 4, 5));

	}

}
