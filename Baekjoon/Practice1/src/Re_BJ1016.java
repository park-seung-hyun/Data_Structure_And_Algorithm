// 1016번 
// 제곱ㄴㄴ수  
// 에라토스테네스의 체 (Eratosthenes) 응용 

import java.util.Scanner;
public class Re_BJ1016 {
	static long min;
	static long max;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		min = stdIn.nextLong();
		max = stdIn.nextLong();
		check = new boolean[1000001];
		solve();
	}
	static void solve() {
		art();
		int cnt = 0;
		for(long i=min;i<=max;i++) {
			if(check[(int)(i-min)] == false)
				cnt++;
		}
		System.out.println(cnt);	
	}
	static void art() {
		for(long i=2;i*i<=max;i++) {
			// 이 부분이 포인트 
			// min보다 크거나 같은 제곱수를 우선 찾아야됨.
			long j = min;
			j/=(i*i);
			j*=(i*i);
			if(min%(i*i)!=0) {
				j+=(i*i);
			}
			for(;j<=max;j+=i*i) {
				check[(int) (j - min) ] = true;
			}
		}
	}
}
