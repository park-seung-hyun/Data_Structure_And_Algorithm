// 1929번
// 소수 구하기 
// 에라토스테네스의 체 

import java.util.Scanner;
public class BJ1929 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int M = stdIn.nextInt();
		int N = stdIn.nextInt();
		eratosthenes(N,M);
	}
	static void eratosthenes(int n, int m) {
		int[] prime = new int[n+1];
		boolean[] check = new boolean[n+1];
		int pp = 0;
		for(int i=2;i<=n;i++) { // i*i<=n 해도되지만 대신 prime[]을 못 만듬.
			if(check[i] == false) {
				prime[pp++] = i;
				for(int j = i*2;j<=n;j+=i) { // i*i가 아닌 i*2를 하는 이유는 int형을 벗어날 수 있음. 
					check[j] = true;
				}
			}
		}
		for(int i=0;i<prime.length;i++) {
			if(prime[i] == 0)
				break;
			if(prime[i]>=m)
				System.out.println(prime[i]);
		}
	}
}
