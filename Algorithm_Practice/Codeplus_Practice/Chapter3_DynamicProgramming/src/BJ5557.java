// 15557번
// 1학년     
// DP

import java.util.Scanner;
public class BJ5557 {
	static int[] num;
	static long[][] d;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		d = new long[n][21];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		solve2(n);
	}
	static void solve2(int n) {
		d[0][num[0]] = 1;
		for(int i=1;i<n-1;i++) {
			for(int j=0;j<=20;j++) {
				if(j-num[i] >=0)
					d[i][j] += d[i-1][j-num[i]];
				if(j+num[i] <= 20)
					d[i][j] += d[i-1][j+num[i]];
			}
		}
		System.out.println(d[n-2][num[n-1]]);
	}
	static void solve(int n) {
		int ans = num[n-1];
		d[0][num[0]] = 1;
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<=20;j++) {
				if(d[i][j] >= 1) {
					if(j-num[i+1] >=0)
						d[i+1][j-num[i+1]] += d[i][j];
					if(j+num[i+1] <=20)
						d[i+1][j+num[i+1]] += d[i][j];
				}
			}
		}
		System.out.println(d[n-2][ans]);
	}
}
