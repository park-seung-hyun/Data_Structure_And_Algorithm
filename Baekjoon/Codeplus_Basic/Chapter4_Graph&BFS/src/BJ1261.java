// 1261번 
// 알고스팟
// 최소 비용 문제의 조건 -> 모든 가중치가 1
// 위 조건을 위배함. (순간이동의 가중치가 0)
// 이는 큐 2개 또는 덱 1개를 통해 해결 가능 
// 가중치가 0일 경우 덱의 맨 앞에 (현재 대상과 같은 레벨 위치) 추가하고,
// 가중치가 1일 경우 뒤에 추가한다. 

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1261 {
	static int[][] room ;
	static int[][] visited;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int m = stdIn.nextInt();
		int n = stdIn.nextInt();
		room = new int[n][m];
		visited = new int[n][m];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<m;j++) {
				room[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i], -1);
		}
		bfs2(n, m);
		System.out.println(visited[n-1][m-1]);
	}
	static void bfs(int n, int m) {
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(0);
		visited[0][0] = 0;
		
		while(!dq.isEmpty()) {
			
			int h = dq.removeFirst();
			int x = h/m;
			int y = h%m;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0&& ny>=0 && nx<n && ny<m) {
					if(visited[nx][ny] == -1) {
						if(room[nx][ny] == 0) {
							dq.addFirst(nx*m+ny);
							visited[nx][ny] = visited[x][y];
						}else {
							dq.addLast(nx*m+ny);
							room[nx][ny] = 0;
							visited[nx][ny] = visited[x][y] + 1;
						}
					}
				}
			}
		}
	}
	static void bfs2(int n, int m) {
		Queue<Integer> cq = new LinkedList<Integer>();
		Queue<Integer> nq = new LinkedList<Integer>();
		cq.add(0);
		visited[0][0] = 0;
		while(!cq.isEmpty()) {
			int h = cq.remove();
			int x = h/m;
			int y = h%m;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(visited[nx][ny] == -1) {
						
						if(room[nx][ny] == 1) {
							nq.add(nx*m +ny);
							visited[nx][ny] = visited[x][y] +1;
//							room[nx][ny] = 0;
						}else {
							cq.add(nx*m +ny);
							visited[nx][ny] = visited[x][y];
						}
						
					}
				}
			}
			
			if(cq.isEmpty()) {
				cq = nq;
				nq = new LinkedList<Integer>();
			}
		}
		
	}
}
