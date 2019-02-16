// 2573번 
// 빙산
// DFS (Depth-First-Search)

// https://mygumi.tistory.com/192

import java.util.Scanner;

public class BJ2573 {
	static int w;
	static int h;
	static boolean[][] visited;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		w = stdIn.nextInt();
		h = stdIn.nextInt();
		int[][] ice = new int[w][h];
		
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				ice[i][j] = stdIn.nextInt();
			}
		}
		System.out.print(solve(ice));
	}
	// solve 
	// 빙산이 분기되는 년 수를 연산하는 함수 
	static int solve(int[][] ice) {
		int count = 0;
		visited = new boolean[w][h];
		// 빙산이 분기될때까지 반복 
		while(!moreThan2Island(ice)) {
			visited = new boolean[w][h];
			ice = meltIce(ice);
			count++;
			
			// 모두 녹을 경우 
			if(isAllMelt(ice)) {
				return 0;
			}
		}
		return count;
	}
	// isAllMelt 
	// 빙산이 모두 녹았는지 여부 확인 
	static boolean isAllMelt(int[][]ice) {
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(ice[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	// meltIce 
	// 1년이 지난 후 빙산의 상태 
	static int[][] meltIce(int[][] ice) {
		int[][] newIce = new int[w][h];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(!(ice[i][j]==0)) {
					int count = 0;
					if(i>0 && ice[i-1][j]==0)
						count++;
					if(i<w-1 && ice[i+1][j]==0)
						count++;
					if(j>0 && ice[i][j-1]==0)
						count++;
					if(j<h-1 && ice[i][j+1]==0)
						count++;
					
					newIce[i][j] = ice[i][j] - count;
					
					if(newIce[i][j]<0)
						newIce[i][j] = 0;
					
				}
			}
		}
		return newIce;
	}
	// dfs
	// Depth-First-Search
	// 한번의 탐색으로 연결된 모든 칸을 방문 
	static void dfs(int x, int y, int[][] ice) {
		visited[x][y] =true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= ny && ny < h && 0 <= nx && nx < w) {
				if(!visited[nx][ny]&& ice[nx][ny]>0)
					dfs(nx,ny,ice);
			}
		}
	}
	static boolean moreThan2Island(int[][] ice) {
		int count = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if((!visited[i][j]) && ice[i][j]>0) {
					dfs(i,j,ice);
					// 만약 빙산이 한개라면 (모두 연결된 상태라면) 
					// 한번에 모든 칸을 방문 
					count++;
				}
			}
		}
		return count>=2?true:false;
	}
}
