import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2151 {
	static char[][] map;
	static int[][] visited;
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new char[n][n];
		visited = new int[n][n];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(n);
	}
	static void solve(int n) {
		Queue<XY> q= new LinkedList<XY>();
		boolean flag = false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == '#') {
					q.add(new XY(i,j,0));
					visited[i][j] = 1;
					flag = true;
					break;
				}
			}
			if(flag == true)break;
		}
		
		
		while(!q.isEmpty()) {
			XY h = q.remove();
			int x = h.x;
			int y = h.y;
			int m = h.m;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				while(nx >=0 && ny >=0 && nx < n && ny < n && map[nx][ny] != '*') {
					
					if(map[nx][ny] == '#' && visited[nx][ny] == 0) {
						System.out.println(m);
						return;
					}
					if(map[nx][ny] == '!' && visited[nx][ny] == 0) {
//						System.out.println(nx + " " + ny + " " + m);
						q.add(new XY(nx,ny,m+1));
						visited[nx][ny] = 1;
					}
					nx += dx[i];
					ny += dy[i];
				}
			}

		}	
	}
}
class XY{
	int x;
	int y;
	int m;
	XY(int x, int y, int m){
		this.x = x;
		this.y = y;
		this.m = m;
	}
}
