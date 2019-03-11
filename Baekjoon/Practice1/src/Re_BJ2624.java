import java.util.Scanner;

public class Re_BJ2624 {
	static int[] coin;
	static int[] g;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int t = stdIn.nextInt();
		int k = stdIn.nextInt();
		coin = new int[1+k];
		g = new int[1+k];
		
		d = new int[k+1][t+1];
		
		for(int i=1;i<=k;i++) {
			coin[i] = stdIn.nextInt();
			g[i] = stdIn.nextInt();
		}
		solve(t,k);
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=t;j++) {
				System.out.printf("%d ", d[i][j]);
			}
			System.out.println();
		}
	}
	static void solve(int t, int k) {
		for(int i=0;i<=k;i++) d[i][0] = 1;
		
		for(int i=1;i<=k;i++) {
			int cnt = g[i];
			for(int j=1;j<=cnt;j++) {
				d[i][j*coin[i]] = d[i][(j-1)*coin[i]];
//				if(cnt>0 && j-coin[i]>=0) {
//					d[i][j] += d[i][j-coin[i]];
//					cnt--;
//				}
//				if(i>0)
//					d[i][j] += d[i-1][j];
			}
			for(int n=1;n<=t;n++) {
				if(n-coin[i]>0)
					d[i][n] += d[i][n-coin[i]];
			}
			for(int m=1;m<=t;m++) {
				
				d[i][m] += d[i-1][m];
			}
			
		}
		
		
	}
}
