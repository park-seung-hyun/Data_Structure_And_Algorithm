// 10844번  
// 쉬운 계산 수 
// 동적 계획법 (Dynamic Programming) 

// 자료형 -> long 
// 중간 중간에 1000000000 % 
// 자료형 조심 

import java.util.Scanner;
public class BJ10844 {
	static long[][] memory;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int N = stdIn.nextInt();
		memory = new long[N+1][10];
		memory[1][0] = 0;
		for(int i=1;i<10;i++) {
			memory[1][i] = 1;
		}
		System.out.print(dp(N));
	}
	static long dp(int n) {
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					memory[i][j] = memory[i-1][j+1] % 1000000000;
				}else if(j==9) {
					memory[i][j] = memory[i-1][j-1 % 1000000000];
				}else {
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
