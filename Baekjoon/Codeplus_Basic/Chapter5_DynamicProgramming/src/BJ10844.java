// 10844번  
// 쉬운 계단 수 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
public class BJ10844 {
	static long[][] d;
	static final long mod = 1000000000L;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		d = new long[n+1][10];
//		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
	static long solve(int n) {
		for(int i=1;i<10;i++) d[1][i] = 1;
		
		for(int i=2 ;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j-1>=0)
					d[i][j] = d[i-1][j-1];
				if(j+1<10)
					d[i][j] += d[i-1][j+1];
				d[i][j] %= mod;
			}
		}
		long ans = 0;
		for(int i=0;i<10;i++) {
			ans += d[n][i];
		}
		return ans%=mod;
	}
	static long solve2(int n) {
		long ans = 0;
		for(int i=0;i<10;i++) {
			ans += d[n][i];
		}
		if(ans != 0) 
			return ans%=mod;
		if(n == 1) {
			for(int i=1;i<10;i++) d[1][i] = 1;
			return 9;
		}
		
		for(int j=0;j<10;j++) {
			long a = solve2(n-1);
			if(j-1>=0)
				d[n][j] = d[n-1][j-1];
			if(j+1<10)
				d[n][j] += d[n-1][j+1];
			d[n][j] %= mod;
		}
		for(int i=0;i<10;i++) {
			ans += d[n][i];
		}
		return ans%=mod;	
	}
}
