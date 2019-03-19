// 2624번 (복습)
// 동전 바꿔주기  
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ2624 {
	static int[][] coin;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int k = stdIn.nextInt();
		coin = new int[k+1][2];
		d = new int[101][10001];
		for(int i=1;i<=k;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			coin[i][0] = a;
			coin[i][1] = b;
		}
		solve(t, k);
	}
	static void solve(int t, int k) {
	
		for(int i=1;i<=k;i++) {
			// 먼저 해당 동전 (0~cnt) 에 맞게 만들 수 있는 경우 따지기 
			int cnt = coin[i][1];
			for(int j=1;j<=cnt;j++) {
				if(coin[i][0] * j <=t)
					d[i][coin[i][0] * j] = 1;
			}
			
			// 이전 동전 활용 
			for(int j=1;j<=t;j++) {
				// 현재 동전 제외하고 만들 수 있는 경우 더하기 
				d[i][j] += d[i-1][j];
				// 이전 동전에다가 + 현재 동전 (0~cnt) 조합으로 만들 수 있는 경우 
				for(int m =	1;m<=cnt;m++) {
					if(j-coin[i][0]*m>=0) {
						d[i][j] += d[i-1][j-coin[i][0]*m];
					}
				}
			}
		}
		// 출력용 
//		for(int i=0;i<=k;i++) {
//			for(int j=0;j<=t;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(d[k][t]);
	}
}
