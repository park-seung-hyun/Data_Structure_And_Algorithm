// 위상 정렬  
// 백준 1766번 

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class TopologicalSorting2 {
	static ArrayList<Integer>[] adj;
	static int[] count;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		count = new int[n];
		for(int i=0;i<n;i++) adj[i] = new ArrayList<Integer>();
		for(int i=0;i<m;i++) {
			int a = stdIn.nextInt()-1;
			int b = stdIn.nextInt()-1;
			adj[a].add(b);
			count[b]++; // In-degree 
		}
		topologicalSort(n);
	}
	static void topologicalSort(int n) {
		// 우선순위 큐 사용 
		// 정해준 순서 외에 오름차순 정렬 
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++) 
			if(count[i] == 0) {
				q.add(i);
				count[i] = -1;
			}
		int[] temp = new int[n];
		int id = 0;
		while(!q.isEmpty()) {
			int h = q.remove();
			temp[id++] = h+1;
			for(int d : adj[h])  // 관련 간선들 모두 제거 
				count[d]--;
			for(int i=0;i<n;i++) 
				if(count[i] == 0) { // In-degree가 0인 모든 정점을 큐에 담음.. 
					q.add(i);
					count[i] = -1;
				}
		}
		for(int i=0;i<n;i++) 
			System.out.printf("%d ",temp[i]);
		
	}
}
