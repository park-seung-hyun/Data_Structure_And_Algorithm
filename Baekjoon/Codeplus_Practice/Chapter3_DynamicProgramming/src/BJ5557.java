import java.util.Scanner;

public class BJ5557 {
	static int[] num;
	static long[][] d;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		d = new long[n][21];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		solve(n);
	}
	static void solve(int n) {
		int ans = num[n-1];
		d[0][num[0]] = 1;
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<=20;j++) {
				if(d[i][j] >= 1) {
					if(j-num[i+1] >=0)
						d[i+1][j-num[i+1]] += d[i][j];
					if(j+num[i+1] <=20)
						d[i+1][j+num[i+1]] += d[i][j];
				}
			}
		}
		System.out.println(d[n-2][ans]);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<=20;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
		
	}
}
