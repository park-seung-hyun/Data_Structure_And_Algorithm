// 10158번  
// 개미 

import java.util.Scanner;
public class BJ10158 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int w = stdIn.nextInt();
		int h = stdIn.nextInt();
		int p = stdIn.nextInt();
		int q = stdIn.nextInt();
		int t = stdIn.nextInt();
		lastPosition(w,h,p,q,t);
	}
 
	static void lastPosition(int w, int h, int p, int q, int t) {
		int mx = 1;
		int my = 1;
		int tx = p;
		int ty = q;
		
		while(t != 0) {
			
			if(tx == 0 || tx == w)
				mx = -mx;
			if(ty == 0 || ty == h)
				my = -my;
			
			tx += mx;
			ty += my;
			
			t--;
		}
		System.out.printf("%d %d", tx,ty);
	}
}
