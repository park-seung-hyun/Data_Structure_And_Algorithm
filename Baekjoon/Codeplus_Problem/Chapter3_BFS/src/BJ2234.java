import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2234 {
	static Room[][] map;
	static int[][] visited;
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int h = stdIn.nextInt();
		int w = stdIn.nextInt();
		map = new Room[w][h];
		visited = new int[w][h];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				int n = stdIn.nextInt();
				getWall(i,j,n);
			}
		}
		solve(w,h);
	}
	static void solve(int w, int h) {
		int ans = 1;
		int ans2 = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(-1);
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(visited[i][j] == 0) {
					int temp = bfs(i,j,ans,w,h);
					al.add(temp);
					if(ans2 < temp) ans2 = temp;
					ans++;
				}
			}
		}
		System.out.println(ans-1);
		System.out.println(ans2);
		System.out.println(getAns3(w, h, al));
	}
	static int getAns3(int w, int h, ArrayList<Integer> al) {
		int max = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				for(int k=0;k<4;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx>=0 && ny>=0 && nx <w && ny < h) {
						if(visited[nx][ny] != visited[i][j]) {
							if(max < al.get(visited[nx][ny]) + al.get(visited[i][j])) {
								max = al.get(visited[nx][ny]) + al.get(visited[i][j]);
							}
						}
						
					}
				}
			}
		}
		return max;
		
	}
	static void printMap(int w, int h) {
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				System.out.printf("%d ", visited[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void getWall(int i, int j, int num) {
		int w = 0;
		int e = 0;
		int s = 0;
		int n = 0;
		if(num >= 8) {
			num -= 8;
			s = 1;
		}
		if(num >= 4) {
			num -= 4;
			e = 1;
		}
		if(num >= 2) {
			num -=2;
			n = 1;
		}
		if(num >= 1) {
			num -=1;
			w = 1;
		}
//		System.out.printf("%d %d %d %d\n", s,e,n,w);
		map[i][j] = new Room(w,e,n,s);
	}
	static int bfs(int i, int j, int cnt, int w, int h) {
		Queue<P> q = new LinkedList<P>();
		q.add(new P(i,j));
		visited[i][j] = cnt;
		
		int count = 0;
		while(!q.isEmpty()) {
			P cur = q.remove();
			count ++ ;
			int x= cur.x;
			int y = cur.y;
			Room curRoom = map[x][y];
			for(int k = 0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(k == 0 && curRoom.s == 1) {
					continue;
				}
				if(k == 1 && curRoom.n == 1) {
					continue;
				}
				if(k == 2 && curRoom.e == 1) {
					continue;
				}
				if(k == 3 && curRoom.w == 1) {
					continue;
				}
				
				if(nx>=0 && ny >=0 && nx < w && ny < h) {
//					System.out.println(nx +" "+ ny + " "+ k + " "+curRoom.e+curRoom.w+curRoom.n+curRoom.s);
					if(visited[nx][ny] == 0) {
						q.add(new P(nx,ny));
						visited[nx][ny] = cnt;
					}
				}
			}
		}
//		System.out.println(count);
		return count;
	}
}
class P{
	int x;
	int y;
	P(int x, int y){
		this.x = x;
		this.y = y; 
	}
}
class Room{
	int w;
	int e;
	int n;
	int s;
	Room(int w, int e, int n, int s){
		this.w = w;
		this.e = e;
		this.n = n;
		this.s = s;
	}
}
