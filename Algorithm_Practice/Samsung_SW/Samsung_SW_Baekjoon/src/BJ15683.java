// 삼성 기출 
// 15683번
// 감시 
// 브루트 포스 ..
// CCTV 종류와 개수가 계속 바뀌므로 반복문 구현 안됨. -> 재귀 사용.

import java.util.ArrayList;
import java.util.Scanner;
public class BJ15683 {
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[] dx2 = {-1,1,0,0};
	static int[] dy2 = {0,0,1,-1};
	
	static int n;
	static int m;
	static int totalBlank;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		int[] map = new int[n*m];
		int[] visited = new int[n*m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i*m+j] = stdIn.nextInt();
			}
		}
		ArrayList<CCTV> al = new ArrayList<CCTV>();
		
		int wall = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i*m+j] != 0 && map[i*m+j] !=6) {
					al.add(new CCTV(i,j,map[i*m+j]));
				}
				if(map[i*m+j] == 6) {
					wall++;
				}
			}
		}
		totalBlank = (n*m) - al.size() - wall;
		simulate(al,0,map,visited,0);	
		System.out.println(ans);;
		
	}
	static void print(int[] ar) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.printf("%d ", ar[i*m+j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void simulate(ArrayList<CCTV> al, int index, int[] map, int[] visited, int cnt) {
		if(index == al.size()) {
			int tempAns = totalBlank - cnt;
			if(ans > tempAns) ans = tempAns;
			return;
		}
		
		int num = al.get(index).num;
		int x = al.get(index).x;
		int y = al.get(index).y;
		if(num == 1) {
			for(int i=0;i<4;i++) {
				int[] tempMap = map.clone();
				int[] tempVisited = visited.clone();
				int nx = x + dx[i];
				int ny = y + dy[i];
				int tempCnt = 0;
				while(nx>=0 && ny>=0 && nx < n && ny< m && tempMap[nx*m+ny] != 6) {
					if(tempMap[nx*m+ny] < 6) {
						if(tempMap[nx*m+ny] == 0 && tempVisited[nx*m+ny] == 0)
							tempCnt++;
						tempVisited[nx*m+ny] = 1;
					}
					nx += dx[i];
					ny += dy[i];
				}
				simulate(al,index+1, tempMap,tempVisited,cnt+tempCnt);
				
			}
		}else if(num == 2) {
			for(int j=0;j<2;j++) {
				int[] tempMap = map.clone();
				int[] tempVisited = visited.clone();
				int tempCnt = 0;
				for(int i = j*2 ;i< j*2+2;i++) {
					int nx = x + dx2[i];
					int ny = y + dy2[i];
					while(nx>=0 && ny>=0 && nx < n && ny< m && tempMap[nx*m+ny] != 6) {
						if(tempMap[nx*m+ny] < 6) {
							if(tempMap[nx*m+ny] == 0 && tempVisited[nx*m+ny] == 0)
								tempCnt++;
							tempVisited[nx*m+ny] = 1;
						}
						nx += dx2[i];
						ny += dy2[i];
					}
				}
				
				simulate(al,index+1, tempMap,tempVisited,cnt+tempCnt);
			}
			
		}else if(num == 3) {
			
			for(int j=0;j<4;j++) {
				int[] tempMap = map.clone();
				int[] tempVisited = visited.clone();
				int tempCnt = 0;
				for(int i= j ;i<j+2;i++) {
					int nx = x + dx[i%4];
					int ny = y + dy[i%4];
					while(nx>=0 && ny>=0 && nx < n && ny< m && tempMap[nx*m+ny] != 6) {
						if(tempMap[nx*m+ny] < 6) {
							if(tempMap[nx*m+ny] == 0 && tempVisited[nx*m+ny] == 0)
								tempCnt++;
							tempVisited[nx*m+ny] = 1;
						}
						nx += dx[i%4];
						ny += dy[i%4];
					}
				}
				simulate(al,index+1, tempMap,tempVisited,cnt+tempCnt);
			}
		}else if(num == 4) {

			for(int j=0;j<4;j++) {
				int[] tempMap = map.clone();
				int[] tempVisited = visited.clone();
				int tempCnt = 0;
				for(int i= j;i<j+3;i++) {
					int nx = x + dx[i%4];
					int ny = y + dy[i%4];
					while(nx>=0 && ny>=0 && nx < n && ny< m && tempMap[nx*m+ny] != 6) {
						if(tempMap[nx*m+ny] < 6) {
							if(tempMap[nx*m+ny] == 0 && tempVisited[nx*m+ny] == 0)
								tempCnt++;
							tempVisited[nx*m+ny] = 1;
						}
						nx += dx[i%4];
						ny += dy[i%4];
					}
				}
				
				simulate(al,index+1, tempMap,tempVisited,cnt+tempCnt);
			}
			
		}else {
			int[] tempMap = map.clone();
			int[] tempVisited = visited.clone();
			int tempCnt = 0;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				while(nx>=0 && ny>=0 && nx < n && ny< m && tempMap[nx*m+ny] != 6) {
					if(tempMap[nx*m+ny] < 6) {
						if(tempMap[nx*m+ny] == 0 && tempVisited[nx*m+ny] == 0) {
							tempCnt++;
						}
						tempVisited[nx*m+ny] = 1;
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
			simulate(al,index+1, tempMap,tempVisited,cnt+tempCnt);
		}

	}
}
class CCTV{
	int x;
	int y;
	int num;
	CCTV(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}