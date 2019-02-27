// 15990번  
// 1,2,3 더하기 5
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
public class BJ15990 {
	static long[][] d = new long[100001][4];
	static final long mod = 1000000009L;
	
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			d[1][1] = 1;
			d[2][2] = 1;
			d[3][1] = 1;
			d[3][2] = 1;
			d[3][3] = 1;
//			System.out.println(solve(n));
			System.out.println(solve2(n));
		}
	}
	static long solve(int n) {
		for(int i=4;i<=n;i++) {
			if(d[i][1] + d[i][2] + d[i][3] != 0)
				continue;
			for(int j=1;j<4;j++) {
				int k = i-j; // 3 , 2 , 1
				if(j == 1) {
					d[i][j] = d[k][2] + d[k][3];
				}else if(j==2) {
					d[i][j] = d[k][1] + d[k][3];
				}else {
					d[i][j] = d[k][2] + d[k][1];		
				}
				d[i][j] %= mod;
			}
			
		}
		return (d[n][1] + d[n][2] + d[n][3])%mod;
	}
	static long solve2(int n) {
	
		if(d[n][1] + d[n][2] + d[n][3] != 0)
			return (d[n][1] + d[n][2] + d[n][3])%mod;
		
		for(int j=1;j<4;j++) {
			int k = n-j;
			long a = solve2(k);
			if(j == 1) {
				d[n][j] = d[k][2]%1000000009 + d[k][3]%1000000009;
			}
			else if(j == 2) {
				d[n][j] = d[k][1]%1000000009 + d[k][3]%1000000009;
			}
			else {
				d[n][j] = d[k][2]%1000000009 + d[k][1]%1000000009;
			}
			d[n][j] %= mod;
		}
		return (d[n][1] + d[n][2] + d[n][3])%mod;
	}
}
