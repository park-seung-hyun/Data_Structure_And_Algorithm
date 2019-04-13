import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ13460 {
	static char[][] map;
	static int[][] visited;
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		map = new char[r][c];
		visited = new int[r*c-1][r*c-1];
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(r,c);
	}
	static void solve(int r, int c) {
		int rx = 0;
		int ry = 0;
		int bx = 0;
		int by = 0;
		int hx = 0;
		int hy = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'O') {
					hx = i;
					hy = j;
					map[i][j] = '.';
				}
			}
		}
		for(int i=0;i<r*c-1;i++) Arrays.fill(visited[i], -1);
		Queue<Ball> q= new LinkedList<Ball>();
		q.add(new Ball(rx,ry,bx,by));
		visited[rx*c + ry][bx*c + by] = 0;
		while(!q.isEmpty()) {
			Ball h = q.remove();
			rx = h.rx;
			ry = h.ry;
			bx = h.bx;
			by = h.by;
			int cnt = visited[rx*c + ry][bx*c + by];
			if(cnt > 10) {
				System.out.println(-1);
				return;
			}
			if(bx == hx && by == hy) continue;
			if(rx == hx && ry == hy) {
				System.out.println(cnt);
				return;
			}	
			for(int i=0;i<4;i++) {
				// Simulate 
				// 빨간 공 끝까지 보내 
				int nrx = rx + dx[i];
				int nry = ry + dy[i];
				while(nrx>=0 && nry>=0 && nrx < r && nry<c && map[nrx][nry] != '#') {
					if(nrx == hx && nry == hy) { // 구멍 
						nrx+=dx[i];
						nry+=dy[i];
						break;
					}
					nrx+=dx[i];
					nry+=dy[i];
				}
				nrx -= dx[i];
				nry -= dy[i];
				
				// 파란 공 끝까지 보내 
				int nbx = bx + dx[i];
				int nby = by + dy[i];
				while(nbx>=0 && nby>=0 && nbx < r && nby<c && map[nbx][nby] != '#') {
					if(nbx == hx && nby == hy) { // 구멍 
						nbx+=dx[i];
						nby+=dy[i];
						break;
					}
					nbx+=dx[i];
					nby+=dy[i];
				}
				nbx -= dx[i];
				nby -= dy[i];
				
				// 같은 위치일 경우 (구멍에는 안빠짐)
				// 위치 조정 
				if(nrx == nbx && nry == nby && (nrx != hx || nry != hy)) {
					if(i == 0) { // 북 
						if(rx > bx) { // 빨강 공이 더 아래 
							nrx -= dx[i];
							nry -= dy[i];
						}else {
							nbx -= dx[i];
							nby -= dy[i];
						}
					}else if(i == 1) { // 동 
						if(ry > by) { // 파란 공이 더 왼쪽 
							nbx -= dx[i];
							nby -= dy[i];
						}else {
							nrx -= dx[i];
							nry -= dy[i];
						}
					}else if(i==2) { // 남 
						if(rx > bx) { // 파란 공이 더 위에  
							nbx -= dx[i];
							nby -= dy[i];
						}else {
							nrx -= dx[i];
							nry -= dy[i];
						}
					}else { // 서 
						if(ry > by) { // 빨강 공이 더 오른쪽 
							nrx -= dx[i];
							nry -= dy[i];
						}else {
							nbx -= dx[i];
							nby -= dy[i];
						}
					}
				}
				
				// 방문 
				if(visited[nrx * c + nry][nbx * c + nby] == -1) {
					visited[nrx * c + nry][nbx * c + nby] = cnt + 1;
					q.add(new Ball(nrx, nry, nbx, nby));
				}
				
			}
		}
		System.out.println(-1);
	}
}
class Ball{
	int rx;
	int ry;
	int bx;
	int by;
	Ball(int rx, int ry, int bx, int by){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
	}
}
