// 2225번  
// 합분해 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class BJ2225 {
	static long[][] memory;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		int K = stdIn.nextInt();
		memory = new long[K+1][N+1];
		
		for(int i=1;i<=N;i++) {
			memory[1][i] = 1;
		}
		for(int i=1;i<=K;i++) {
			memory[i][1] = i;
		}
		System.out.println(dp(K, N));
	}
	static long dp (int k, int n) {
		
		for(int i=2;i<=k;i++) {
			for(int j=2;j<=n;j++) {
				memory[i][j] = memory[i-1][j] % 1000000000 + memory[i][j-1] % 1000000000;
			}
		}
		return memory[k][n] % 1000000000;
	}
}
