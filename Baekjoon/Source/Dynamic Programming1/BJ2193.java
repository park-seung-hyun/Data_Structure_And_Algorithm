// 2193번  
// 이친수  
// 동적 계획법 (Dynamic Programming) 

// 자료형 -> long 

import java.util.Scanner;
public class BJ2193 {
	static long[][] na;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		na  = new long[n+1][2];
		
		System.out.print(pinaryNumber(n));
	}
	static long pinaryNumber(int n) {
		na[1][1] = 1;
		if(n>=2) {
			for(int i=2 ;i<=n;i++) {
				na[i][0] = na[i-1][0] + na[i-1][1];
				na[i][1] = na[i-1][0];
			}
		}
		long total = na[n][0]+na[n][1];
		return total;
	}
}
