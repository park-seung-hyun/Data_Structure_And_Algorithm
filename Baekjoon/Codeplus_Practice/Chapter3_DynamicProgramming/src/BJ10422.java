// 10422번
// 괄호     
// DP

import java.util.Scanner;
public class BJ10422 {
	static final long mod = 1000000007;
	static long[][] d = new long[5001][5];
	static long[] d2 = new long[5001];
	static long[][] d3 = new long[5001][5001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
//		dp();
//		for(int i=0;i<t;i++) {
//			int n = stdIn.nextInt();
//			long sum = 0;
//			for(int j=1;j<=4;j++) {
//				sum += d[n][j];
//				sum %= mod;
//			}
//			System.out.println(sum);
//		}
		
//		dp2();
//		for(int i=0;i<t;i++) {
//			int n= stdIn.nextInt();
//			System.out.println(d2[n]);
//		}
	}
	static void dp2() {
		d2[0] = 1;
		for(int i=2;i<=5000;i+=2) {
			for(int j = 2;j<=i;j+=2) {
				d2[i] += d2[j-2] * d2[i-j]; 
				d2[i] %=mod;
			}
		}
	}
	// 처음에 시도했던 방법 
	static void dp() {
		d[2][4] = 1;
		d[4][3] = 1;
		d[4][4] = 1;
		for(int i = 6;i<=5000;i+=2) {
			
			// [1] ()S
			// [2] S()
			// [3] (S)
			// [4] ()S()
			d[i][1] = d[i-2][1] + d[i-2][3]; 
			d[i][2] = d[i-2][2] + d[i-2][3];
			d[i][3] = d[i-2][1] +d[i-2][2] + d[i-2][3]+ d[i-2][4];
			d[i][4] = d[i-4][1] +d[i-4][2]+d[i-4][3]+ d[i-4][4];
			
			d[i][1]%=mod;
			d[i][2]%=mod;
			d[i][3]%=mod;
			d[i][4]%=mod;
		}
	}
}
