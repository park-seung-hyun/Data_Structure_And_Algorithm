// 10844번 (복습)
// 쉬운 계산 수 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ10844 {
	static long[][] d = new long[101][10];
	static final long mod = 1000000000L;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		solve(n);
	}
	static void solve(int n) {
		for(int i=1;i<=9;i++) {
			d[1][i] = 1; 
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				if(j-1>=0)
					d[i][j] += d[i-1][j-1];
				if(j+1<=9)
					d[i][j] += d[i-1][j+1];
				
				d[i][j] %=mod;
			}
		}
		long ans = 0;
		for(int i=0;i<=9;i++) {
			ans += d[n][i];
			ans%=mod;
		}
		System.out.println(ans);
	}
}
