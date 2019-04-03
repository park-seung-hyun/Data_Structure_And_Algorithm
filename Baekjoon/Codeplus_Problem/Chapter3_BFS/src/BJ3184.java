import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ3184 {
	static char[][] map;
	static boolean[][] visited;
	static int wolf = 0;
	static int sheep = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		map = new char[r][c];
		visited = new boolean[r][c];
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(r,c);
		System.out.printf("%d %d", sheep, wolf);
	}
	static void solve(int r, int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(visited[i][j] == false && map[i][j] != '#') {
					bfs(i,j,r,c);
				}
			}
		}
	}
	static void bfs(int i, int j, int r, int c) {
		Queue<Pos> q= new LinkedList<Pos>();
		q.add(new Pos(i,j));
		visited[i][j] = true;
		int v = 0;
		int o = 0;
		while(!q.isEmpty()) {
			Pos h = q.remove();
			int x = h.x;
			int y = h.y;
			if(map[x][y] == 'v') v++;
			if(map[x][y] == 'o') o++;
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx >=0 && ny >=0 && nx <r && ny < c && map[nx][ny] != '#' && visited[nx][ny] == false) {
					q.add(new Pos(nx, ny));
					visited[nx][ny] = true;	
				}
			}
		}
		if(o>v) {
			sheep += o;
		}else {
			wolf += v;
		}

	}
}
class Pos{
	int x;
	int y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}
