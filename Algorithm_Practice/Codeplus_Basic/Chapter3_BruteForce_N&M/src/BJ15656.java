// 15656번
// N과 M (7)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15656 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		Arrays.sort(ar);
		solve(0,n,m,ar,"");
	}
	static void solve(int index, int n, int m,int[] ar, String s) {
		if(index==m) {
			System.out.println(s);
			return;
		}
		for(int i=0;i<n;i++) {
			solve(index+1,n,m,ar, s+ar[i]+' ');
		}
	}
}
