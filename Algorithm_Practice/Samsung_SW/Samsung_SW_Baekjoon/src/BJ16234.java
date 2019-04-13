// 삼성 기출 
// 16234번
// 인구 이동 
// 한번에 bfs 돌리면 되는데 왜 나는 인접행렬을 만들고 bfs를 돌렸을까..
// 둘 작업은 중복이므로 bfs 내에서 처리 가능. 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ16234 {
	static int l;
	static int r;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][] visited;
	static int[][] numberMap;
	public static void main(String[] args) {
		
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		l = stdIn.nextInt();
		r = stdIn.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		int cnt = 0;
		while(true) {
			visited = new int[n][n];
			boolean flag = true;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i][j] == 0) {
						if(bfs(i,j,n)) {
							flag = false;
						}
					}
				}
			}
			if(flag == true) break;
			cnt++;
		}
		System.out.println(cnt);
	}
	static boolean bfs(int x, int y, int n) {
		ArrayList<Pos> al = new ArrayList<Pos>();
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(x,y));
		visited[x][y] = 1;
		int sum = 0;
		while(!q.isEmpty()) {
			Pos h = q.remove();
			x = h.x;
			y = h.y;
			sum += map[x][y];
			al.add(h);
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(Math.abs(map[x][y] - map[nx][ny]) > r) continue;
				if(Math.abs(map[x][y] - map[nx][ny]) < l) continue;
				if(visited[nx][ny] == 0) {
					q.add(new Pos(nx,ny));
					visited[nx][ny] = 1;
				}
			}
		}
		if(al.size() == 1) return false;
		sum /= al.size();
		for(Pos p : al) {
			x = p.x;
			y = p.y;
			map[x][y] = sum; 
		}
		return true;
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