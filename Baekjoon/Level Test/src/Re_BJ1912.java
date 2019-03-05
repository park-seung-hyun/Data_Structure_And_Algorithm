// 1912번 (복습)
// 연속합 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ1912 {
	static int[] ar;
	static int[] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		d = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(n);
	}
	static void solve(int n) {
		int max = ar[0];
		d[0] = ar[0];
		for(int i=1;i<n;i++) {
			d[i] = max(ar[i], d[i-1] + ar[i]);
			
			if(max < d[i])
				max = d[i];
		}
//		System.out.println(Arrays.toString(d));
		System.out.println(max);
	}
	static int max(int a, int b) {
		return a>b?a:b;
	}
}
