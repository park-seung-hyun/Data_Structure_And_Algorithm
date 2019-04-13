// 1890번 
// 점프  
// DP

import java.util.Scanner;
public class BJ1890 {
	static int[][] map;
	static long[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n=stdIn.nextInt();
		map = new int[n][n];
		d = new 	long[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve3(n);
	}
	static void solve3(int n) {
		// O(n^2)
		d[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==n-1 && j==n-1) continue;
				if(i+map[i][j] < n)
					d[i+map[i][j]][j] += d[i][j];
				if(j+map[i][j] < n)
					d[i][j+map[i][j]] += d[i][j];
			}
		}
		System.out.println(d[n-1][n-1]);
	}
	static void solve2(int n) {
		// O(n^3)
		d[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<i;k++) {
					if(map[k][j] + k == i) {
						d[i][j] += d[k][j];
					}
				}
				for(int k=0;k<j;k++) {
					if(map[i][k] + k == j) {
						d[i][j] += d[i][k];
					}
				}
			}
		}
		System.out.println(d[n-1][n-1]);
	}
	// 기존에 푼 방법 
	// 왜 나는 visited를 만들었을까? 왜 필요없을까? 생각해보기 
	// 어짜피 모든 칸 한번씩만 보는게 DP인데 visited 의미 없음 
	static void solve(int n) { 
		d[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=1;k<=9;k++) {
					if(i-k >=0 && map[i-k][j] == k) {
						d[i][j] += d[i-k][j];
					}
					if(j-k >=0 && map[i][j-k] == k) {
						d[i][j] +=  d[i][j-k];
					}
						
				}
			}
		}
		System.out.println(d[n-1][n-1]);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
	}
}
