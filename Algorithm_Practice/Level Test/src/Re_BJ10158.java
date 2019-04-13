// 10158번 (복습)
// 개미 

import java.util.Scanner;
public class Re_BJ10158 {
	public static void main(String[] args) {
		Scanner stdIn= new Scanner (System.in);
		int w = stdIn.nextInt();
		int h = stdIn.nextInt();
		int p = stdIn.nextInt();
		int q = stdIn.nextInt();
		int t = stdIn.nextInt();
		solve(w,h,p,q,t);
	}
	static void solve(int w, int h, int p, int q, int t) {
		int x = 1;
		int y = 1;

		while(t>0) {
			
			if(p==w || p==0)
				x *= -1;
				
			if(q==0 || q ==h)
				y*= -1;
				
			p += x;
			q += y;
			t--;
		}
		System.out.printf("%d %d",p,q);
	}
}
