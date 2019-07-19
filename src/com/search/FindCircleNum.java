package com.search;

/*
 * ≈Û”—»¶ ˝¡ø
 */
public class FindCircleNum {

	public static int rows;
	public static int cols;

	public static int findCircleNum(int[][] M) {

		rows = M.length;
		cols = M[0].length;
		int circleNum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (M[i][j] != 0) {
					dfs(M, i, j);
					circleNum++;
				}
			}
		}

		return circleNum;

	}

	private static void dfs(int[][] m, int i, int j) {

		if (i < 0 || i >= rows || j < 0 || j >= cols || m[i][j] == 0) {
			return;
		}
		m[i][j] = 0;
		for (int k = 0; k < cols; k++) {
			dfs(m, j, k);
		}

	}

	public static void main(String[] args) {

		int[][] nums = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(findCircleNum(nums));
	}

}
