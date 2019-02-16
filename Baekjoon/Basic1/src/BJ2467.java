// 2467번 
// 용액 
// l, r 인덱스를 사용하여 탐색 

import java.util.Scanner;
public class BJ2467 {
	public static void main (String args[]) {
		// 입출력
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[] L = new int[N];
		
		for(int i=0;i< N;i++) {
			L[i] = stdIn.nextInt();
		}
		getLiquids(L);
	}
	// getLiquids 
	// 용액의 합이 0에 가까운 두 용액을 찾음. 
	static void getLiquids(int[] liq){
		int sum = 2000000000;
		int l1 = 0;
		int l2 = liq.length-1;
		int l = 0;
		int r = liq.length-1;
		
		// l이 r을 역전할때까지 반복 
		while(l<r) {
			int s = liq[l] + liq[r];
			if(sum>Math.abs(s)) { // 합의 절대값이 최소일 경우 
				sum = Math.abs(s);
				// 각 인덱스를 저장 
				l1 = l;
				l2 = r;
			}
			if(s>0) { // 합이 양수일 경우 
				r--; // 더 작아질 필요가 있으므로 
			}else if(s<0) { // 합이 음수일 경우 
				l++; // 더 커질 필요가 있으므로 
			}else { // 합이 0일 경우 
				System.out.printf("%d %d", liq[l], liq[r]);
				break;
			}
		}
		System.out.printf("%d %d", liq[l1], liq[l2]);
	}
}
