// Hanoi  
// pg180 
// 하노이 타워  
// 어려움.. 

import java.util.Scanner;

public class Hanoi {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("원반 수: ");
		int n = stdIn.nextInt();
		move(n,1,3);
	}
	static void move(int n0, int x, int y) {
		if(n0>1)
			move(n0-1, x, 6 - x - y);
		
		System.out.printf("원반[%d]을 %d에서 %d 기둥으로 옮김.\n", n0, x,y);
		
		if(n0>1)
			move(n0-1, 6-x-y, y);
	}
}
