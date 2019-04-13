import java.util.Scanner;

public class BJ12100 {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static int ans = 0;
	static int[] check;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] map = new int[n*n];
		check = new int[n*n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i*n + j] = stdIn.nextInt();
			}
		}
		solve(n, map);
	}
	static void solve(int n, int[] map) {
		for(int i=0;i<4;i++) {
			int[] newMap = map.clone();
			go(newMap,i,n,0);
		}
		System.out.println(ans);
	}
	static void print(int[] m, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%d ", m[i*n+j]);
			}
			System.out.println();
		}
	}
	static int[] simulate(int[] nm, int dir, int x, int y, int n) {
		int num = nm[x*n+y];
		nm[x*n+y] = 0;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		while(nx >=0 && ny >= 0 && nx < n && ny < n) {
			if(nm[nx*n+ny] == num && check[nx*n+ny] == 0) {
				nm[nx*n+ny] += num;
				check[nx*n+ny] = 1;
				return nm;
			}
			if(nm[nx*n+ny] != 0) break;
			nx += dx[dir];
			ny += dy[dir];
		}
		nx -= dx[dir];
		ny -= dy[dir];
		nm[nx*n+ny] = num;
		return nm;
	}
	static void go(int[] map , int dir, int n , int cnt) {
		if(cnt == 5) return;
		int[] newMap = map;
		check = new int[n*n];
		if(dir == 0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(newMap[i*n+j] == 0) continue;
					newMap = simulate(newMap, dir, i,j,n);
				}
			}
		}
		else if(dir == 1) {
			for(int j=n-1;j>=0;j--) {
				for(int i=0;i<n;i++) {
					if(newMap[i*n+j] == 0) continue;
					newMap = simulate(newMap, dir, i,j,n);
				}
			}
		}
		else if(dir == 2) {
			for(int i=n-1;i>=0;i--) {
				for(int j=0;j<n;j++) {
					if(newMap[i*n+j] == 0) continue;
					newMap = simulate(newMap, dir, i,j,n);
				}
			}

		}else {
			for(int j=0;j<n;j++) {
				for(int i=0;i<n;i++) {
					if(newMap[i*n+j] == 0) continue;
					newMap = simulate(newMap, dir, i,j,n);
				}
			}
		}
		
//		print(newMap, n);
//		System.out.println();
//		
		boolean flag = false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ans < newMap[i*n+j]) {
					ans = newMap[i*n+j];
//					flag = true;
				}
			}
			
		}
//		if(flag == false) return;
		for(int i=0;i<4;i++) {
			int[] tempMap = newMap.clone();
			go(tempMap, i, n, cnt+1);
		}
	}
}
