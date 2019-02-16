// 2312번 
// 수 복원하기 
// 소인수분해 (Fractional decomposition) 
// 소수(Prime) 구하기 -> 좀 외우자 

import java.util.Scanner;

public class BJ2312 {
	static int[] buff;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] al = new int[n];
		
		for(int i=0;i<n;i++) {
			al[i] = stdIn.nextInt();
		}

		for(int i=0;i<n;i++) {
			buff = new int[al[i]+1]; // 해당 숫자의 인수를 저장할 배열 
			fd(al[i]);
			buff = null;
		}
	}
	// fd 
	// 소인수분해 과정 
	static void fd(int n) {
		int[] prime = getPrime(n); // 해당 숫자까지 소수들을 저장한 배열 
		
		for(int i : prime) { // 해당 숫자보다 작은 소수들에 대해 반복 
			if(i == 0)
				break;
			
			while(n%i == 0) { // 인수 분해가 가능한 경우 
				n = n / i;
				buff[i]++; // 해당 인덱스(인수)에 +1 (개수)
			}
			if(n == 1)
				break;
		}

		for(int i=2;i<buff.length;i++) {
			if(buff[i] != 0)
				// 인수와 해당 인수의 개수를 출력 
				System.out.printf("%d %d \n", i , buff[i]);
		}
		
	}
	// getPrime 
	// 소수를 구하는 함수 
	static int[] getPrime(int num) {
		int[] prime = new int[num]; // 해당 숫자까지 소수를 저장할 배열 
		
		int ptr = 0; // 포인터 
		// 2, 3은 미리 저장 
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for(int n=5;n<=num;n=n+2) { // 5~num까지 홀수 숫자 중 소수인 숫자를 찾음. (짝수는 무의미)
			boolean flag = false;
			// n보다 작은 소수들로만 반복 
			for(int i=1;prime[i]*prime[i]<=n;i++) { // n의 제곱근까지만 나눠보면됨. 그 이후로는 반복이므로 무의미 (3부터 확인)
				if(n%prime[i]==0) { // 나누어떨어지면 소수가 아닌 것으로 판별 -> 탈출 
					flag = true; 
					break;
				}
			}
			if(flag == false) { // 소수일 경우 
				prime[ptr++] = n;
			}
		}
		return prime;
	}
}
