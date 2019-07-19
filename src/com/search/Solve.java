package com.search;

/**
 * Χ������
 * leetcode:130��
 * @author ����
 *
 */
public class Solve {

	public static final int[][] directions= {{0,-1},{0,1},{-1,0},{1,0}};
	public static int rows;
	public static int cols;
	
	public void solve(char[][] board) {
		rows=board.length;
		cols=board[0].length;
		//���ҵ���߽���ͨ��O,���б��,Ȼ���ڱ�������,û����ǵ�O���ǿ��Ա�
		//����Χ��
		
		for(int i=0;i<rows;i++) {
			df(board,i,0);
			df(board, i, cols-1);
		}
		for(int j=1;j<cols-1;j++) {
			df(board,0,j);
			df(board, rows-1, j);
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if (board[i][j]=='F') {
					board[i][j]='O';
				}else if (board[i][j]=='O') {
					board[i][j]='X';
				}
				
			}
		}	
		
	}
	private void df(char[][] board, int i, int j) {
		
		if (i<0 || i>=rows || j<0 || j>=cols || board[i][j]!='O') {
			return;
		}
		board[i][j]='F';
		for(int[] direction:directions) {
			df(board, i+direction[0], j+direction[1]);
		}
		
		
	}
	public static void main(String[] args) {
		Solve solve=new Solve();
		char[][] b= {{'X','O','O','X'},{'X','O','O','X'},{'X','O','O','O'}};
	    solve.solve(b);
	    for(char[] cs:b) {
	    	System.out.println(cs[0]+" "+cs[1]+" "+cs[2]+" "+cs[3]);
	    }
	}

}
