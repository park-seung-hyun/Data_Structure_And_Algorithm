// 삼성 기출 
// 14502번
// 연구소 
// 좋은 벽 후보지를 찾는거 ㄴㄴ -> 그냥 순열로 모든 경우 다 해봄. 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ14502 {
	static int ans = 0;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new int[n][m];
		ArrayList<PP> blank = new ArrayList<PP>();
		ArrayList<PP> virus = new ArrayList<PP>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
				if(map[i][j] == 0) blank.add(new PP(i,j));
				if(map[i][j] == 2) virus.add(new PP(i,j));
			}
		}
		int[] perm = new int[blank.size()];
		perm[0] = 1;
		perm[1] = 1;
		perm[2] = 1;
		do {
			for(int i=0;i<perm.length;i++) {
				if(perm[i] == 1) {
					int x = blank.get(i).x;
					int y = blank.get(i).y;
					map[x][y] = 1;
				}
			}
			bfs(virus, n,m,blank.size()-3);
			for(int i=0;i<perm.length;i++) {
				if(perm[i] == 1) {
					int x = blank.get(i).x;
					int y = blank.get(i).y;
					map[x][y] = 0;
				}
			}
		}while(np(perm));
		System.out.println(ans);
	}
	static void bfs(ArrayList<PP> v, int n, int m, int bs) {
		int[][] visited = new int[n][m];
		Queue<PP> q= new LinkedList<PP>();
		for(PP p : v) {
			q.add(p);
			visited[p.x][p.y] = 1;
		}
		int cnt = 0-v.size();
		while(!q.isEmpty()) {
			PP h = q.remove();
			int x = h.x;
			int y = h.y;
			cnt++;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny =y + dy[i];
				if(nx>=0 && ny>=0 && nx <n && ny< m) {
					if(visited[nx][ny] == 0 && (map[nx][ny] == 0 || map[nx][ny] == 2)) {
						q.add(new PP(nx,ny));
						visited[nx][ny] = 1;
					}
				}
			}
		}
		if(ans < bs-cnt) ans = bs-cnt;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] <= ar[i])i--;
		if(i==0)return false;
		int j = n-1;
		while(ar[i-1]<=ar[j])j--;
		swap(ar,i-1,j);
		j= n-1;
		while(i<j) {
			swap(ar, i,j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] ar, int id1,int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}
class PP{
	int x;
	int y;
	PP(int x, int y){
		this.x = x;
		this.y = y;
	}
}