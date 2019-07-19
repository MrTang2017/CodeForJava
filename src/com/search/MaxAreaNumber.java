package com.search;


/**
 * 在一个连通的岛屿中求一个最大岛屿
 * @author 汤吉
 *
 */
public class MaxAreaNumber {
	
	public static final int[][] directions= {{0,-1},{0,1},{-1,0},{1,0}};
	public static int rows;
	public static int cols;
	
	public int maxAreaNumber(int[][] grid) {
		
		rows=grid.length;
		cols=grid[0].length;
		int maxArea=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if (grid[i][j]!=0) {
					maxArea=Math.max(maxArea, liantong(grid,i,j));
				}
				
			}
		}
		return maxArea;	
	}

	private int liantong(int[][] grid, int i, int j) {
		
		if (i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0) {
			return 0;
		}		
		int area=1;
		grid[i][j]=0;
		for(int[] direction:directions) {
			area+=liantong(grid, i+direction[0], j+direction[1]);
		}	
		return area;
	}

	public static void main(String[] args) {
		

	}

}
