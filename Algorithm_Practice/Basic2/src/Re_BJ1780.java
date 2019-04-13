// 1780번 (복습) 
// 종이의 개수 
// 분할 정복 (Divide and Conquer) 
// 커다란 문제를 작은 문제로 나누어 해결  

import java.util.Scanner;
public class Re_BJ1780 {
	static int[][] map;
	static int n;
	static int[] ans = new int[3];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve(0,0,n);
		for(int i : ans) {
			System.out.println(i);
		}
	}
	static void solve(int x, int y, int k) {

		int v = map[x][y];
		boolean flag = true;
		for(int i=x;i<x+k;i++) {
			for(int j=y;j<y+k;j++) {
				if(v != map[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag == false)
				break;
		}
		
		if(flag == false) {
			for(int i=x;i<x+k;i+=(k/3)) {
				for(int j=y;j<y+k;j+=(k/3)) {
					solve(i,j,k/3);
				}
			}
		}else {
			ans[v+1]++;
		}
	}
}
