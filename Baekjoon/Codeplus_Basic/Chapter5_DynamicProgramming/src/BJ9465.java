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
