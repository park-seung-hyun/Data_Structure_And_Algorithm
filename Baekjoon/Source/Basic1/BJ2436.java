// 2436번 
// 공약수 
// 최대공약수, 최대공배수, 서로소 성질 

import java.util.ArrayList;
import java.util.Scanner;
public class BJ2436 {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int gcd = stdIn.nextInt();
		int lcm = stdIn.nextInt();
		if(lcm%gcd==0)
			getNumbers(gcd, lcm);
	}
	static void getNumbers(int g, int l){
		
		int n = l/g;
		ArrayList<Integer> small = new ArrayList<>();
		ArrayList<Integer> big = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			int n1 = i;
			int n2 = n/i;
			
			if(n%i == 0 && isCoprime(n1,n2)) {
				if(i>n/i)
					break;
				
				small.add(i);
				big.add(n/i);
			}
		}
		int n1 = small.get(small.size()-1);
		int n2 = big.get(big.size()-1);
		System.out.printf("%d %d", n1*g, n2*g);
	}
	static boolean isCoprime(int n1, int n2) {
			for(int i=2;i<=n1; i++) {
				if(n1%i == 0 && n2%i == 0)
					return false;
			}
		return true;
	}
	static int getGCD(int a, int b){
		while(b!=0){
			int r = a%b;
			a= b;
			b= r;
		}
		return a;
	}
}
