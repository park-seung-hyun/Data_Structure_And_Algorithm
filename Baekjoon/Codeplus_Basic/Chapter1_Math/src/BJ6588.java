// 6588번
// 골드바흐의 추측 
// 에라토스테네스의 체 

import java.util.Scanner;

public class BJ6588 {
	static boolean[] check;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 입력 범위가 6 ≤ n ≤ 1000000 이므로 처음 한번만 해주면 된다.
		// 매번 해줘서 시간초과가 났었다. 
		eratosthenes(1000000);
		while(true) {
			int n = stdIn.nextInt();
			if(n==0)
				break;
			goldbach(n);
		}
	}
	static void goldbach(int n) {
		// 홀수인 소수이므로 시작을 3으로 2씩 증가시킨다. 
		for(int i=3;i<=(n/2);i+=2) {
			int a = i;
			int b = n - a;
			if(check[b]==false && check[a]== false) {
				System.out.printf("%d = %d + %d\n",n,a,b);
				return;
			}	
		}
		System.out.println("Goldbach's conjecture is wrong.");
	}
	static void eratosthenes(int n) {
		check = new boolean[n+1];
		for(int i=2;i*i<=n;i++) {
			if(check[i]==false) {
				for(int j = i*i;j<=n;j+=i) {
					check[j] = true;
				}
			}
		}
		check[0]=true;
		check[1]=true;
	}
}
