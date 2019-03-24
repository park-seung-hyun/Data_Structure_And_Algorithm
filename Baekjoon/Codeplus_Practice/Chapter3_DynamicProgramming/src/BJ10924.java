import java.util.Scanner;

public class BJ10924 {
	static int[] num;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n+1];
		d = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			num[i] = stdIn.nextInt();
		}
		int t = stdIn.nextInt();
		fillD(n);
		for(int i=0;i<t;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			System.out.println(d[a][b]);
		}
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++){
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
	}
	static void fillD(int n) {
		for(int i=1;i<=n;i++)
			d[i][i] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++){
			// j와 j+i
				if(j+i <= n && num[j]==num[j+i]) {
					if(i==1)
						d[j][j+i] = 1;
					else {
						if(d[j+1][j+i-1] == 1) {
							d[j][j+i] = 1;
						}
					}
				}	
			}
		}

	}

}
