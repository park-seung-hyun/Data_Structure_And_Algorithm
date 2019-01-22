// 2294번 
// 동전 2 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class BJ2294 {
	static int[] minAr;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		int k = stdIn.nextInt();
		minAr = new int[k+1];
		
		int[] coin = new int[N+1];
		for(int i=1;i<=N;i++) {
			coin[i] = stdIn.nextInt();
		}
		minAr[0] = 0;
		for(int i=1;i<minAr.length;i++) {
			minAr[i] = -1;
		}
		System.out.print((dp(coin, k) >= 2000000000) ? -1 : dp(coin, k));
	}
	static int dp(int[] c, int k) {
		int min = 2000000000; 

		for(int i=1;i<c.length;i++) {
			if(k-c[i]>=0) {
				if(minAr[k-c[i]] == -1) {
					minAr[k-c[i]] = dp(c, k-c[i]);
				}
				if(min > minAr[k-c[i]]) { 
					min = minAr[k-c[i]] + 1;
				}
			}
		}
		return min;
	}
}
