// 2294번 
// 동전 2 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class BJ2294 {
	// 해당 인덱스가 k일 경우 사용한 동전 최소 개수를 저장한 배열 
	static int[] minAr;
	public static void main (String[] args) {
		// 입출력
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		int k = stdIn.nextInt();
		minAr = new int[k+1];
		
		int[] coin = new int[N+1];
		for(int i=1;i<=N;i++) {
			coin[i] = stdIn.nextInt();
		}
		// 초기화 
		minAr[0] = 0;
		for(int i=1;i<minAr.length;i++) {
			minAr[i] = -1;
		}
		// 2000000000 이상일 경우는 불가능한 경우 
		System.out.print((dp(coin, k) >= 2000000000) ? -1 : dp(coin, k));
	}
	// dp
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Top-Down 방식 
	static int dp(int[] c, int k) {
		int min = 2000000000; 
	
		// 동전 종류만큼 반복 
		for(int i=1;i<c.length;i++) {
			// 각 반복마다 k에서 해당 동전만큼 감소했을때 양수, 음수 여부 
			if(k-c[i]>=0) {
				if(minAr[k-c[i]] == -1) { // 배열이 채워져있지 않은 경우 
					minAr[k-c[i]] = dp(c, k-c[i]); // 재귀를 통해 구하여 저장 
				}
				if(min > minAr[k-c[i]]) { // 
					min = minAr[k-c[i]] + 1; // minAr[k-c[i]]일 경우에 c[i]를 뻈으므로 1을 증가 
				}
			}
		}
		return min;
	}
}
