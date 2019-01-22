// 2467번 
// 용액 
// l, r 인덱스를 사용하여 탐색 

import java.util.Scanner;
public class BJ2467 {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[] L = new int[N];
		
		for(int i=0;i< N;i++) {
			L[i] = stdIn.nextInt();
		}
		getLiquids(L);
	}
	static void getLiquids(int[] liq){
		int sum = 2000000000;
		int l1 = 0;
		int l2 = liq.length-1;
		int l = 0;
		int r = liq.length-1;

		while(l<r) {
			int s = liq[l] + liq[r];
			if(sum>Math.abs(s)) {
				sum = Math.abs(s);
				l1 = l;
				l2 = r;
			}
			if(s>0) {
				r--;
			}else if(s<0) {
				l++;
			}else { 
				System.out.printf("%d %d", liq[l], liq[r]);
				break;
			}
		}
		System.out.printf("%d %d", liq[l1], liq[l2]);
	}
}
