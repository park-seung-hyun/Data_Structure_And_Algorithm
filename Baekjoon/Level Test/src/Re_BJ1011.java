// 1011번 (복습)
// Fly me to the Alpha Centauri  
// 규칙 찾기

import java.util.Scanner;
public class Re_BJ1011 {
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			System.out.println(solve(a,b));
		}
	}
	static int solve(int a, int b) {
		int n = b-a;
		int k = (int) Math.sqrt(n);
		if(!(k*k == n)) {
			k+=1;
		}
		
		if(k*k-n < k) {
			return 2*k-1;
		}else {
			return 2*(k-1);
		}
	}

}