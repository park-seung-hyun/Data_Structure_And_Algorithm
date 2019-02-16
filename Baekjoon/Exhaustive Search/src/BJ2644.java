// 2644번 
// 촌수 계산 
// DFS (Depth-First-Search)

// 2573번과 유사 

import java.util.Scanner;

public class BJ2644 {
	static int[][] m; // 관계를 표현한 인접 행렬 
	static boolean[] visited; // 방문 여부 
	static int n; // 전체 사람 수 
	
	static int x; // 촌수를 찾고자하는 대상1 
	static int y; // 촌수를 찾고자하는 대상2
	
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		x = stdIn.nextInt();
		y = stdIn.nextInt();
		
		int n2 = stdIn.nextInt();
		
		for(int i=0;i<n2;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			m[a][b] = 1;
			m[b][a] = 1;
		}
		dfs(x,0);
		System.out.println(-1);
	}
	// dfs
	// Depth-First-Search 
	// 노드에서 노드까지 탐색 
	static void dfs(int x, int c) {
		visited[x] = true; // 현재 노드 방문 처리 
		if(x == y) { // 해당 노드가 도착지일 경우 
			System.out.println(c);
			System.exit(0);
		}
		// 해당 노드와 인접한 모든 노드들에 대해 dfs 
		for(int i=1;i<=n;i++) {
			// 아직 방문하지 않은 인접 노드 
			if(!visited[i] && m[x][i] ==1) { 
				dfs(i, c+1); // 촌수 누적 
			}
		}
	}
}
