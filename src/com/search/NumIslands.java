package com.search;

public class NumIslands {
	

	public static final int[][] directions= {{0,-1},{0,1},{-1,0},{1,0}};
	public static int rows;
	public static int cols;
	
	
	public int numIslands(char[][] grid) {
		if (grid.length==0) {
			return 0;
		}
		rows=grid.length;
		cols=grid[0].length;
		int numsIsland=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if (grid[i][j]!='0') {
					//Éî¶È±éÀú
					liantong(grid,i,j);
					numsIsland++;
				}
				
			}
		}
		return numsIsland;	
		
	}


	private void liantong(char[][] grid, int i, int j) {
		
		if (i<0 || i>=rows || j<0 || j>=cols || grid[i][j]=='0') {
			return;
		}	
		grid[i][j]='0';
		for(int[] direction:directions) {
			liantong(grid, i+direction[0], j+direction[1]);
		}	
	
	}
	
}
