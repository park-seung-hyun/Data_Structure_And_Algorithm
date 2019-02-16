// 15655번
// N과 M (6)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15655 {
	static int[] ans;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ar = new int[n];
		ans = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		Arrays.sort(ar);
//		solve(0,0,n,m,ar);
		solve2(0,0,n,m,ar);
	}
	static void solve(int index,int start, int n, int m, int[] ar) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ", ar[ans[i]]);
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {
			ans[index] = i;
			solve(index+1,i+1,n,m, ar);
		}		
	}
	static void solve2(int index,int selected, int n, int m, int[] ar) {
		if(selected == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ", ar[ans[i]]);
			}
			System.out.println();
			return;
		}
		if(index == n) {
			return;
		}
		ans[selected] = index;
		solve2(index+1, selected+1,n,m,ar);
		solve2(index+1, selected,n,m,ar);
	}
}
