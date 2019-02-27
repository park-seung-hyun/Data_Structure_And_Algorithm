// 11054번  
// 가장 긴 바이토닉 부분 수열 
// LIS(Longest Increasing Subsequence) 응용 

import java.util.Scanner;
public class BJ11054 {
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
		for(int i=0;i<n;i++) {
			d[i] = 1;
			for(int j=0;j<i;j++) {
				if(ar[i]>ar[j] && d[i] < d[j] +1)
					d[i] = d[j] +1;
			}
		}
		for(int i=n-1;i>=0;i--) {
			d2[i] = 1;
			for(int j=n-1;j>i;j--) {
				if(ar[i]>ar[j] && d2[i] < d2[j] +1)
					d2[i] = d2[j] +1;
			}
		}
		int max = d[0] + d2[0];
		for(int i=0;i<n;i++) {
			if(max < d[i] + d2[i])
				max = d[i] + d2[i];
		}
		System.out.println(max-1);
	}
}
