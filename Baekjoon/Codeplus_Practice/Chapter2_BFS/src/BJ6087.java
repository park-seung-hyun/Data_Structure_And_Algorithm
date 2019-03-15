// 6087번 
// 레이저 통신  
// BFS

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ6087 {
	static char[][] map;
	static int[][] visited;
	static int[][] direction;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int h = stdIn.nextInt();
		int w = stdIn.nextInt();
		map = new char[w][h];
		visited = new int[w][h];
		direction = new int[w][h];
		stdIn.nextLine();
		for(int i=0;i<w;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<h;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(w,h);
	}
	static void solve(int w, int h) {
		for(int i=0;i<w;i++) {
			Arrays.fill(visited[i], -1);
		}
		Queue<Pos3> q = new LinkedList<Pos3>();
		boolean flag = false;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(map[i][j] == 'C') {
					q.add(new Pos3(i,j));
					visited[i][j] = 0;
					map[i][j] = '.';
					flag = true;
					break;
				}
			}
			if(flag == true) break;
		}
		while(!q.isEmpty()) {
			Pos3 p = q.remove();
			int x = p.x;
			int y = p.y;
			if(map[x][y] == 'C') {	
				 System.out.println(visited[x][y]-1);	
				 break;
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 벽 닿기 전까지 같은 방향으로 계속 진행 
				while(nx>=0 && ny >=0 && nx<w && ny < h) {

					if(map[nx][ny] == '*') {
						break;
					}
					
					if(visited[nx][ny] == -1) {
						q.add(new Pos3(nx, ny));
						visited[nx][ny] = visited[x][y] + 1;
					}
					
					nx += dx[i];
					ny += dy[i];
				}
			}
		}		
	}
}
class Pos3{
	int x;
	int y;
	Pos3(int x, int y){
		this.x =x;
		this.y =y;
	}
}
