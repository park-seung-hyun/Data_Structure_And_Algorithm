// 2294번
// 동전2  
// DP

import java.util.Arrays;
import java.util.Scanner;
public class BJ2294 {
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
	// 초기화가 문제 
	// -1 or Integer.MAX_VALUE 뭘로 초기화해야할지 항상 고민됨. 
	static void solve2(int n, int k) {
		Arrays.fill(d2, -1);
		d2[0] = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j - coin[i] >=0 && d2[j-coin[i]] != -1) {
					if(d2[j] == -1 || d2[j] > d2[j-coin[i]] + 1) {
						d2[j] = d2[j-coin[i]] + 1;
					}
				}
			}
		}
		System.out.println(d2[k]);
		
	}
	static void solve(int n, int k) {
		for(int i=1;i<=k;i++) d[0][i] = -1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				int min = d[i-1][j];
				if(j-coin[i] >= 0) {
					if(d[i][j-coin[i]] != -1) {
						if(min == -1)
							min = d[i][j-coin[i]] + 1;
						else if(min != -1 && min > d[i][j-coin[i]] + 1)
							min = d[i][j-coin[i]] + 1;
					}
				}
				d[i][j] = min;
			}
		}
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=k;j++) {
//				System.out.printf("%d ", d[i][j]);
//				
//			}
//			System.out.println();
//		}
		System.out.println(d[n][k]);
	}
}
