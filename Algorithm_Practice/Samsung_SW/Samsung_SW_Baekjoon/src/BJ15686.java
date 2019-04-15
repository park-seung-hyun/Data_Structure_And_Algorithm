// 삼성 기출 
// 15686번
// 치킨 배달 
// 진짜 어려움..
// 모든 집 <-> 치킨집 사이 거리를 계산 해놓는게 시간복잡도상 적게 걸림..

// 순열 돌리면서 매번 bfs하는 거면 생각해봐야됨.
// 치킨집이 바뀔 때마다 거리가 바뀌나?? 안바뀜 그러면 미리 거리들 구해놓고 시작..

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ15686 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int n;
	static int m;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Integer> ck = new ArrayList<Integer>();
	static ArrayList<Integer> hm = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
				if(map[i][j] == 2) ck.add(i*n+j);
				if(map[i][j] == 1) hm.add(i*n+j);
			}
		}
		
		int[][] dist = new int[hm.size()][ck.size()];
		
		for(int i=0;i<hm.size();i++) {
			for(int j=0;j<ck.size();j++) {
				dist[i][j] = getDist(hm.get(i), ck.get(j));
			}
		}
		
		int[] perm = new int[ck.size()];
		for(int i=0;i<m;i++) {
			perm[i] = 1;
		}
		
		do {
			int sum = 0;
			int[] ckck = new int[m];
			int id = 0;
			for(int i=0;i<ck.size();i++) {
				if(perm[i] == 1) {
					ckck[id++] = i;
				}
			}
			for(int i=0;i<hm.size();i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<m;j++) {
					int idx = ckck[j];
					if(min > dist[i][idx]) min = dist[i][idx];
				}
				sum += min;
			}
			if(ans > sum) ans = sum;
			
		}while(np(perm));
		System.out.println(ans);
		
	}
	static void print(int[] ar) {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%d ", ar[i*n+j]);
			}
			System.out.println();
		}
	}
	static int getDist(int hm, int ck) {
		int[][] visited = new int[n][n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(hm);
		visited[hm/n][hm%n] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/n;
			int y = h%n;
			if(x*n+y==ck ) {
				return visited[x][y]-1;
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx < n && ny < n) {
					if(visited[nx][ny] == 0) {
						q.add(nx*n +ny);
						visited[nx][ny] =visited[x][y] + 1;
					}
				}
			}
		}
		return -1;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i=n-1;
		while(i>0 && ar[i-1] <= ar[i])i--;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1] <= ar[j])j--;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar,i,j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}
class Home{
	int n;
	int id;
	Home(int n, int id){
		this.n = n;
		this.id = id;
	}
}