import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ10026 {
	static char[][] map;
	static boolean[][] visited;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner stdIn =new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new char[n][n];
		visited = new boolean[n][n];
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
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j] == false) {
					bfs(i,j,false,n);
					cnt++;
				}
			}
		}
		int cnt2 = 0;
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j] == false) {
					bfs(i,j,true, n);
					cnt2++;
				}
			}
		}
		System.out.printf("%d %d", cnt, cnt2);

	}
	static void bfs(int i, int j, boolean isIll, int n) {
		
		char color = map[i][j];
		Queue<Person> q= new LinkedList<Person>();
		q.add(new Person(i,j));
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			Person h = q.remove();
			int x = h.x;
			int y = h.y;
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && ny>=0 && nx < n && ny < n) {
					if(isIll) {
						if(color == 'R' || color == 'G') {
							if(visited[nx][ny] == false && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
								q.add(new Person(nx,ny));
								visited[nx][ny] = true;
							}
						}else {
							if(visited[nx][ny] == false && map[nx][ny] == color) {
								q.add(new Person(nx,ny));
								visited[nx][ny] = true;
							}
						}
						
					}else {
						if(visited[nx][ny] == false && map[nx][ny] == color) {
							q.add(new Person(nx,ny));
							visited[nx][ny] = true;
						}	
					}
				}
			} 
		}
		
		
		
	}
}
class Person{
	int x;
	int y;
	Person(int x, int y){
		this.x = x;
		this.y = y;
	}
}
