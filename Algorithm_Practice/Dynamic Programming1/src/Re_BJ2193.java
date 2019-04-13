// 2193번 (복습)
// 이친수  
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ2193 {
	static long[][] d2 = new long[91][2];
	static long[] d = new long[91];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
//		solve(n);
		solve2(n);
	}
	static void solve(int n) {
		d[1] = 1;
		for(int i=2;i<=n;i++) {
			d[i] = d[i-1] + d[i-2];
		}
		System.out.println(d[n]);
	}
	static void solve2(int n) {
		d2[1][0] = 0;
		d2[1][1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<2;j++) {
				if(j==0)
					d2[i][j] = d2[i-1][0] + d2[i-1][1];
				else
					d2[i][j] = d2[i-1][0];
			}
		}
		System.out.println(d2[n][0] + d2[n][1]);
	}
}
