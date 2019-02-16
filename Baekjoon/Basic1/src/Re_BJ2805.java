// 2805번 (복습)
// 나무 자르기
// 이분 탐색 (Binary Search) 사용
// 기본 이분 탐색 응용 

import java.util.Scanner;
public class Re_BJ2805 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		long n = stdIn.nextInt();
		long m = stdIn.nextInt();
		long[] t = new long[(int)n];
		for(int i=0;i<n;i++) {
			t[i] = stdIn.nextInt();
		}
		solve(t, n, m);
	}
	static void solve(long[] tree, long n, long m) {
		long i = 0;
		long j = 1000000000;
		long mid=(i+j)/2;
		
		// 이 문제는 정확한 m을 구하기 위한 H를 구하는 것이 아님.  
		// 짤라서 얻은 나무가 m보다 클 경우를 찾음. 
		long result = 0;
		
		while(i<=j) {
			mid = (i+j)/2;
			long sum = cutTree(tree, n, mid);
			if(sum > m) { // 조건 충족 
				if(result < mid) // 조건을 충족할 때 최대 높이를 구한다. (중요한 조건)
					result = mid;
				i = mid+1;
			}else if(sum < m) { // 조건 불충족 
				j = mid-1;
			}else { // 정확히 m일 경우 mid가 정답 
				result = mid;
				break;
			}
		}	
		System.out.println(result);
	}
	static long cutTree(long[] tree, long n, long h) {
		long sum = 0;
		for(int i=0;i<n;i++) {
			if(tree[i]>h)
				sum += tree[i]-h;
		}
		return sum;
	}
}
