import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ16137 {
	static int[][] map;
	static int[][][] visited;
	static final int[] dx = {0,0,-1,1}; 
	static final int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new int[n][n];
		visited = new int[n][n][2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve(n,m);
	}
	static void solve(int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
			
		ArrayList<Integer> imp = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+ dy[k];
					if(nx>=0 && ny>=0 && nx <n && ny <n) {
						if(map[i][j] == 0 && (map[nx][ny] == 0 || map[nx][ny]>1)) {
							if(k<=1) {
								cnt1++;
							}else{
								cnt2++;
							}
						}
					}
				}
				if(cnt1>0 && cnt2>0) imp.add(i*n+j);
			}
		}
//		System.out.println(imp);
		
	
		Queue<G> q= new LinkedList<G>();
		q.add(new G(0,0,0,1));
		visited[0][0][1] = 0;
		while(!q.isEmpty()) {
			G h = q.remove();
			int x = h.x;
			int y = h.y;
			int t = h.t;
			int sp = h.sp;
//			System.out.println(x + " " + y + " " + t);
			for(int i=0;i<4;i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny>=0 && nx <n && ny< n) {
					
					if(map[nx][ny] == 1) { // 땅 
						if(visited[nx][ny][sp] == -1 || visited[nx][ny][sp] > t+1) {
							q.add(new G(nx,ny,t+1,sp));
							visited[nx][ny][sp] = t+1;
						}
					}
					if(map[x][y] ==1 && map[nx][ny] > 1){ // 추가 오작교
					
						int temp = 0;
						if((t+1) % map[nx][ny] != 0) {
							
							temp = map[nx][ny] - (t+1) % map[nx][ny];
						}

						if(visited[nx][ny][sp] == -1 || visited[nx][ny][sp] > t+1+temp) {
							q.add(new G(nx,ny,t+1+temp,sp));
							visited[nx][ny][sp] = t+1+temp;
						}
					}
					if(map[x][y] ==1 && map[nx][ny] == 0 && sp == 1 && !imp.contains(nx*n+ny)){ // 절벽 
						
						int temp = 0;
						if((t+1) % m != 0) {
							
							temp = m - (t+1) % m;
						}
		
						if(visited[nx][ny][sp-1] == -1 || visited[nx][ny][sp-1] > t+1+temp) { 
							q.add(new G(nx,ny,t+1+temp,sp-1));
							visited[nx][ny][sp-1] = t +1+ temp;
						}
			
					}
				}
			}
			
		}
		if(visited[n-1][n-1][0] == -1) {
			System.out.println(visited[n-1][n-1][1]);
		}
		else if(visited[n-1][n-1][1] == -1) {
			System.out.println(visited[n-1][n-1][0]);
		}else {
			System.out.println(visited[n-1][n-1][1] > visited[n-1][n-1][0] ? visited[n-1][n-1][0]:visited[n-1][n-1][1]);
		}
		
	}
}
class G{
	int x;
	int y;
	int t;
	int sp;
	G(int x, int y, int t, int sp){
		this.x = x;
		this.y = y;
		this.t= t;
		this.sp = sp;
	}
}
