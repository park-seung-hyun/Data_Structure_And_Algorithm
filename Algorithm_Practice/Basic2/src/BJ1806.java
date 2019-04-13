// 1806번 
// 부분합 
// Sliding Window 
// 연속된 구간의 합을 구하므로 O(N)로 해결 가능 
// 다른 예시처럼 풀어보기 (Left & Right) 

// http://seonkyu.tistory.com/6 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1806 {
	public static void main(String args[]) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		long H = stdIn.nextInt();
		
		long[] numbers = new long[N];
		for(int i=0;i<N;i++) {
			numbers[i] = stdIn.nextInt();
		}
		System.out.print(partialSum(numbers, H));
	}
	// partialSum 
	// 부분합 중 H 이상을 구하는 함수 
	static long partialSum(long[] arr, long h) {
		// 큐 사용 (큐 내부에는 수열의 부분이 들어감.)
		Queue<Long> q = new LinkedList<Long>(); 
		int min = 1000000; // 조건을 만족하는 최소 길이 
		long sum = 0; // 큐 내부 부분 수열의 합 
		int i=0;
		q.add(arr[0]);
		sum += arr[0];
		
		while(i<arr.length) {
			if(min >= q.size()) { // 큐의 길이가 현재 최소 길이보다 작을 경우 
				if(sum >= h) { // 조건 만족 
					min = q.size();
					sum -= q.peek();
					q.remove();
					
				}
				if(sum<h) { // 조건 불만족 (부분합이 조건보다 작을 경우)
					i++;
					if(i<arr.length) {
						sum +=arr[i];
						q.add(arr[i]);
					}
				}
			}else { // 큐의 길이가 현재 최소 길이보다 클 경우 
				sum -= q.peek();
				q.remove();
			}
		}
		
		if(min>arr.length) // 최소 길이가 배열보다 길 경우 (불가능할 경우)
			return 0;
		else
			return min; 
		
	}
}
