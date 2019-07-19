package com.backtracking;

/**
 * 在矩阵中寻找指定字符串
 * @author 汤吉
 *
 */
public class Exist {
	
	
	public static final int[][] directions= {{0,-1},{0,1},{-1,0},{1,0}};
	public static int rows;
	public static int cols;
	public static String pword;
	public static int[][] visited;
	public boolean exist(char[][] board, String word) {
		pword=word;
		rows=board.length;
		cols=board[0].length;
		StringBuilder prefix=null;
		visited=new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for(int j=0;j<cols;j++) {
				if (board[i][j]==pword.charAt(0)) {
					prefix=new StringBuilder();
					if (df(board,i,j,prefix)) {
						return true;
					}
				}
			}
			
		}	
		return false;	
	}
	/**
	 * 回溯法求解：
	 * 在访问一个新元素进入新的递归调用时，
	 * 需要将新元素标记为已经访问，这样才能在继续递归调用时不用重复访问该元素；
	 * 但是在递归返回时，需要将元素标记为未访问，因为只需要保证在一个递归链中不同时访问一个元素，
	 * 可以访问已经访问过但是不在当前递归链中的元素。
	 * @param board
	 * @param i
	 * @param j
	 * @param prefix
	 * @return
	 */
	private boolean df(char[][] board, int i, int j,StringBuilder prefix) {
		
		int curLength=prefix.length();
		
		if (curLength==pword.length() && prefix.toString().equals(pword)) {
			return true;
		}
		
		if (i<0 || i>=rows || j<0 || j>=cols || 
				board[i][j]!=pword.charAt(curLength) || visited[i][j]==1) {
			return false;
		}
		prefix.append(board[i][j]);
		visited[i][j]=1;
		for(int[] direction:directions) {	
			if (df(board, i+direction[0], j+direction[1], prefix)) {
				return true;
			}	
		}	
		//恢复未访问
		visited[i][j]=0;
		//递归删除
		prefix.deleteCharAt(prefix.length()-1);
		return false;
	}
	public static void main(String[] args) {
		
		char[][] test= {{'A','B'},{'C','D'}};
		Exist exist=new Exist();
		System.out.println(exist.exist(test, "ABCD"));	

	}

}
