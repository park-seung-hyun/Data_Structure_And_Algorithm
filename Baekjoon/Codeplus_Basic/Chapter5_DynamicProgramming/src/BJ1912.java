// 1912번  
// 연속합

import java.util.Scanner;
public class BJ1912 {
	static int[] ar;
	static int[] d;
	public static void main (String[] args) {
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
		for(int i=0;i<n;i++) d[i] = ar[i];
		for(int i=1;i<n;i++) {
			if(d[i] < d[i-1] + ar[i])
				d[i] = d[i-1] + ar[i];
		}
		int max = d[0];
		for(int i=1;i<n;i++) {
			if(max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}
