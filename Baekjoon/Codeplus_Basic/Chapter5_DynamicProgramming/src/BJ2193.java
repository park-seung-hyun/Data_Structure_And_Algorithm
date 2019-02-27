// 2193번   
// 이친수  
// 2차원 배열 -> solve1
// 1차원 배열 -> solve2

import java.util.Scanner;
public class BJ2193 {
	static long[][] d;
	static long[] d2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		d = new long[n+1][2];
		d2 = new long[n+1];
//		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
	static long solve(int n) {
		d[1][1] = 1;
		d[1][0] = 0;
		for(int i=2;i<=n;i++) {
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		return d[n][0] + d[n][1];
	}
	static long solve2(int n) {
		if(n<3)
			return 1;
		d2[1] = 1;
		d2[2] = 1;
		for(int i= 3;i<=n;i++) {
			d2[i] = d2[i-1] + d2[i-2];
		}
		return d2[n];
	}
}
