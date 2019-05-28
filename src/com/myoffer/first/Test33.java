package com.myoffer.first;
/**
 * 判断一个矩形内星星的数量
 */
import java.util.Scanner;

/**
 * 4
1 1
2 2
3 3
1 3
4
1 1 2 2
1 1 3 3
2 2 3 3
1 2 2 3
 * @author 汤吉
 *
 */
public class Test33 {

	public static void main(String[] args) {	
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[][] dp=new int[1001][1001];
		int[][] mp=new int[1001][1001];
		int x=0,y=0;
		while(n-->0) {
			x=scanner.nextInt();
			y=scanner.nextInt();
			mp[x][y]=1;
		}
		for(int i=1;i<1001;i++) {
			for(int j=1;j<1001;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+mp[i][j];
			}
		}
		int m=scanner.nextInt();
		while(m-->0) {
			int x1=scanner.nextInt();
			int y1=scanner.nextInt();
			int x2=scanner.nextInt();
			int y2=scanner.nextInt();
			System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
		}
		scanner.close();
	}

}
