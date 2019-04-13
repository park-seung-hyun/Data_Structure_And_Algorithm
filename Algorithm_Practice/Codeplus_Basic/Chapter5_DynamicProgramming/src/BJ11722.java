// 11722번  
// 가장 긴 감소하는 부분 수열 
// LIS(Longest Increasing Subsequence) 응용 

import java.util.Scanner;
public class BJ11722 {
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
		for(int i=0;i<n;i++) {
			d[i] = 1;
			for(int j=0;j<i;j++) {
				if(ar[i] < ar[j] && d[i] < d[j] +1)
					d[i] =d[j] +1;
			}
		}
		int max = d[0];
		for(int i=1;i<n;i++) {
			if(max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}

//public class BJ11722{
//	static int[] d;
//	static int[] s;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		d = new int[n];
//		s = new int[n];
//		for(int i=0;i<n;i++) {
//			s[i] = stdIn.nextInt();
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		for(int i=0;i<n;i++) {
//			d[i] = 1;
//			for(int j=0;j<i;j++) {
//				if(s[i] < s[j] && d[i] < d[j] + 1)
//					d[i] = d[j] + 1;
//			}
//		}
//		int ans = 0;
//		for(int i=0;i<n;i++) {
//			if(ans < d[i])
//				ans = d[i];
//		}
//		System.out.println(ans);
//	}
//}