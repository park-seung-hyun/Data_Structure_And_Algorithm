// 2609번
// 최대공약수와 최소공배수 
// GCD(a,b) = GCD(b, a%b)
// a%b가 0일 경우 b가 GCD
// LCM(a,b) = (a*b)/GCD(a,b)

import java.util.Scanner;
public class BJ2609 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int A = stdIn.nextInt();
		int B = stdIn.nextInt();
		System.out.println(gcd(A,B));
		System.out.println(lcm(A,B));
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	static int gcd2(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
	static int lcm(int a, int b) {
		return (a*b)/gcd(a,b);
	}
}
