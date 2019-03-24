// 9095번  
// 1,2,3더하기
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
public class BJ9095 {
	static int[] d = new int[11];
	public static void main (String[] args) {
		Scanner stdIn=  new Scanner(System.in);
		int t =stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
//			System.out.println(solve(n));
			System.out.println(solve2(n));
		}
	}
	static int solve(int n) {
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i=4;i<=n;i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		return d[n];
	}
	static int solve2(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(n == 3)
			return 4;
		if(d[n]>0)
			return d[n];
		d[n] = solve2(n-1) + solve(n-2) + solve(n-3);
		return d[n];
	}
}
//public class BJ9095{
//	static int[] d = new int[11];
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int t = stdIn.nextInt();
//		dp();
//		for(int i=0;i<t;i++) {
//			int n = stdIn.nextInt();
//			System.out.println(d[n]);
//		}
//	}
//	static void dp() {
//		d[1] = 1;
//		d[2] = 2;
//		d[3] = 4;
//		for(int i=4;i<11;i++) {
//			d[i] = d[i-1] + d[i-2] + d[i-3];
//		}
//	}
//}
