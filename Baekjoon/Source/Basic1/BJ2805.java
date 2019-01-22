// 2805번
// 나무 자르기
// 이분 탐색 (Binary Search) 사용

import java.util.Scanner;
public class BJ2805 {
	static long N;
	static long M;
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextLong();
		M = stdIn.nextLong();
		
		long[] T = new long[(int)N];
		for(int i=0;i<T.length;i++) {
			T[i] = stdIn.nextLong();
		}
		getHeight(T);
	}
	static void getHeight(long[] t) {
		
		long l = 0;
		long h = 1000000000;
		
		while(l+1<h) {
			long sum = 0;
			long mid = (l+h)/2;
			for(int i=0;i<N;i++) {
				if(t[i]>=mid)
					sum += t[i] - mid;
			}
			
			if(sum>=M) {
				l = mid;
			}else {
				h = mid;
			}
		}
		System.out.print(l);
	}
}
