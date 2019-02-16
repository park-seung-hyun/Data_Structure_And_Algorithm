// 1978번
// 소수 찾기 
// 루트 n 까지만 나눠보면됨. 

import java.util.Scanner;
public class BJ1978 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int cnt = 0;
		for(int i=0;i<t;i++) {
			cnt+=isPrime(stdIn.nextInt())?1:0;
		}
		System.out.println(cnt);
	}
	static boolean isPrime(int n) {
		if(n<2)
			return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
	static boolean isPrime2(int n) {
		if(n<2)
			return false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	static boolean isPrime3(int n) {
		if(n<2)
			return false;
		for(int i=2;i<=n-1;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
