// 15657번
// N과 M (8)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15657 {
	static int[] cnt;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ar = new int[n];
		cnt = new int[n];
		
		for(int i=0;i<n;i++) {
			ar[i]= stdIn.nextInt();
		}
		Arrays.sort(ar);
//		solve(0,0,n,m,ar,"");
		solve2(0,0,n,m,ar);
	}
	static void solve(int index, int start, int n, int m, int[] ar, String s) {
		if(index == m) {
			System.out.println(s);
			return;
		}
		for(int i = start;i<n;i++) {
			solve(index+1, i, n, m, ar, s+ar[i] + " ");
		}
	}
	static void solve2(int index, int selected, int n, int m , int[] ar) {
		if(selected == m) {
			for(int i=0;i<n;i++) {
				for(int j =0;j<cnt[i];j++) {
					System.out.printf("%d ",ar[i]);
				}
			}
			System.out.println();
			return;
		}
		if(index == n) {
			return;
		}
		for(int i=m-selected;i>=0;i--) {
			cnt[index] = i;
			solve2(index+1, selected+i, n, m , ar);
		}
	}
}
