// 15988번  
// 1,2,3더하기 3
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
public class BJ15988 {
	static long[] d = new long[1000001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
//			System.out.println(solve(n));
			System.out.println(solve2(n));
		}
	}
	static long solve(int n) {
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i=4;i<=n;i++) {
			d[i] = d[i-1]%1000000009 + d[i-2]%1000000009 + d[i-3]%1000000009;
		}
		return d[n]%1000000009;
	}
	static long solve2(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		if(d[n]>0)
			return d[n]%1000000009;
		d[n] = solve2(n-1)%1000000009 + solve2(n-2)%1000000009 + solve2(n-3)%1000000009;
		
		return d[n]%1000000009;
	}
}
