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
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		long H = stdIn.nextInt();
		
		long[] numbers = new long[N];
		for(int i=0;i<N;i++) {
			numbers[i] = stdIn.nextInt();
		}
		System.out.print(partialSum(numbers, H));
	}
	static long partialSum(long[] arr, long h) {
		Queue<Long> q = new LinkedList<Long>(); 
		int min = 1000000;
		long sum = 0;
		int i=0;
		q.add(arr[0]);
		sum += arr[0];
		
		while(i<arr.length) {
			if(min >= q.size()) {
				if(sum >= h) {
					min = q.size();
					sum -= q.peek();
					q.remove();
					
				}
				if(sum<h) {
					i++;
					if(i<arr.length) {
						sum +=arr[i];
						q.add(arr[i]);
					}
				}
			}else {
				sum -= q.peek();
				q.remove();
			}
		}
		
		if(min>arr.length) 
			return 0;
		else
			return min; 
		
	}
}
