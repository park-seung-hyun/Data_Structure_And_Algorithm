// 9613번
// GCD합  
// GCD(a,b) = GCD(b, a%b)
// a%b가 0일 경우 b가 GCD
// 1<n<=100 이므로 조합상 sum이 int형을 벗어날 수 있다. 
// 때문에 sum을 long으로 선언한다.

import java.util.Scanner;
public class BJ9613 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			int[] ar = new int[n];
			for(int j=0;j<n;j++) {
				ar[j] = stdIn.nextInt();
			}
			System.out.println(gcdSum(ar, n));
		}
	}
	static long gcdSum(int[] ar, int n) {
		long sum = 0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				sum+=gcd(ar[i], ar[j]);
			}
		}
		return sum;
	}
	static int gcd(int a, int b) {
		while(b!=0) {
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
			return gcd2(b, a%b);
		}
	}
}
