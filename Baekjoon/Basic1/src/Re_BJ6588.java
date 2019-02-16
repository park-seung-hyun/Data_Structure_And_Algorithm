// 6588번 (복습)
// 골드바흐의 추측 
// 소수(Prime) 검정을 위해 
// 에라토스테네스의 체 (Eratosthenes) 사용 

import java.util.Scanner;
public class Re_BJ6588 {
	static int[] prime;
	static boolean[] check;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		eratosthenes(1000000);
		
		while(true) {
			int n = stdIn.nextInt();
			if(n == 0)
				break;
			
			goldbach(n);
		}
	}
	static void goldbach(int n) {
		for(int i=3;i<=n/2;i+=2) {
			int a = i;
			int b = n-a;
			if(check[a]== false && check[b]==false) {
				System.out.printf("%d = %d + %d\n", n,a,b);
				return;
			}
		}
		System.out.println("Goldbach's conjecture is wrong.");
	}
	static void eratosthenes(int n) {
		prime = new int[n];
		check = new boolean[n+1];
		int pp=0;
		for(int i=2;i<=n;i++) {
			if(check[i] == false) {
				prime[pp++] = i;
				for(int j = i*2;j<=n;j+=i) {
					check[j] = true;
				}
			}
		}
		check[0] = true;
		check[1] = true;
	}
}
