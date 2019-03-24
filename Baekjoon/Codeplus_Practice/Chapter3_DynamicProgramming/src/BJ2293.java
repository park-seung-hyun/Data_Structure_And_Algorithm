import java.util.Scanner;

public class BJ2293 {
	static int[] coin;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		coin = new int[n+1];
		int k= stdIn.nextInt();
		d = new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			coin[i] = stdIn.nextInt();
		}
		solve(n,k);
	}
	static void solve(int n, int k) {
		d[0][0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=k;j++) {
				d[i][j] += d[i-1][j];
				if(j-coin[i] >=0)
					d[i][j] += d[i][j-coin[i]];
			}
		}
		
		System.out.println(d[n][k]);
	}
}
