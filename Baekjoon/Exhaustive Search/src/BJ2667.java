// 2667번 
// 단지 번호 붙히기 
// DFS (Depth-First-Search)

import java.util.ArrayList;
import java.util.Scanner;

public class BJ2667 {
	static int[][] ar;
	static int[][] visited;
	static int t;
	static int count;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		t = stdIn.nextInt();
		
		// 문자열 입력받기 전에 라인 한번 받아주고 받아야됨. 
		stdIn.nextLine();
		
		ar = new int[t][t];
		visited = new int[t][t];
		
		for(int i=0;i<t;i++) {
			String l = stdIn.nextLine();
			for(int j=0;j<t;j++) {
				// 그냥 int형 변환하면 48,49 저장됨.
				// 문자형 '0'을 빼줘야됨. 
				ar[i][j] = (int)(l.charAt(j) - '0');
			}
		}
		
		solve();
		
	}
	// solve 
	// 단지 수와 각 단지내 집의 수를 출력하는 함수 
	static void solve() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		count = 0;
		// 모든 집들이 방문되도록 
		// 모든 점에 대해 dfs 
		for(int i=0;i<t;i++) {
			for(int j=0;j<t;j++) {
				if(visited[i][j] == 0 && ar[i][j]==1) {
					dfs(i, j);
					al.add(count);
					count = 0;
				}
			}
		}
		al.sort(null);
		System.out.println(al.size());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
	}
	// dfs
	// Depth-First-Search 
	// 한개의 dfs로 하나의 단지가 찾아짐. 
	static void dfs(int x,int y) {
		count ++;
		visited[x][y] = 1;
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx>=0 && nx < t && ny >=0 && ny<t) {
				// 방문하지 않았고, 집일 경우 탐색 
				if(visited[nx][ny] == 0 && ar[nx][ny]==1) {
						dfs(nx, ny);
				}
			}
		}
	}
}
