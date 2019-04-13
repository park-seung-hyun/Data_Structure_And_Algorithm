// 2252번 
// 줄 세우기 
// 위상 정렬 (Topological sort) 

// https://gmlwjd9405.github.io/2018/08/27/algorithm-topological-sort.html

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2252 {
	static int N;
	static int[] seq;
	public static void main (String args[]) {
		// 입출력 
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
	// topologicalSort 
	// 위상 정렬 
	static void topologicalSort(int[][] arr) {
		Queue<Integer> q = new LinkedList();
		// 진입 차수가 0인 경우 큐에 넣음. 
		for(int i=1;i<seq.length;i++) {
			if(seq[i] == 0 ) { // 진입 차수가 0인 경우 
				q.add(i);
				seq[i]--; // 다시 큐에 넣는 것을 방지 
			}
		}
		// 큐가 빌때까지 반복 
		while(!q.isEmpty()) {
			int n = q.peek();
			System.out.printf("%d ",n); // 출력 
			q.remove();
			
			// 노드가 제거됨으로써 해당 노드가 진입하던 노드의 진입 차수를 -1 
			for(int i=0;i<arr[0].length;i++) {
				if(arr[0][i] == n) {
					seq[arr[1][i]]--;
				}
			}
			
			// 진입 차수가 0인 경우 큐에 넣음. 
			for(int i=1;i<seq.length;i++) {
				if(seq[i] == 0 ) { // 들어오는 간선 없을 경우 
					q.add(i);
					seq[i]--;
				}
			}
		}
	}
}
