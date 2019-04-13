// 2294번 (복습)
// 동전 2 
// 동적 계획법 (Dynamic Programming) 
// 동전 1보다 쉬움..
// 112, 211, 121 같은 경우 고려할 필요가 없음. 

import java.util.Scanner;
public class Re_BJ2294 {
	static int n;
	static int k;
	static int[] w;
	static int[][]d ;
	static int[] min;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		k = stdIn.nextInt();
		w = new int[n+1];
		d = new int[n+1][k+1];
		min = new int[k+1];
		for(int i=1;i<=n;i++) {
			w[i] = stdIn.nextInt();
		}
		solve();
		System.out.println(min[k]>=100000?-1:min[k]);
	}
	static void solve() {
		min[0] = 0;
		for(int i=1;i<=k;i++) {
			min[i] = 100000;
			for(int j=1;j<=n;j++) {
				if(i-w[j]>=0 && min[i] > min[i-w[j]]+1) {
					min[i] = min[i-w[j]]+1;
				}
				
			}
		}
	}
}
