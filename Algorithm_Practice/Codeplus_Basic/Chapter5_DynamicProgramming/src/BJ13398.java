// 13398번  
// 연속합2

import java.util.Arrays;
import java.util.Scanner;
public class BJ13398 {
	static int[] ar;
	static int[] d;
	static int[] d2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		d = new int[n];
		d2 = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(n);
	}
	static void solve(int n) {
		for(int i=0;i<n;i++) d[i] = ar[i];
		for(int i=1;i<n;i++) {
			if(ar[i] < d[i-1] + ar[i]) {
				d[i] = d[i-1] + ar[i];
			}
		}
		for(int i=0;i<n;i++) d2[i] = ar[i];
		for(int i=n-2;i>=0;i--) {
			if(ar[i] < d2[i+1] + ar[i]) {
				d2[i] = d2[i+1] + ar[i];
			}
		}
		
		int max = d[0];
		for(int i=0;i<n;i++) {
			if(max < d[i])
				max = d[i];
		}
		for(int i=1;i<=n-2;i++) {
			int t = d[i-1] + d2[i+1];
			if(max<t)
				max = t;
		}
		System.out.println(max);
	}
}
//public class BJ13398{
//	static int[][] d;
//	static int[] d1;
//	static int[] d2;
//	static int[] s;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		d = new int[n][2];
//		d1 = new int[n];
//		d2 = new int[n];
//		s = new int[n];
//		for(int i=0;i<n;i++) {
//			s[i] = stdIn.nextInt();
//		}
//		solve(n);
//	}
//	static void solve2(int n) {
//		d1[0] = s[0];
//		for(int i=1;i<n;i++) {
//			if(d1[i-1] + s[i] > s[i])
//				d1[i] = d1[i-1] + s[i];
//			else
//				d1[i] = s[i];
//		}
//		d2[n-1] = s[n-1];
//		for(int i=n-2;i>=0;i--) {
//			if(d2[i+1] + s[i] > s[i])
//				d2[i] = d2[i+1] + s[i];
//			else
//				d2[i] = s[i];
//		}
//		int ans = Integer.MIN_VALUE;
//		for(int i=0;i<n;i++) {
//			if(ans < d1[i])
//				ans = d1[i];
//		}
//		for(int i=0;i<n;i++) {
//			if(ans < d2[i])
//				ans = d2[i];
//		}
//		for(int i=1;i<n-1;i++) {
//			if(ans < d1[i-1] + d2[i+1])
//				ans = d1[i-1] + d2[i+1];
//		}
//		System.out.println(ans);
//		
//	}
//	static void solve(int n) {
//			
//		d[0][0] = s[0];
//		d[0][1] = s[0];
//		for(int i=1;i<n;i++) {
//			if(d[i-1][0] + s[i] > s[i])
//				d[i][0] = d[i-1][0] + s[i];
//			else
//				d[i][0] = s[i];
//			
//			if(d[i-1][0] > d[i-1][1] + s[i])
//				d[i][1] = d[i-1][0] ;
//			else
//				d[i][1] = d[i-1][1] + s[i] ;
//		}
//		int ans = Integer.MIN_VALUE;
//		for(int i=0;i<n;i++) {
//			if(ans < d[i][1])
//				ans = d[i][1];
//		}
//		for(int i=0;i<n;i++) {
//			if(ans < d[i][0])
//				ans = d[i][0];
//		}
//		System.out.println(ans);
//	}
//}