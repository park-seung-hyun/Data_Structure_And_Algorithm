// 2805번
// 나무 자르기
// 이분 탐색 (Binary Search) 사용

// http://wootool.tistory.com/62
// http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220777333252&parentCategoryNo=&categoryNo=299&viewDate=&isShowPopularPosts=true&from=search

import java.util.Scanner;
public class BJ2805 {
	static long N;
	static long M;
	public static void main (String args[]) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextLong(); // 나무 개수 
		M = stdIn.nextLong(); // 필요한 나무 길이 
		
		long[] T = new long[(int)N];
		for(int i=0;i<T.length;i++) {
			T[i] = stdIn.nextLong();
		}
		
		getHeight(T);
		
	}
	// getHeight 
	// 높이(H) 계산 
	// 이분 탐색 (Binary Search) 사용 
	static void getHeight(long[] t) {
		
		long l = 0; // 조건을 만족하는 값 
		long h = 1000000000; // 조건을 불만족하는 값 
		
		// 조건을 만족하는 값 중 최대값 계산 
		while(l+1<h) {
			long sum = 0;
			long mid = (l+h)/2;
			for(int i=0;i<N;i++) {
				if(t[i]>=mid)
					sum += t[i] - mid;
			}
			
			if(sum>=M) { // 나무 충분(조건 만족) 
				l = mid;
			}else { // 나무 불충분 (조건 불만족) 
				h = mid;
			}
		}
		// l+1 >= h 일때 l은 조건을 만족하는 최대값 
		// l=15, h=16 일때
		// l은 조건을 만족하는 최대값
		// h는 조건을 불만족하는 최소값 
		System.out.print(l);
	}
}
