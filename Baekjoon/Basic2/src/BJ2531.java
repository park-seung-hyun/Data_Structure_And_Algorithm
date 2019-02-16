// 2531번 
// 부분합 
// Sliding Window 
// 다른 예시처럼 풀어보기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2531 {
	public static void main (String args[]) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt(); // 접시 수 
		int d = stdIn.nextInt(); // 초밥의 가짓수 
		int k = stdIn.nextInt(); // 연속해서 먹는 접시의 수 
		int c = stdIn.nextInt(); // 쿠폰 번호 
		int[] dishes = new int[N+k-1];
		for(int i=0;i<N;i++) {
			dishes[i] = stdIn.nextInt();
		}
		for(int i=0;i<k-1;i++) {
			dishes[N+i] = dishes[i];
		}
		System.out.print(kindSushi(dishes, k, c));
	}
	// kindSushi
	// 최대 초밥 종류 개수를 출력하는 함수 
	static int kindSushi(int[] ar,int k, int c) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(ar[0]);
		int i=0;
		int count=1; // 현재 큐에 있는 초밥 종류 
		int max = 0;
		
		while(i<ar.length) {
			// 현재 큐에 있는 초밥 개수와 k의 비교 
			if(q.size() == k) {
				// 쿠폰 초밥을 가지고 있는지 여부 확인 
				if(q.contains(c)) { // 쿠폰 초밥이 있을 경우 
					if(max<=count)	
						max = count;
				}else {
					if(max<=count+1)	 // 쿠폰 초밥이 없을 경우 
						max = count+1;
				}
				
				int p = q.peek();
				q.remove();
				
				// 큐에서 초밥을 제거한 후 해당 초밥 종류가 아직 큐에 남아있는지 확인 
				if(!q.contains(p)) 
					count--;
			}
			else {
				if(i == ar.length-1) // 마지막 인덱스 해결 
					break;
				
				i++;
				// 큐에 넣을려고 하는 초밥 종류가 있는지 확인 
				if(!q.contains(ar[i]))
					count++;
				
				q.add(ar[i]);
			}
			
		}
		
		return max;
	}
}
