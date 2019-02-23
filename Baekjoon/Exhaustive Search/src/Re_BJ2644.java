// 2644번 (복습)
// 촌수 계산 
// BFS (Breadth-First-Search)
// 최소 경로 (가중치가 모두 1) -> 전형적인 BFS 문제 
// 전에 DFS로 풀긴했는데 문제 의도는 사실 BFS 
// 인접 리스트 사용 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ2644 {
	static ArrayList<Integer>[] ala;
	static int[] visited;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		int t = stdIn.nextInt();
		ala = (ArrayList<Integer>[]) new ArrayList[n+1];
		visited = new int[n+1];
		for(int i=1;i<=n;i++) {
			ala[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<t;i++) {
			int n1 = stdIn.nextInt();
			int n2 = stdIn.nextInt();
			ala[n1].add(n2);
			ala[n2].add(n1);
		}
		solve(a,b);
	}
	static void solve(int a, int b) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(a);
		visited[a] = 1;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == b) {
				System.out.println(visited[b] - 1);
				return;
			}
			for(int i : ala[h]) {
				if(visited[i] == 0) {
					q.add(i);
					visited[i] = visited[h] + 1;
				}
			}
		}
		System.out.println(-1);
	}
}
