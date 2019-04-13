// 12865번
// 평범한 배낭   
// DP
// 냅색 문제 
// 햇갈림.. 

import java.util.Scanner;
public class BJ12865 {
	static int[][] item;
	static int[][] d;
	static int[] d2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k= stdIn.nextInt();
		item = new int[n+1][2];
		d = new int[n+1][k+1];
		d2 = new int[k+1];
		for(int i=1;i<=n;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			item[i][0] = a;
			item[i][1] = b;
		}
//		solve(n,k);
		solve2(n,k);
	}
	static void solve2(int n, int k) {
		
		for(int i=1;i<=n;i++) {
			for(int j=k;j>=1;j--) {
				if(j-item[i][0] >= 0 && d2[j] < d2[j-item[i][0]] + item[i][1]) 
					d2[j] = d2[j-item[i][0]] + item[i][1];
			}
		}
		System.out.println(d2[k]);
	}
	static void solve(int n, int k) {
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				int max = d[i-1][j];
				if(j-item[i][0] >=0 && max < d[i-1][j-item[i][0]] + item[i][1])
					max = d[i-1][j-item[i][0]] + item[i][1];
				d[i][j]  = max;
				
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				System.out.printf("%d ", d[i][j]);
			}
			System.out.println();
		}
		System.out.println(d[n][k]);;
	}
}
