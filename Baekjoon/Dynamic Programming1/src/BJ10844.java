// 10844번  
// 쉬운 계산 수 
// 동적 계획법 (Dynamic Programming) 

// 자료형 -> long 
// 중간 중간에 1000000000 % 
// 자료형 조심 

import java.util.Scanner;
public class BJ10844 {
	static long[][] memory; // 끝자리가 각 인덱스일 경우 값 저장하는 배열 
	public static void main(String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		memory = new long[N+1][10];
		
		// 초기화 
		memory[1][0] = 0;
		for(int i=1;i<10;i++) {
			memory[1][i] = 1;
		}
		System.out.print(dp(N));
	}
	// dp 
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Bottom-Up 방식 
	static long dp(int n) {
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				// 점화식 
				// 중간에 1000000000 % 
				if(j==0) { // 끝자리가 0 일 경우 
					memory[i][j] = memory[i-1][j+1] % 1000000000;
				}else if(j==9) { // 끝자리가 9일 경우 
					memory[i][j] = memory[i-1][j-1 % 1000000000];
				}else { // 나머지 경우 
					memory[i][j] = (memory[i-1][j+1] +  memory[i-1][j-1]) % 1000000000;
				}
			}
		}
		
		long total = 0;
		for(int k=0;k<10;k++) {
			total += memory[n][k];
		}
		return total % 1000000000 ;
	}
}
