// 15649번
// N과 M (1)
// 재귀 호출 

import java.util.Scanner;
public class BJ15649 {
	static int[] ans = new int[10];
	static boolean[] check ; // 방문 여부 -> 중복 불가이므로 
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		check = new boolean[n]; 
		solve(0,m,n);
	}
	static void solve(int index, int m, int n) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ",ans[i]);
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(check[i] == false) {
				ans[index] = i+1;
				check[i] = true;
				solve(index+1,m,n);
				check[i] = false;
			}
		}
	}
}
