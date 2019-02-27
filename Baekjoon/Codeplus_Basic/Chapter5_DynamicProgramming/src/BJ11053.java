// 11053번  
// 가장 긴 증가하는 부분 수열
// LIS(Longest Increasing Subsequence)

import java.util.Scanner;
public class BJ11053 {
	static int[] ar;
	static int[] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		d = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		System.out.println(solve(n));
	}
	static int solve(int n) {
		for(int i=0;i<n;i++) d[i] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(ar[i]>ar[j] && d[j]+1>d[i]) {
					d[i] = 1+d[j];
				}
			}
		}
		int max = d[0];
		for(int i=1;i<n;i++) {
			if(max < d[i])
				max = d[i];
		}
		return max;
	}
}
