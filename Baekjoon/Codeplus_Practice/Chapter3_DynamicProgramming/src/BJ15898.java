import java.util.Scanner;

public class BJ15898 {
	static int[][] d = new int[4][10001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		dp();
		for(int i=0;i<t;i++) {
			int a = stdIn.nextInt();
			System.out.println(d[3][a]);
		}
	}
	static void dp() {
		for(int i=1;i<=3;i++) d[i][0] = 1;
		for(int i=0;i<=10000;i++) d[1][i] = 1;
		
		for(int i=2;i<=3;i++) {
			for(int j=1;j<=10000;j++) {
				d[i][j] += d[i-1][j];
				if(j-i>=0) {
					d[i][j] += d[i][j-i];
//					d[i][j] += (d[i][j-i] - d[i-1][j-i]);
				}
			}
		}
//		for(int i=0;i<=3;i++) {
//			for(int j=0;j<=10;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
		
	}
}
