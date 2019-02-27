// 11055번  
// 가장 큰 증가하는 부분 수열 
// LIS(Longest Increasing Subsequence) 응용 

import java.util.Scanner;
public class BJ11055 {
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
			d[i] = ar[i];
			for(int j=0;j<i;j++) {
				if(ar[i]>ar[j] && d[i] < d[j] + ar[i])
					d[i] = d[j] + ar[i];
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
