// 2225번 (복습) 
// 합분해 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ2225 {
	static long[][] d;
	static final long mod = 1000000000L;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		d = new long[n+1][k+1];
		solve2(n,k);
	}
	static void solve(int n, int k) {
		for(int i=0;i<=n;i++) {
			d[i][1] = 1;
		}
		for(int i=0;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				for(int m =0;m<=i;m++) {
					d[i][j] += d[i-m][j-1];
				}
				d[i][j] %= mod;
			}
		}
		System.out.println(d[n][k]);
	}
	static void solve2(int n, int k) {
		for(int i=0;i<=n;i++) {
			d[i][1] = 1;
		}
		for(int i=0;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				d[i][j] = d[i][j-1];
				if(i-1>=0)
					d[i][j] += d[i-1][j];
				d[i][j] %= mod;
			}
		}
		System.out.println(d[n][k]);
	}
}
