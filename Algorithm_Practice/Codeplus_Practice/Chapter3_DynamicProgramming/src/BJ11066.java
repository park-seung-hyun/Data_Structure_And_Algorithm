// 11066번
// 파일 합치기  
// DP

import java.util.Scanner;
public class BJ11066 {
	static int[] file;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			file = new int[n+1];
			d = new int[n+1][n+1];
			for(int j=1;j<=n;j++) {
				file[j] = stdIn.nextInt();
			}
			// Bottom-Up
//			dp(n);
			
			// Top-Down
			int[][] fileSum = new int[n+1][n+1];
			for(int j=1;j<=n;j++) {
				int fs= 0;
				for(int k=j;k<=n;k++) {
					fs += file[k];
					fileSum[j][k] = fs;
				}
			}
			System.out.println(dp2(1,n,fileSum));
		}
	}
	// Top-Down
	static int dp2(int i, int j, int[][] fileSum) {
		if(i == j) return 0;
		if(i+1 == j) return file[i] + file[i+1];
		if(d[i][j] != 0)
			return d[i][j];
		
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp = dp2(i,k,fileSum) + dp2(k+1,j,fileSum) + fileSum[i][j];
			if(min > temp) min = temp;
		}
		d[i][j] = min;
		return d[i][j];
	}
	// Bottom-Up
	static void dp(int n) {
		int[][] fileSum = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			int fs= 0;
			for(int j=i;j<=n;j++) {
				fs += file[j];
				fileSum[i][j] = fs;
			}
		}
		for(int i=1;i<n;i++) d[i][i+1] = file[i] + file[i+1];
		for(int k=2;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				int j = i+k;
				int min = Integer.MAX_VALUE;
				if(j>n) continue;
				for(int m=i;m<j;m++) {
					if(min > d[i][m] + d[m+1][j] + fileSum[i][j]) {
						min = d[i][m] + d[m+1][j] + fileSum[i][j];	
					}
				}
				d[i][j] = min;
			}
		}
		System.out.println(d[1][n]);
	}
}
