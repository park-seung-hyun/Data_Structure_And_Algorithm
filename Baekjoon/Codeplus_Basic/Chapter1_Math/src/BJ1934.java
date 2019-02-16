// 1934번
// 최소공배수 
// GCD(a,b) = GCD(b, a%b)
// a%b가 0일 경우 b가 GCD
// LCM(a,b) = (a*b)/GCD(a,b)

import java.util.Scanner;
public class BJ1934 {
	public static void main (String[] args) {
		Scanner stdIn =  new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			System.out.println(lcm(a,b));
		}
	}
	static int lcm(int a, int b) {
		return (a*b)/gcd(a,b);
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
}
