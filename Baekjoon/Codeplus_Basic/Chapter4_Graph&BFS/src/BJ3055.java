// 3055번 
// 탈출
// 최소 비용 문제의 조건 -> 모든 가중치가 1
// 홍수로 인한 물이 차는 시간 즉 물의 최소 경로를 구한다. 
// 그 후 비버의 최소 경로를 계산한다. (물이 차는 시간과 겹치지 않도록 조건을 준다.)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ3055 {
	static char[][] town;
	static int[][] flood;
	static int[][] visited;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		town = new char[r][c];
		flood = new int[r][c];
		visited = new int[r][c];
		for(int i=0;i<r;i++) {
			Arrays.fill(flood[i], -1);
			Arrays.fill(visited[i], -1);
		}
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j= 0;j<c;j++) {
				town[i][j] = s.charAt(j);
			}
		}
		solve(r,c);
	}
	static void solve(int r, int c) {
		 bfsFlood(r, c);
		 bfs(r, c);
		 for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == 'D') {
						System.out.println(visited[i][j] == -1 ? "KAKTUS":visited[i][j]);
				}
			}
		}
	}
	static void bfs(int r,int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == 'S') {
					q.add(i*c + j);
					visited[i][j] = 0;
					break;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/c;
			int y = h%c;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx<r && ny < c) {
					if(visited[nx][ny] == -1 && (town[nx][ny] == '.' || town[nx][ny] == 'D')) {
						if(flood[nx][ny] > visited[x][y] +1 || flood[nx][ny] == -1) {
							q.add(nx*c + ny);
							visited[nx][ny] = visited[x][y] +1;
						}
					}
				}
			}
		}
	}
	static void bfsFlood(int r, int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == '*') {
					q.add(i*c + j);
					flood[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/c;
			int y = h%c;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx<r && ny < c) {
					if(flood[nx][ny] == -1 && (town[nx][ny] == '.' || town[nx][ny] == 'S')) {
						q.add(nx*c + ny);
						flood[nx][ny] = flood[x][y]+1;
					}
				}
			}
		}
	}
}
