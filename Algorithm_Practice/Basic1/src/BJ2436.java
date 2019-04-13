// 2436번 
// 공약수 
// 최대공약수, 최대공배수, 서로소 성질 

// https://twpower.github.io/69-how-to-get-gcd-and-lcm 

import java.util.ArrayList;
import java.util.Scanner;
public class BJ2436 {
	public static void main (String args[]) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int gcd = stdIn.nextInt(); // 최대공약수 
		int lcm = stdIn.nextInt(); // 최소공배수 
		if(lcm%gcd==0) // 답이 없는 경우 
			getNumbers(gcd, lcm);
	}
	// getNumbers 
	// 두 자연수 출력 
	static void getNumbers(int g, int l){
		
		int n = l/g; // LCM/GCM
		ArrayList<Integer> small = new ArrayList<>();
		ArrayList<Integer> big = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			int n1 = i;
			int n2 = n/i;
			
			if(n%i == 0 && isCoprime(n1,n2)) { // 두 자연수 후보는 서로서여야함. 
				if(i>n/i) // 굳이 이러지 않고 반복문을 sqrt(n)만큼 돌리면 됨.
					break;
				
				small.add(i);
				big.add(n/i);
			}
		}
		int n1 = small.get(small.size()-1);
		int n2 = big.get(big.size()-1);
		System.out.printf("%d %d", n1*g, n2*g);
	}
	// isCoprime
	// 두 자연수가 서로서인가 판단 
	// 서로소이려면 두 자연수의 최대공약수가 1이면 됨.
	static boolean isCoprime(int n1, int n2) {
			for(int i=2;i<=n1; i++) {
				if(n1%i == 0 && n2%i == 0)
					return false;
			}
		return true;
	}
	
	// getGCD 
	// 최대공약수 구하는 알고리즘
	// 반환값이 1이면 두 자연수는 서로소이다.
	static int getGCD(int a, int b){
		while(b!=0){
			int r = a%b;
			a= b;
			b= r;
		}
		return a;
	}
}
