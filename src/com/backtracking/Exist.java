package com.backtracking;

/**
 * �ھ�����Ѱ��ָ���ַ���
 * @author ����
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
	 * ���ݷ���⣺
	 * �ڷ���һ����Ԫ�ؽ����µĵݹ����ʱ��
	 * ��Ҫ����Ԫ�ر��Ϊ�Ѿ����ʣ����������ڼ����ݹ����ʱ�����ظ����ʸ�Ԫ�أ�
	 * �����ڵݹ鷵��ʱ����Ҫ��Ԫ�ر��Ϊδ���ʣ���Ϊֻ��Ҫ��֤��һ���ݹ����в�ͬʱ����һ��Ԫ�أ�
	 * ���Է����Ѿ����ʹ����ǲ��ڵ�ǰ�ݹ����е�Ԫ�ء�
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
		//�ָ�δ����
		visited[i][j]=0;
		//�ݹ�ɾ��
		prefix.deleteCharAt(prefix.length()-1);
		return false;
	}
	public static void main(String[] args) {
		
		char[][] test= {{'A','B'},{'C','D'}};
		Exist exist=new Exist();
		System.out.println(exist.exist(test, "ABCD"));	

	}

}
