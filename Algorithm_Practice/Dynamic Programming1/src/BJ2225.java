// 2225번  
// 합분해 
// 동적 계획법 (Dynamic Programming) 

// https://lmcoa15.tistory.com/64
	
import java.util.Scanner;
public class BJ2225 {
	// 각 N, K일때 경우의 수를 저장한 배열 
	static long[][] memory;
	public static void main (String[] args) {
		// 입출력
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		int K = stdIn.nextInt();
		memory = new long[K+1][N+1];
		
		// 초기화 
		for(int i=1;i<=N;i++) {
			memory[1][i] = 1;
		}
		for(int i=1;i<=K;i++) {
			memory[i][1] = i;
		}
		System.out.println(dp(K, N));
	}
	// dp
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Bottom-Up 방식 
	static long dp (int k, int n) {
		
		for(int i=2;i<=k;i++) {
			for(int j=2;j<=n;j++) {
				memory[i][j] = memory[i-1][j] % 1000000000 + memory[i][j-1] % 1000000000;
			}
		}
		return memory[k][n] % 1000000000;
	}
}
