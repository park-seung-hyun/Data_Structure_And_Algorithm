// 15654번
// N과 M (5)
// 재귀 호출 
// N과 M (1)과는 달리 
// 1 ~ N 수가 아니라 임의의 N개의 자연수 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15654 {
	static boolean[] check;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		check = new boolean[n];
		
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		Arrays.sort(ar);
		solve(0,n,m,ar, "");
	}
	static void solve(int index, int n, int m, int[] ar, String s) {
		if(index == m) {
			System.out.println(s);
			return;
		}
		for(int i=0;i<n;i++) {
			if(check[i] == false) {
				check[i] = true;
				solve(index+1, n, m, ar, s + ar[i] + ' ');
				check[i] = false;
			}
		}
	}
}
