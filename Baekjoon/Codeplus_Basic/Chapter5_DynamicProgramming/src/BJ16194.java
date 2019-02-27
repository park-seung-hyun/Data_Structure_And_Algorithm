// 16194번  
// 카드 구매하기2 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Arrays;
import java.util.Scanner;
public class BJ16194 {
	static int[] card = new int[1001];
	static int[] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		d = new int[n+1];
		for(int i=1;i<=n;i++) {
			card[i] = stdIn.nextInt();
		}
		Arrays.fill(d, 10000000);
		d[0] = 0;
//		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
	static int solve(int n) {
		for(int i=1;i<=n;i++) {
			for(int j = i;j>=1;j--) {
				d[i] = Math.min(d[i], d[i-j] + card[j]);
			}
		}
		return d[n];
	}
	static int solve2(int n) {
		if(n<=1)
			return card[n];
		if(d[n]<10000000)
			return d[n];
		
		for(int i=1;i<=n;i++) {
			d[n] = Math.min(d[n], card[i] + solve2(n-i));
		}
		return d[n];
	}
}
