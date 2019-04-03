import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14442 {
	static int[][] map;
	static int[][][] visited;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n= stdIn.nextInt();
		int m= stdIn.nextInt();
		int k= stdIn.nextInt();
		map = new int[n][m];
		visited = new int[n][m][k+1];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s= stdIn.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		solve(n,m,k);
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<=k;i++) {
			if(ans > visited[n-1][m-1][i] && visited[n-1][m-1][i] != 0) ans = visited[n-1][m-1][i];
		}
		
//		for(int z= 0;z<=k;z++) {
//			System.out.println();
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					System.out.printf("%d ",visited[i][j][z]);
//				}
//				System.out.println();
//			}
//		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	static void solve(int n, int m, int k) {
		visited[0][0][0] = 1;
		Queue<Position> q= new LinkedList<Position>();
		q.add(new Position(0,0,0));
		while(!q.isEmpty()) {
			Position h = q.remove();
			int x = h.x;
			int y = h.y;
			int b = h.b;
			for(int i=0;i<4;i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx < n && ny < m) {
					if(map[nx][ny] == 0) {// 벽 아닌 경우 
						if(visited[nx][ny][b] == 0) { 
							q.add(new Position(nx,ny,b));
							visited[nx][ny][b] = visited[x][y][b] + 1;
						}
					
					}else { // 벽인 경우 
						if(b+1<=k) {
							if(visited[nx][ny][b+1] == 0 ) {
								q.add(new Position(nx,ny,b+1));
								visited[nx][ny][b+1] = visited[x][y][b] + 1;
							}	
						}
					}					
				}
			}
		}
	}
}
class Position{
	int x;
	int y;
	int b;
	Position(int x, int y, int b){
		this.x=x;
		this.y=y;
		this.b=b;
	}
}
