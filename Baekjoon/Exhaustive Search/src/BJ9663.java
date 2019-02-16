// 9663번 
// N-Queen
// DFS (Depth-First-Search)
// Back-Tracking

// 다른 소스 참고해서 깔끔하게 풀어보기 
// https://mygumi.tistory.com/199

import java.util.Scanner;

public class BJ9663 {
	static int n;
	static int[][] ar;
	
	static boolean rowV[];
	static boolean colV[];
	static boolean crossV[];
	static boolean crossV2[];
	
	static int count = 0;
	
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		ar = new int[n][n];

		rowV = new boolean[n]; // 행 방문 여부 (해당 행에 퀸을 놓을 수 있는지)
		colV = new boolean[n]; // 열 방문 여부 
		crossV = new boolean[2*n-1]; // 대각선1 방문 여부 
		crossV2 = new boolean[2*n-1]; // 대각선2 방문 여부 
		nQueen();
	}
	// nQueen
	// 퀸을 배치할 수 있는 모든 경우의 수를 구하는 함수 
	static void nQueen() {
		
		for(int i=0;i<n;i++) {
			// 방문 
			// 해당 행, 열, 대각선에는 퀸을 놓을 수 없음. 
			rowV[0] = true;
			colV[i] = true;
			crossV[0-i + n-1] = true;
			crossV2[0+i] = true;
			
			dfs(0);
			
			// Back-Tracking
			rowV[0] = false;
			colV[i] = false;
			crossV[0-i + n-1] = false;
			crossV2[0+i] = false;
		}
		System.out.println(count);
	}
	// dfs
	// Depth-First-Search 
	static void dfs(int r) {
		r = r+1;
		if(r == n) {
			count ++;
			return;
		}
		for(int j=0;j<n;j++) {
			
			// 해당 행, 열, 대각선에 놓을 수 있는지 확인 
			if(rowV[r]==false && colV[j] ==false && crossV[r-j + n-1]==false && crossV2[r+j] == false) {
				rowV[r] = true;
				colV[j] = true;
				crossV[r-j + n-1] = true;
				crossV2[r+j] = true;
				
				dfs(r);
				
				// Back-Tracking 
				rowV[r] = false;
				colV[j] = false;
				crossV[r-j + n-1] = false;
				crossV2[r+j] = false;
			}
		}
	}
}
