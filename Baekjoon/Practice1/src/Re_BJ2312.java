import java.util.Arrays;
// 2312번 (복습)
// 수 복원하기 
// 소인수분해 (Fractional decomposition) 

import java.util.Scanner;
public class Re_BJ2312 {
	static boolean[] check;
	static int[] prime;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int t = stdIn.nextInt();
		art(100000);
		
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			solve(n);
		}
	}
	static void solve(int n) {
		int i = 0;
		int cnt = 0;
		int p = 0;
		
		while(true) {
			
			p = prime[i];
			if(n==1) {
				System.out.printf("%d %d\n", p, cnt);
				break;
			}
			if(n%p == 0) {
				n /= p;
				cnt ++;
				
			}else {
				if(cnt!=0)
					System.out.printf("%d %d\n", p, cnt);
				
				i++;
				cnt = 0;
			}
		
		}
	}
	static void art(int n) {
	
		check = new boolean[n+1];
		prime = new int[n];
		int pp = 0;
		check[0] = true;
		check[1] = true;
		for(int i=2;i<=n;i++) {
			if(check[i] == false) {
				prime[pp++] = i;
				for(int j = i*2;j<=n;j+=i) {
					check[j] = true;
				}
			}
		}
	}
}
