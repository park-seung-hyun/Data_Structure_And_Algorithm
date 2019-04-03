// 1495번
// 기타리스트    
// DP
// 0,1 냅색 문제 

import java.util.ArrayList;
import java.util.Scanner;
public class BJ1495 {
	static int[] vol;
	static ArrayList<Integer> al;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int s = stdIn.nextInt();
		int m = stdIn.nextInt();
		al = new ArrayList<Integer>();
		d = new int[n+1][m+1];
		vol = new int[n+1];
		for(int i=0;i<n;i++) {
			vol[i] = stdIn.nextInt();
		}
//		solve(n,s,m);
		solve2(n,s,m);
	}
	// 2차원 배열 선언 -> 메모리 초과 안나네? 
	static void solve2(int n, int s, int m) {
		d[0][s] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=m;j++) {
				if(d[i][j] == 1) {
					if(j- vol[i] >=0)
						d[i+1][j - vol[i]] = 1;
					if(j + vol[i] <= m)
						d[i+1][j + vol[i]] = 1;
				}
			}
		}
		for(int i=m;i>=0;i--) {
			if(d[n][i] == 1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	// 처음에 시도했던 방법 
	// 메모리 초과 
	static void solve(int n, int s, int m) {
		al.add(s);
		for(int i=1;i<=n;i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int pre : al) {
				if(pre + vol[i] >=0 && pre + vol[i] <= m) temp.add(pre + vol[i]);
				if(pre - vol[i] >=0 && pre - vol[i] <= m) temp.add(pre - vol[i]);
			}
			al = temp;
		}
		int max = 0;
		if(al.isEmpty()) {
			System.out.println(-1);
			return;
		}
		for(int best : al) {
			if(max < best) max = best;
		}
		System.out.println(max);
	}
}
