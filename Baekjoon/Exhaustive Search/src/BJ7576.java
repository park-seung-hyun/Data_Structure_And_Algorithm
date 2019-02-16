// 7576번 
// 토마토 
// BFS (Breadth-First-Search)

// DFS -> 시간초과
// BFS -> 2573번 응용 -> 시간초과 

// https://lmcoa15.tistory.com/22

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7576 {
	static int m;
	static int n;
	static int[][] ts ;
	static int[][] visited2;
	
	static boolean[][] visited; // solve() 용 
	
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		ts = new int[m][n];
		
		for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++) 
				ts[i][j] = stdIn.nextInt();
		
		System.out.println(solve());
	}
	// solve
	// BFS
	// Breadth-First-Search
	// 처음에는 큐에 하나만 넣을 생각만 했다.
	// 시작부터 모든 익은 토마토를 넣어서 차례차례 주변으로 익지 않은 토마토들이 익도록 나아가게 해야한다.
	// 퍼지는 시간을 visited 배열에 저장하여 가장 큰 값을 출력 
	static int solve() {
		Queue<Integer> q = new LinkedList<Integer>();
		visited2 = new int[m][n];
		
		// 큐에 현재 모든 익은 토마토(1)을 넣음. 
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(ts[i][j]==1) {
					q.add(i*n+j);
					visited2[i][j] = 0;
				}
			}	
		}
		// 모두 익은 토마토일 경우 
		if(q.size() == m*n) {
			return 0;
		}
		
		int ans = 0;
		// BFS를 통해 탐색하면서 0인 사과를 모두 1로 바꿔감. 
		while(!q.isEmpty()) {
			
			int qp = q.remove();
			int x = qp/n;
			int y = qp%n;

			if(ans<visited2[x][y])
				ans = visited2[x][y];
			
			int[] dx = {-1,0,1,0};
			int[] dy = {0,-1,0,1};
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 현재 큐에서 뽑아낸 토마토 주변 4개의 토마토에 대해 큐에 삽입 
				if(nx>=0 && nx<m && ny>=0 && ny<n) {
					if(visited2[nx][ny] != 0 || ts[nx][ny] != 0)
						continue;
					// 밖에 이중 반복문을 제거할 수 있는 이유
					// 레벨 별로 값을 저장해놓았으므로 소스처럼 이중 반복문일 필요 없음. 
					visited2[nx][ny] = visited2[x][y] + 1;
					ts[nx][ny] = 1;
					q.add(nx*n+ny);
				}
			}
			
		}
		// 아직 익지 않은 토마토가 있는 경우 
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(ts[i][j] == 0) {
					ans = -1;
					break;
				}
					
			}
		}
		
		return ans;
		
	}
//	static void solve2() {
//		int year = 0;
//		while(!isRipped()) {
//			
//			rip();
//			year++;
//			if(year>10000) {
//				year = -1;
//				break;
//			}
//		}
//		System.out.println(year);
//	}
//	static void rip() {
//		int[][] t_ts = new int[m][n];
//		
//		for(int k=0;k<m;k++) {
//			for(int l = 0;l<n;l++) {
//				t_ts[k][l] = ts[k][l];
//			}
//		}
//		int c2 = 0;
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				if(ts[i][j] == 1) {
//					c2++;
//					if(i+1<m && ts[i+1][j]==0)
//						t_ts[i+1][j] = 1;
//					if(i-1>=0 && ts[i-1][j]==0)
//						t_ts[i-1][j] = 1;
//					if(j+1<n && ts[i][j+1]==0)
//						t_ts[i][j+1] = 1;
//					if(j-1>=0 && ts[i][j-1]==0)
//						t_ts[i][j-1] = 1;		
//				}
//			}
//		}
//
//		ts = t_ts.clone();
//	}
//	static boolean isRipped() {
//		visited = new boolean[m][n];
//
//		boolean flag = true;
//		Queue<Integer> q = new LinkedList<Integer>();
//		
//		q.add(0);
//		visited[0][0] = true;
//		
//		while(!q.isEmpty()) {
//			
//			int x = q.peek()/n;
//			int y = q.peek()%n;
//			q.remove();
//			
//			if(ts[x][y] == 0) {
//				flag = false;
//				break;
//			}
//			
//			int[] dx = {-1,0,1,0};
//			int[] dy = {0,-1,0,1};
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx>=0 && nx<m && ny>=0 && ny<n) {
//					if(!visited[nx][ny]) {
//						q.add(nx*n+ny);
//						visited[nx][ny] = true;
//					}
//				}
//			}
//		}
//		return flag;
//	}
}
