// 2293번 
// 동전 1 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;

public class BJ2293 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int k = stdIn.nextInt();
		int[] coin = new int[N+1];
		for(int i=1;i<=N;i++) {
			coin[i] = stdIn.nextInt();
		}
		System.out.print(dp(coin, k));		
	}
	static int dp (int[] c, int k) {
		int[][] d = new int[c.length][k+1];
		d[0][0] = 1;
		for(int i=1;i<=k;i++) { // 0~10
			d[0][i] = 0;
		}
		for(int i=1;i<c.length;i++) {
			for(int j=0;j<=k;j++) {
				if(c[i]>j)
					d[i][j] = d[i-1][j];
				else
					d[i][j] = d[i][j-c[i]] + d[i-1][j];
			}
		}
		return d[c.length-1][k];
	}
}
