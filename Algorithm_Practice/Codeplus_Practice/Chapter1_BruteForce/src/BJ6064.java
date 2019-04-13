// 6064번 
// 카잉 달력 
// 브루트 포스 

import java.util.Scanner;
public class BJ6064 {
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int m = stdIn.nextInt();
			int n = stdIn.nextInt();
			int x = stdIn.nextInt();
			int y = stdIn.nextInt();
			solve(m,n,x,y);
		}
	}
	static void solve(int m, int n, int x, int y) {
		// 브루트 포스지만 
		// 가능성이 있는 경우만 탐색 
		for(int i = x ;i<=m*n;i+=m) {
			if((i-1)%n + 1 == y) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
