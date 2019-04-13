// 11726번  
// 2xn 타일링 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
public class BJ11726 {
	static int[] d = new int[1001];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
//		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
	static int solve(int n) {
		d[1] = 1;
		d[2] = 2;
		for(int i=3;i<=n;i++) {
			d[i] = d[i-1]%10007 + d[i-2]%10007;
		}
		return d[n]%10007;
	}
	static int solve2(int n) {
		if(n <= 2)
			return n;
		if(d[n]>0)
			return d[n]%10007;
		d[n] = solve2(n-1)%10007 + solve2(n-2)%10007;
		return d[n]%10007;
	}
}
//public class BJ11726{
//	static int[] d;
//	static final int mod = 10007;
//	public static void main (String[] args) {
//		Scanner stdIn =new Scanner(System.in);
//		int n = stdIn.nextInt();
//		d = new int[n+1];
//		solve(n);
//	}
//	static void solve(int n) {
//		if(n<=2) {
//			System.out.println(n);
//			return;
//		}
//			
//		d[1] = 1;
//		d[2] = 2;
//		for(int i=3;i<=n;i++) {
//			d[i] = d[i-1] + d[i-2];
//			d[i] %= mod;
//		}
//		System.out.println(d[n]);;
//	}
//}