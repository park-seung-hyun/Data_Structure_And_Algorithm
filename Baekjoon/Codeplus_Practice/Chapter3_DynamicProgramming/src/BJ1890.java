import java.util.Scanner;

public class BJ1890 {
	static int[][] map;
	static long[][] d;
	static boolean[][] v;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n=stdIn.nextInt();
		map = new int[n][n];
		d = new 	long[n][n];
		v = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve(n);
	}
	static void solve(int n) {
		v[0][0] =true;
		d[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=1;k<=9;k++) {
					if(i-k >=0 && map[i-k][j] == k && v[i-k][j] == true) {
						d[i][j] += d[i-k][j];
						v[i][j] = true;
					}
					if(j-k >=0 && map[i][j-k] == k && v[i][j-k] == true) {
						d[i][j] +=  d[i][j-k];
						v[i][j] = true;
					}
						
				}
			}
		}
		System.out.println(d[n-1][n-1]);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
	}
}
