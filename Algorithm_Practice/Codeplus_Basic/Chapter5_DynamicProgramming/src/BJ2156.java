// 2156번   
// 포도주 시식  
// 2차원 배열 -> solve1
// 1차원 배열 -> solve2

import java.util.Arrays;
import java.util.Scanner;
public class BJ2156 {
	static int[] wine;
	static int[][] d;
	static int[] d2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		wine = new int[n];
		d = new int[n][3];
		d2 = new int[n];
		for(int i=0;i<n;i++) {
			wine[i] = stdIn.nextInt();
		}
//		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
	static int solve(int n) {
		d[0][1] = wine[0];
		d[0][2] = wine[0];
		for(int i=1;i<n;i++) {
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
			d[i][0] = Math.max(d[i][0], d[i-1][2]);
			
			d[i][1] = d[i-1][0] + wine[i];
			d[i][2] = d[i-1][1] + wine[i];
		}
		int max = Math.max(d[n-1][0], d[n-1][1]);
		max = Math.max(max, d[n-1][2]);
		return max;
		
	}
	static int solve2(int n) {
		if(n<2)
			return wine[0];
		
		d2[0] = wine[0];
		d2[1] = wine[1] + wine[0];
		
		for(int i=2;i<n;i++) {
			int max = d2[i-1];
			max = Math.max(max, d2[i-2] + wine[i]);
			if(i>2) 
				max = Math.max(max, d2[i-3] + wine[i] + wine[i-1]);
			else
				max = Math.max(max, wine[i] + wine[i-1]);
			d2[i] = max;
		}
		return d2[n-1];
	}
}

//public class BJ2156{
//	static int[] wine;
//	static int[][] d;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		wine = new int[n+1];
//		d = new int[n+1][3];
//		for(int i=1;i<=n;i++) {
//			wine[i] = stdIn.nextInt(); 
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		d[1][1] = wine[1];
//		for(int i=2;i<=n;i++) {
//			d[i][0] = getMax(d[i-1][0],d[i-1][1],d[i-1][2]);
//			d[i][1] = d[i-1][0] + wine[i];
//			d[i][2] = d[i-1][1] + wine[i];
//		}
//		System.out.println(getMax(d[n][0],d[n][1],d[n][2]));
//	}
//	static int getMax(int a, int b,int c) {
//		int max = a;
//		if(max < b)max = b;
//		if(max < c)max = c;
//		return max;
//	}
//}
//public class BJ2156{
//	static int[] wine;
//	static int[] d;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		wine = new int[n+1];
//		d = new int[n+1];
//		for(int i=1;i<=n;i++) {
//			wine[i] = stdIn.nextInt(); 
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		if(n == 1) {
//			System.out.println(wine[n]);
//			return;
//		}
//			
//		d[1] = wine[1];
//		d[2] = wine[1] + wine[2];
//		for(int i=3;i<=n;i++) {
//			d[i] = getMax(d[i-2] + wine[i] , d[i-3] + wine[i] +wine[i-1], d[i-1]);
//		}
//		System.out.println(d[n]);
//	}
//	static int getMax(int a, int b,int c) {
//		int max = a;
//		if(max < b)max = b;
//		if(max < c)max = c;
//		return max;
//	}
//}
