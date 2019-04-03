// 2293번
// 동전1  
// DP

import java.util.Scanner;
public class BJ2293 {
	static int[] coin;
	static int[][] d;
	static int[] d2;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		coin = new int[n+1];
		int k= stdIn.nextInt();
		d = new int[n+1][k+1];
		d2 = new int[k+1];
		for(int i=1;i<=n;i++) {
			coin[i] = stdIn.nextInt();
		}
		solve2(n,k);
	}
	// 1차원 배열 사용 
	// 순서가 다른 것은 같은 경우 -> 동전을 나타내는 반복문을 밖으로 
	// 15989번과 동일 
	static void solve2(int n, int k) {
		d2[0] = 1;
		for(int i=0;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j-coin[i] >= 0)
					d2[j] += d2[j - coin[i]];
			}
		}
		System.out.println(d2[k]);
	}
	static void solve(int n, int k) {
		d[0][0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=k;j++) {
				d[i][j] += d[i-1][j];
				if(j-coin[i] >=0)
					d[i][j] += d[i][j-coin[i]];
			}
		}
		
		System.out.println(d[n][k]);
	}
}
