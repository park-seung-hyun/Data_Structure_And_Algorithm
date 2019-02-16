// 10158번  
// 개미 

import java.util.Scanner;
public class BJ10158 {
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int w = stdIn.nextInt();
		int h = stdIn.nextInt();
		int p = stdIn.nextInt();
		int q = stdIn.nextInt();
		int t = stdIn.nextInt();
		lastPosition(w,h,p,q,t);
	}
	// lastPosition 
	// 마지막 위치 출력하는 함수 
	static void lastPosition(int w, int h, int p, int q, int t) {
		int mx = 1;
		int my = 1;
		int tx = p;
		int ty = q;
		
		// 시간이 0이 될때까지 반복 
		while(t != 0) {
			
//			if((tx == 0||tx == w)&&(ty == 0||ty == h)) { // 꼭지점 -> 굳이 할 필요가 없음. 아래 if 문에서 걸러짐. 
//				mx = -mx;
//				my = -my;
//			}else if(tx == 0 || tx == w) { // 세로축 
//				mx = -mx;
//			}else if(ty == 0 || ty == h) { // 가로축 
//				my = -my;
//			}
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
