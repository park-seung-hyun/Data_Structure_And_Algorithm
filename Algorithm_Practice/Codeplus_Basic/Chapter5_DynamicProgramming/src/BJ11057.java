// 11057번  
// 오르막 수 

import java.util.Scanner;
public class BJ11057 {
	static final int mod = 10007;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		d = new int[n+1][10];
		System.out.println(solve(n));
	}
	static int solve(int n) {
		for(int i=0;i<10;i++) d[1][i] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					d[i][j] += d[i-1][k];
				}
				d[i][j] %= mod;
			}
		}
		int ans = 0;
		for(int i=0;i<10;i++) ans += d[n][i];
		return ans%mod;
	}
}


//public class BJ11057{
//	static int[][] d;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n  = stdIn.nextInt();
//		d = new int[n+1][10];
//		solve(n);
//	}
//	static void solve(int n) {
//		for(int i=0;i<10;i++) d[1][i] = 1;
//		
//		for(int i=2;i<=n;i++) {
//			for(int m=0;m<10;m++) {
//				for(int j=0;j<=m;j++) {
//					d[i][m] += d[i-1][j];
//				}
//				d[i][m] %= 10007;
//				
//			}
//		}
//		int ans = 0;
//		for(int i=0;i<10;i++) { 
//			ans += d[n][i];
//			ans %= 10007;
//		}
//		System.out.println(ans);
//		
//	}
//}