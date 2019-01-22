// 2252번 
// 줄 세우기 
// 위상 정렬 (Topological sort)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2252 {
	static int N;
	static int[] seq;
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextInt();
		int M = stdIn.nextInt();
		int[][] arr = new int[2][M]; 
		seq = new int[N+1];
		
		for(int i=0;i<M;i++) {
			arr[0][i] = stdIn.nextInt();
			arr[1][i] = stdIn.nextInt();
			seq[arr[1][i]]++;
		}
		topologicalSort(arr);
	}
	static void topologicalSort(int[][] arr) {
		Queue<Integer> q = new LinkedList();
		for(int i=1;i<seq.length;i++) {
			if(seq[i] == 0 ) {
				q.add(i);
				seq[i]--;
			}
		}
		while(!q.isEmpty()) {
			int n = q.peek();
			System.out.printf("%d ",n);
			q.remove();
			
			for(int i=0;i<arr[0].length;i++) {
				if(arr[0][i] == n) {
					seq[arr[1][i]]--;
				}
			}
			
			for(int i=1;i<seq.length;i++) {
				if(seq[i] == 0 ) { 
					q.add(i);
					seq[i]--;
				}
			}
		}
	}
}
