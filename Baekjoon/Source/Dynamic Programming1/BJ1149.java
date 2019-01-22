// 1149번  
// RGB 거리 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class BJ1149 {
	static int[][] mc;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[][] rgb = new int[N][3];
		mc = new int[N][3];
		
		for(int i=0;i<N;i++) {
			rgb[i][0] = stdIn.nextInt();
			rgb[i][1] = stdIn.nextInt();
			rgb[i][2] = stdIn.nextInt();
		}
		mc[0][0] = rgb[0][0];
		mc[0][1] = rgb[0][1];
		mc[0][2] = rgb[0][2];
		
//		 Top-Down 
//		minimumCost(rgb, N-1);
//		System.out.print(getMinimum(mc[N-1][0],mc[N-1][1],mc[N-1][2]));
		
		// Bottom-Top
		System.out.print(minimumCost2(rgb, N-1));
		
	}
	static void minimumCost(int[][] rgb, int n) {
		
		if(mc[n][0] != 0)
			getMinimum(mc[n][0],mc[n][1],mc[n][2]);
		else {
			
			if(mc[n-1][0] == 0) { 
				minimumCost(rgb, n-1);
			}
			mc[n][0] = (mc[n-1][1]>mc[n-1][2] ? mc[n-1][2]: mc[n-1][1]) + rgb[n][0];
			mc[n][1] = (mc[n-1][0]>mc[n-1][2] ? mc[n-1][2]: mc[n-1][0]) + rgb[n][1];
			mc[n][2] = (mc[n-1][0]>mc[n-1][1] ? mc[n-1][1]: mc[n-1][0]) + rgb[n][2];
			
		}
	}
	static int minimumCost2(int[][] rgb, int n) {
		for(int i=1;i<=n;i++) {
			mc[i][0] = (mc[i-1][1]>mc[i-1][2] ? mc[i-1][2] : mc[i-1][1]) + rgb[i][0];
			mc[i][1] = (mc[i-1][0]>mc[i-1][2] ? mc[i-1][2] : mc[i-1][0]) + rgb[i][1];
			mc[i][2] = (mc[i-1][0]>mc[i-1][1] ? mc[i-1][1] : mc[i-1][0]) + rgb[i][2];
		}
		return getMinimum(mc[n][0],mc[n][1],mc[n][2]);
	}
	static int getMinimum(int a, int b, int c) {
		int min = a;
		if(b<min) {
			min = b;
		}
		if(c<min) {
			min = c;
		}
		return min;
	}

}
