// 1707번 
// 이분 그래프 
// DFS (Depth-First-Search)
// BFS (Breadth-First-Search)

// 시간 초과, 메모리 초과 때문에 어려움 겪은 문제 
// 2차원 배열 -> 메모리 초과 
// ArrayList 배열 -> 시간 초과 (contains()가 시간 초과를 야기하는 듯)
// 결국 ArrayList<ArrayList> 사용 

// https://gmlwjd9405.github.io/2018/08/23/algorithm-bipartite-graph.html

import java.util.ArrayList;
import java.util.Scanner;
public class BJ1707 {
	
	static int[] visited;
	static int v;
	static boolean flag;
	// 시간 초과 피하는 자료구조 
	static ArrayList<ArrayList<Integer>> ar3;

	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();

		for(int i=0;i<t;i++) {

			v = stdIn.nextInt();
			int e = stdIn.nextInt();

			ar3 = new ArrayList<ArrayList<Integer>>();

			for(int k=0;k<=v;k++) {
				ar3.add(new ArrayList<Integer>());
			}
			
			// 인접 그래프 생성 
			for(int j=0;j<e;j++) {
				int a = stdIn.nextInt();
				int b = stdIn.nextInt();
				ar3.get(a).add(b);
				ar3.get(b).add(a);
			}
			
			solve();
			
		}
	}
	// solve 
	// 이분 그래프 여부를 판단하는 함수 
	static void solve(){
		
		visited = new int[v+1];
		flag = true;
		
		// 그래프가 비연결 그래프 일 수 있으므로 모든 노드를 대상으로 dfs 
		for(int i=1;i<=v;i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
			}
			// 이분 그래프가 아닐 경우 
			if(flag == false)
				break;
		}
		System.out.println(flag==true ? "YES":"NO");	
	}
	// dfs
	// Depth-First-Search 
	static void dfs(int n) {
		
		if(flag == false)
			return;
		
		for(int i : ar3.get(n)) {
			// 인접한 노드가 서로 같은 색깔일 경우 -> 이분 그래프가 아님. 
			if(visited[i] == visited[n]) {
				flag = false;
				break;
			}
			
			if(visited[i] == 0) {
				// 색깔을 다르게 할당 
				if(visited[n] == 1)
					visited[i] = 2;
				if(visited[n] == 2)
					visited[i] = 1;
				dfs(i);
			}		
		}	
	}
}

