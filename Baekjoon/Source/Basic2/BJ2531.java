// 2531번 
// 부분합 
// Sliding Window 
// 다른 예시처럼 풀어보기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2531 {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int d = stdIn.nextInt();
		int k = stdIn.nextInt();
		int c = stdIn.nextInt();
		int[] dishes = new int[N+k-1];
		for(int i=0;i<N;i++) {
			dishes[i] = stdIn.nextInt();
		}
		for(int i=0;i<k-1;i++) {
			dishes[N+i] = dishes[i];
		}
		System.out.print(kindSushi(dishes, k, c));
	}
	static int kindSushi(int[] ar,int k, int c) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(ar[0]);
		int i=0;
		int count=1;
		int max = 0;
		
		while(i<ar.length) {
			if(q.size() == k) {
				if(q.contains(c)) {
					if(max<=count)	
						max = count;
				}else {
					if(max<=count+1)
						max = count+1;
				}
				
				int p = q.peek();
				q.remove();
				
				if(!q.contains(p)) 
					count--;
			}
			else {
				if(i == ar.length-1)
					break;
				
				i++;
				if(!q.contains(ar[i]))
					count++;
				
				q.add(ar[i]);
			}
			
		}
		
		return max;
	}
}
