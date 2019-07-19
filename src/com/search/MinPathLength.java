package com.search;

import java.util.LinkedList;
import java.util.Queue;


/**
 * BFS广度优先搜索，对于无向图来说，可以求最短路径长度
 * @author 汤吉
 *
 */
public class MinPathLength {

	static class Pair<Item1, Item2> {

		private int i;
		private int j;

		public Pair(Item1 i, Item2 j) {
			this.i = (Integer) i;
			this.j = (Integer) j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

	}

	public static int minPathLength(int[][] grid, int tr, int tc) {

		int minPathLength = 0;
		int m = grid.length, n = grid[0].length;
		final int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(0, 0));
		while (queue.size() != 0) {
			int size = queue.size();
			minPathLength++;
			while (size-- > 0) {
				Pair<Integer, Integer> pair = queue.poll();
				int x = pair.getI();
				int y = pair.getJ();
				grid[x][y] = 0;
				for (int[] direction : directions) {
					int newX = x + direction[0];
					int newY = y + direction[1];
					if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 0) {
						continue;
					}
					if (newX == tr && newY == tc) {
						return minPathLength;
					}
					queue.add(new Pair<>(newX, newY));
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[][] paths= {{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
		System.out.println(minPathLength(paths, 3, 3));
	}

}
