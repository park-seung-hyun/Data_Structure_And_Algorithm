// 1149번 (복습) 
// RGB 거리 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ1149 {
	static int[][] w;
	static int[][] d;
	static int[] d2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		w = new int[n+1][3]; // rgb
		d = new int[n+1][3];
		d2 =new int[n+1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<3;j++) {
				w[i][j] = stdIn.nextInt();
			}
		}
		solve(n);
	}
	static void solve(int n) {
		d[1][0] = w[1][0];
		d[1][1] = w[1][1];
		d[1][2] = w[1][2];
		for(int i=2;i<=n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					d[i][j] = min(d[i-1][1], d[i-1][2]) + w[i][j];
				}else if(j==1) {
					d[i][j] = min(d[i-1][0], d[i-1][2]) + w[i][j];
				}else {
					d[i][j] = min(d[i-1][0], d[i-1][1]) + w[i][j];
				}
			}
		}
		int ans = min(d[n][0], d[n][1]);
		ans = min(ans, d[n][2]);
		System.out.println(ans);
	}
	static int min(int a, int b) {
		return a<b?a:b;
	}
}
