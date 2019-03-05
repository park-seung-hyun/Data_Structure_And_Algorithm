// 1992번 (복습)
// 쿼드트리 
// 분할 정복 (Divide and Conquer) 
// 커다란 문제를 작은 문제로 나누어 해결 

import java.util.Scanner;
public class Re_BJ1992 {
	static int[][] map;
	static String ans = "";
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		map = new int[n][n];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		solve(0,0,n);
		System.out.println(ans);
	}
	static void solve(int x, int y, int k) {
		
		if(!check(x,y,k)) {
			ans += "(";
			for(int i=x;i<x+k;i+=(k/2)) {
				for(int j=y;j<y+k;j+=(k/2)) {
					solve(i,j,k/2);
				}
			}
			ans += ")";
		}else {
			ans += map[x][y];
		}
	}
	static boolean check(int x, int y, int k) {
		int v = map[x][y];
		for(int i=x;i<x+k;i++) {
			for(int j=y;j<y+k;j++) {
				if(map[i][j] != v)
					return false;
			}
		}
		return true;
	}
}
