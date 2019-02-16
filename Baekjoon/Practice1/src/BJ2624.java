// 2624번  
// 동전 바꿔주기  
// 동적 계획법 (Dynamic Programming) 
// 어려움..

// https://mygumi.tistory.com/254

import java.util.Scanner;

public class BJ2624 {
	static int[][] coin;
	static int[][] dp = new int[10001][101];
	
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();
		int k = stdIn.nextInt();
		coin = new int[k][2];
		
		
		for(int i=0;i<k;i++) {
			coin[i][0] = stdIn.nextInt(); // cost
			coin[i][1] = stdIn.nextInt(); // count 
		}
		
		changeCoin(T,k);
	}
	// changeCoin 
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// Bottom-Up 방식 
	static void changeCoin(int m, int n) {
		for(int i=1;i<=n;i++) {
			int v = coin[i-1][0];
			int c = coin[i-1][1];
			dp[0][i-1] = 1;
			for(int j=1;j<=c;j++) {
				for(int k=v*j;k<=m;k++) {
					dp[k][i] += dp[k-(v*j)][i-1];
					// dp[n][k] = n원일 때 동전 k개까지 사용했을 때의 경우의 수
				    // dp[n][k] = dp[n][k] + dp[n - v * c][k - 1]
				}
			}
			for(int j=1;j<=m;j++) {
				dp[j][i] += dp[j][i-1];
			}
		}
		System.out.println(dp[m][n]);
	}
}
