// 11052번  
// 카드 구매하기 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2

import java.util.Scanner;
//public class BJ11052 {
//	static int[] card;
//	static int[] d = new int[1001];
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		card = new int[n+1];
//		for(int i=1;i<=n;i++) {
//			card[i] = stdIn.nextInt();
//		}
//		System.out.println(solve(n));
//	}
//	static int solve(int n) {
//		for(int i=1;i<=n;i++) {
//			for(int j=i;j>=1;j--) {
//				d[i] = Math.max(d[i], d[i-j] + card[j]);
//			}
//		}
//		return d[n];
//	}
//	static int solve2(int n) {
//		if(n <= 1)
//			return card[n];
//		if(d[n]>0)
//			return d[n];
//		
//		for(int i = n;i>=1;i--) {
//			d[n] = Math.max(solve2(n-i) + card[i], d[n]);
//		}
//		return d[n];
//	}
//}

//public class BJ11052{
//	static int[] d;
//	static int[] card;
//	public static void main(String[] args) {
//		Scanner stdIn =new Scanner(System.in);
//		int t = stdIn.nextInt();
//		d = new int[t+1];
//		card = new int[t+1];
//		for(int i=1;i<=t;i++) {
//			card[i] = stdIn.nextInt();
//		}
//		solve(t);
//	}
//	static void solve(int n) {
//		
//		for(int i=1;i<=n;i++) {
//			int max = 0;
//			for(int j=1;j<=i;j++) {
//				if(max < d[i-j] + card[j])
//					max = d[i-j] + card[j];				
//			}	
//			d[i] = max;
//		}
//		System.out.println(d[n]);
//	}
//}