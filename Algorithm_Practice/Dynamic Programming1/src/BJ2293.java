// 2293번 
// 동전 1 
// 동적 계획법 (Dynamic Programming) 

// http://debuglog.tistory.com/78
// http://coding-all.tistory.com/2

import java.util.Scanner;
public class BJ2293 {
	public static void main(String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int k = stdIn.nextInt();
		int[] coin = new int[N+1]; // 인덱스 0에 0원 추가 
		for(int i=1;i<=N;i++) {
			coin[i] = stdIn.nextInt();
		}
		System.out.print(dp(coin, k));		
	}
	// dp
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	static int dp (int[] c, int k) {
		int[][] d = new int[c.length][k+1]; // i, k 가 0일때 추가 
		
		// 초기화 
		d[0][0] = 1;
		for(int i=1;i<=k;i++) { // 0~10
			d[0][i] = 0;
		}
		
		// 점화식 
		for(int i=1;i<c.length;i++) {
			for(int j=0;j<=k;j++) {
				if(c[i]>j)
					d[i][j] = d[i-1][j];
				else
					d[i][j] = d[i][j-c[i]] + d[i-1][j];
			}
		}
		return d[c.length-1][k];
	}
}
