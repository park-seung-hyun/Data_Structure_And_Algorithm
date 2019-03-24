import java.util.Scanner;

public class BJ10422 {
	static final long mod = 1000000007;
	static long[][] d = new long[5001][5];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		dp();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			long sum = 0;
			for(int j=1;j<=4;j++) {
				sum += d[n][j];
				sum %= mod;
			}
			System.out.println(sum);
		}
	}
	static void dp() {
		d[2][1] = 1;
		d[4][2] = 1;
		d[4][4] = 1;
		for(int i = 6;i<=5000;i+=2) {
			d[i][1] = d[i-2][1] + d[i-2][2];
			
			d[i][2] = d[i-2][1] + d[i-2][2];
			d[i][2]%=mod;
			d[i][2] += d[i-2][3] + d[i-2][4];
			
			d[i][3] = d[i-2][3] + d[i-2][2];
			
			d[i][4] = d[i-4][1] + d[i-4][2];
			d[i][4]%=mod;
			d[i][4] = d[i-4][3] + d[i-4][4];
			
			d[i][1]%=mod;
			d[i][2]%=mod;
			d[i][3]%=mod;
			d[i][4]%=mod;
		}
//		for(int i=2;i<=12;i++) {
//			for(int j=1;j<=4;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();;
//		}
	}
}
