// 13398번  
// 연속합2

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
