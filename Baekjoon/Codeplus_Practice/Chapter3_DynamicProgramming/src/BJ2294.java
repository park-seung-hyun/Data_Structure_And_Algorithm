import java.util.Scanner;

public class BJ2294 {
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
		for(int i=1;i<=k;i++) d[0][i] = -1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				int min = d[i-1][j];
				if(j-coin[i] >= 0) {
					if(d[i][j-coin[i]] != -1) {
						if(min == -1)
							min = d[i][j-coin[i]] + 1;
						else if(min != -1 && min > d[i][j-coin[i]] + 1)
							min = d[i][j-coin[i]] + 1;
					}
				}
				d[i][j] = min;
			}
		}
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=k;j++) {
//				System.out.printf("%d ", d[i][j]);
//				
//			}
//			System.out.println();
//		}
		System.out.println(d[n][k]);
	}
}
