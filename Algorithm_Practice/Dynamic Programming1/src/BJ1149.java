// 1149번  
// RGB 거리 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class BJ1149 {
	static int[][] mc; // (첫번째 인덱스 집 수, 두번째 인덱스 색깔) 일때 최소 비용 
	public static void main(String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[][] rgb = new int[N][3];
		mc = new int[N][3];
		
		for(int i=0;i<N;i++) {
			rgb[i][0] = stdIn.nextInt();
			rgb[i][1] = stdIn.nextInt();
			rgb[i][2] = stdIn.nextInt();
		}
		// 초기화 
		mc[0][0] = rgb[0][0];
		mc[0][1] = rgb[0][1];
		mc[0][2] = rgb[0][2];
		
//		 Top-Down 
//		minimumCost(rgb, N-1);
//		System.out.print(getMinimum(mc[N-1][0],mc[N-1][1],mc[N-1][2]));
		
		// Bottom-Top
		System.out.print(minimumCost2(rgb, N-1));
		
	}
	// minimumCost 
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Top-Down 방식 
	static void minimumCost(int[][] rgb, int n) {
		
		if(mc[n][0] != 0) // 해당 인덱스의 최소 비용이 계산되어 있는 경우 -> 쓸모없어 보임. 
			getMinimum(mc[n][0],mc[n][1],mc[n][2]);
		else { // 해당 인덱스의 최소 비용이 계산되어 있지 않은 경우 -> 계산 
			
			// 전 단계 최소 비용이 게산되어 있는지 확인 
			if(mc[n-1][0] == 0) { 
				minimumCost(rgb, n-1);
			}
			
			// 점화식 
			mc[n][0] = (mc[n-1][1]>mc[n-1][2] ? mc[n-1][2]: mc[n-1][1]) + rgb[n][0];
			mc[n][1] = (mc[n-1][0]>mc[n-1][2] ? mc[n-1][2]: mc[n-1][0]) + rgb[n][1];
			mc[n][2] = (mc[n-1][0]>mc[n-1][1] ? mc[n-1][1]: mc[n-1][0]) + rgb[n][2];
			
		}
	}
	// minimumCost2
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Bottom-Top 방식 
	static int minimumCost2(int[][] rgb, int n) {
		for(int i=1;i<=n;i++) {
			mc[i][0] = (mc[i-1][1]>mc[i-1][2] ? mc[i-1][2] : mc[i-1][1]) + rgb[i][0];
			mc[i][1] = (mc[i-1][0]>mc[i-1][2] ? mc[i-1][2] : mc[i-1][0]) + rgb[i][1];
			mc[i][2] = (mc[i-1][0]>mc[i-1][1] ? mc[i-1][1] : mc[i-1][0]) + rgb[i][2];
		}
		return getMinimum(mc[n][0],mc[n][1],mc[n][2]);
	}
	// getMinimum
	// 세 정수가 주어졌을 경우 최소 값 도출 함수 
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
