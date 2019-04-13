// 9095번 (복습)
// 1, 2, 3 더하기 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ9095 {
	static int[] d = new int[11];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t =stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
//			solve(n);
			
			d = new int[11];
			System.out.println(solve2(n));
		}
	}
	static void solve(int n) {
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i=4;i<=n;i++) {
			d[i] = d[i-1] +d[i-2] + d[i-3];
		}
		System.out.println(d[n]);
	}
	static int solve2(int n) {
		if(d[n]>0)
			return d[n];
		if(n == 3)
			return 4;
		if(n==2)
			return 2;
		if(n==1)
			return 1;
		d[n] = solve2(n-1) + solve2(n-2) +solve2(n-3);
		
		return d[n];
	}
}	
