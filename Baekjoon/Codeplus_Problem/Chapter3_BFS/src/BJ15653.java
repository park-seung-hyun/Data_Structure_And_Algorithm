import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ15653 {
	static char[][] map;
	static int[][] visited;

	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int w = stdIn.nextInt();
		int h = stdIn.nextInt();
		map = new char[w][h];
		visited = new int[w*h][w*h];
		stdIn.nextLine();
		for(int i=0;i<w;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<h;j++) {
				map[i][j]  = s.charAt(j);
			}
		}
		solve(w, h);
	}
	static void solve(int w, int h) {
		Queue<Ball> q = new LinkedList<Ball>();
		int x = 0;
		int y = 0;
		int x2 = 0;
		int y2 = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(map[i][j] == 'R') {
					x = i;
					y = j;
				}
				if(map[i][j] == 'B') {
					x2 = i;
					y2 = j;
				}
			}
		}
		q.add(new Ball(x,y,x2,y2));
		visited[x*h+y][x2*h+y2] = 1;
		
		while(!q.isEmpty()) {
			
			Ball b1 = q.remove();
			
			// R
			x = b1.x;
			y = b1.y;
			// B
			x2 = b1.x2;
			y2 = b1.y2;
			
			if(map[x][y] == 'O' && map[x2][y2] != 'O') {
				System.out.println(visited[x*h+y][x2*h+y2] - 1);
				return;
			}
			
			// 파란공이 빠지면 해당 경우는 무시 (다음 경우 없음.)
			if(map[x2][y2] == 'O') continue;
			
			for(int i=0;i<4;i++) {
				// 일단 끝까지 보내?
				// R
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				while(nx > 0 && ny > 0 && nx < w-1 && ny < h-1 && map[nx][ny] != '#') {
					if(map[nx][ny] == 'O') { 
						nx += dx[i];
						ny += dy[i];
						break;
					}
					nx += dx[i];
					ny += dy[i];
				}
				nx -= dx[i];
				ny -= dy[i];
				
				// B
				int nx2 = x2 + dx[i];
				int ny2 = y2 + dy[i];
				
				while(nx2 > 0 && ny2 > 0 && nx2 < w-1 && ny2 < h-1 && map[nx2][ny2] != '#') {
					if(map[nx2][ny2] == 'O') { 
						nx2 += dx[i];
						ny2 += dy[i];
						break;
					}
					nx2 += dx[i];
					ny2 += dy[i];
				}
				nx2 -= dx[i];
				ny2 -= dy[i];
				
				
				// 둘이 겹칠 경우 
				if(nx == nx2 && ny == ny2 && map[nx][ny] != 'O') {

					if(i == 0) {
						// 우
						if(x < x2) {
							nx -=dx[i];
							ny -=dy[i];
						}else {
							nx2 -=dx[i];
							ny2 -=dy[i];
						}
					}
					if(i==1) {
						//좌
						if(x < x2) {
							nx2 -=dx[i];
							ny2 -=dy[i];
						}else {
							nx -=dx[i];
							ny -=dy[i];
						}
					}
					if(i==2) {
						//상
						if(y < y2) {
							nx -=dx[i];
							ny -=dy[i];
						}else {
							nx2 -=dx[i];
							ny2 -=dy[i];
						}
					}
					if(i==3) { //
						if(y < y2) {
							nx2 -=dx[i];
							ny2 -=dy[i];
						}else {
							nx -=dx[i];
							ny -=dy[i];
						}
					}
				}
				
				if(visited[nx*h+ny][nx2*h+ny2] == 0) {
					q.add(new Ball(nx, ny, nx2,ny2));
					visited[nx*h+ny][nx2*h+ny2]  = visited[x*h+y][x2*h+y2] + 1;	
				}
			}
			
		}
		System.out.println(-1);
	}
}
class Ball{
	int x;
	int y;
	int x2;
	int y2;
	Ball(int x, int y, int x2, int y2){
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
}
