// 2740번 (복습) 
// 행렬 곱셈 

import java.util.Scanner;
public class Re_BJ2740 {
	static int[][] max1;
	static int[][] max2;
	static int[][] max3;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		max1 = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				max1[i][j] = stdIn.nextInt();
			}
		}
		int n2 = stdIn.nextInt();
		int m2 = stdIn.nextInt();
		max2 = new int[n2][m2];
		for(int i=0;i<n2;i++) {
			for(int j=0;j<m2;j++) {
				max2[i][j] = stdIn.nextInt();
			}
		}
		max3 = new int[n][m2];
		solve();
	}
	static void solve() {
		
		for(int i=0;i<max1.length;i++) {
			for(int k=0;k<max2[0].length;k++) {
				for(int j = 0;j<max1[0].length;j++) {
					max3[i][k] += max1[i][j] * max2[j][k];
				}
			}
		}
		for(int i=0;i<max3.length;i++) {
			for(int j=0;j<max3[0].length;j++) {
				System.out.printf("%d ", max3[i][j]);
			}
			System.out.println();
		}
		
	}
}
