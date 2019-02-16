// 15652번
// N과 M (4)
// 재귀 호출 

import java.util.Scanner;
public class BJ15652 {
	static int[] cnt = new int[10];
	static int[] ans = new int[10];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
//		solve(0,1,n,m);
		solve2(1,0,n,m);
	}
	static void solve(int index,int start, int n, int m) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ", ans[i]);
			}
			System.out.println();
			return ;
		}
		for(int i=start;i<=n;i++) {
			ans[index] = i;
			solve(index+1,i,n,m);
		}
	}
	static void solve2(int index, int selected, int n , int m) {
		if(selected==m) {
			for(int i=1;i<=n;i++) {
				for(int j =1;j<=cnt[i];j++) {
					System.out.printf("%d ", i);
				}
			}
			System.out.println();
			return;
		}
		if(index>n) {
			return;
		}
		for(int i = m-selected;i>=0;i--) {
			cnt[index] = i;
			solve2(index+1, selected+i, n, m);
		}
	}
}
