// 2436번 (복습)
// 공약수 
// 최대공약수, 최대공배수 성질 
// LCM = (a*b)/GCD 

import java.util.Scanner;
public class Re_BJ2436 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		long g = stdIn.nextInt();
		long l = stdIn.nextInt();
		long ra = 0;
		long rb = 0;
		for(long i=1;i*i<=g*l;i++) {
			long a = i;
			long b = (g*l)/a;
			if(a*b == g*l && gcd(a,b)==g) {
				ra = a;
				rb = b;
			}
		}
		System.out.printf("%d %d",ra, rb);
	}
	static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}
}
