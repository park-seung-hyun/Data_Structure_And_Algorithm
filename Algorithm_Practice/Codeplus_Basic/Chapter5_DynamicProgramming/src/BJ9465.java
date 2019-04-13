// 9495번    
// 스티커 

import java.util.Scanner;
public class BJ9465 {
	static int[][] d;
	static int[][] card;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			d = new int[3][n];
			card = new int[2][n];
			for(int j=0;j<n;j++) {
				card[0][j] = stdIn.nextInt();
			}
			for(int j=0;j<n;j++) {
				card[1][j] = stdIn.nextInt();
			}
			System.out.println(solve(n-1));
			
		}
	}
	static int solve(int n) {
		d[0][0] = 0;
		d[1][0] = card[0][0];
		d[2][0] = card[1][0];
		for(int i=1;i<=n;i++) {
			d[0][i] = Math.max(d[0][i-1], d[1][i-1]);
			d[0][i] = Math.max(d[0][i], d[2][i-1]);
			
			d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + card[0][i];
			d[2][i] = Math.max(d[0][i-1], d[1][i-1]) + card[1][i];
		}
		int max = Math.max(d[0][n], d[1][n]);
		max = Math.max(max, d[2][n]);
		return max;
	}
}
//public class BJ9465{
//	static int[][] d;
//	static int[][] s;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int t= stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int n= stdIn.nextInt();
//			d = new int[n+1][3];
//			s = new int[n+1][2];
//			for(int j=1;j<=n;j++) {
//				s[j][0] = stdIn.nextInt();
//			}
//			for(int j=1;j<=n;j++) {
//				s[j][1] = stdIn.nextInt();
//			}
//			solve(n);
//		}
//	}
//	static void solve(int n) {
//		
//		d[1][0] = s[1][0];
//		d[1][1] = s[1][1];
//		d[1][2] = 0;
//		
//		for(int i=2;i<=n;i++) {
//			
//			int max = s[i][0] + d[i-1][1];
//			if(max < s[i][0] + d[i-1][2])
//				max = s[i][0] + d[i-1][2];
//			d[i][0] = max;
//			
//			max = s[i][1] + d[i-1][0];
//			if(max < s[i][1] + d[i-1][2])
//				max = s[i][1] + d[i-1][2];
//			d[i][1] = max;
//			
//			max = d[i-1][0];
//			if(max < d[i-1][1])
//				max = d[i-1][1];
//			d[i][2] = max;
//
//		}
//		System.out.println(getMax(d[n][0],d[n][1],d[n][2]));
//	}
//	static int getMax(int a, int b, int c) {
//		int max = a;
//		if(max < b)
//			max = b;
//		if(max < c)
//			max = c;
//		return max;
//	}
//}