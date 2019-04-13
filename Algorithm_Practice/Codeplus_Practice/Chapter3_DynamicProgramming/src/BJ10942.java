// 10942번 
// 팰린드롬? 
// DP

import java.util.Arrays;
import java.util.Scanner;
public class BJ10942 {
	static int[] num;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n+1];
		d = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			num[i] = stdIn.nextInt();
		}
		int t = stdIn.nextInt();
		
		
		for(int i=1;i<=n;i++)Arrays.fill(d[i], -1);
		StringBuilder sb = new StringBuilder();
		while(t --> 0) {
			// 이 안에 System.out.println() 이 있는 것이 문제인 
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			int ans = solve2(a,b);
			if(ans == 1) sb.append(1);
			else sb.append(0);	
			sb.append('\n');	
		}
		System.out.println(sb);
		
		// Bottom-Up
//		fillD(n);
//		solve(n);
	
		// 시간초과 문제.... 
		// System.out.println(); t번 하는 것은 시간 초과 
		// StringBuilder에 출력할거 다 넣고
		// 마지막에 출력 
//		StringBuilder sb = new StringBuilder();
//		while(t --> 0) {
//			// 이 안에 System.out.println() 이 있는 것이 문제인 
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			if(d[a][b] == 1) sb.append(1);
//			else sb.append(0);	
//			sb.append('\n');	
//		}
//		System.out.println(sb);
	}
	static int solve2(int i,int j) {
		if(i == j) return 1;
		if(i+1 == j && num[i] == num[j]) return 1;
		if(d[i][j] >=0) return d[i][j];
		
		if(num[i] == num[j] && solve2(i+1, j-1) == 1) {
			d[i][j] = 1;
			return 1;
		}else {
			d[i][j] = 0;
			return 0;
		}
	}
	static void solve(int n) {
		for(int i=1;i<=n;i++) d[i][i] = 1;
		for(int i=1;i<n;i++) { 
			if(num[i] == num[i+1])
				d[i][i+1] = 1;
		}
		for(int k=3;k<=n;k++) {
			for(int i=1;i<=n-k+1;i++) {
				int j = i+k-1;
				if(num[i] == num[j] && d[i+1][j-1] == 1) {
					d[i][j] = 1;
				}
			}
		}
	}
	// 처음에 시도한 방법 
	// 사실 다 맞았는데 
	// 배열을 다 채울 필요는 없음. 
	static void fillD(int n) {
		for(int i=1;i<=n;i++)
			d[i][i] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++){
			// j와 j+i
				if(j+i <= n && num[j]==num[j+i]) {
					if(i==1)
						d[j][j+i] = 1;
			 		else {
						if(d[j+1][j+i-1] == 1) {
							d[j][j+i] = 1;
						}
					}
				}	
			}
		}

	}

}
