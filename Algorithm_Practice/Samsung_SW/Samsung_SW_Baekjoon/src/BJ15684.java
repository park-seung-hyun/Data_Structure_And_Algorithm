// 삼성 기출 
// 15684번
// 사다리 조작 
// 진짜 어려웠음.. 시간초과...
// 재귀 부분에서 언제 사다리 검사를 하느냐가 관건..
// 기존에는 매번 했는데 매우매우 비효율적 

import java.util.ArrayList;
import java.util.Scanner;
public class BJ15684 {
	static int ans = 4;
	static int[] map;
	static int n;
	static int m;
	static int h;
	static ArrayList<PPP> al;
	static void print(int[] ar) {
		System.out.println();
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%d ", ar[i*n+j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		h = stdIn.nextInt();
		map = new int[h*n]; // 행 -> H, 열 -> N 
		int cnt = 1;
		for(int i=0;i<m;i++) {
			int a = stdIn.nextInt()-1;
			int b = stdIn.nextInt()-1;
			map[a*n+b] = cnt;
			map[a*n+(b+1)] = cnt;
			cnt++;
		}
		al = new ArrayList<PPP>();
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n-1;j++) {
				if(map[i*n+j] == 0 && map[i*n+j+1] == 0) al.add(new PPP(i,j));
			}
		}
		go(0,map,0,cnt);
		System.out.println(ans == 4 ? -1 : ans);
		
	}
	static boolean simulate(int[] map) {
		for(int i=0;i<n;i++) {
			int[] visited = new int[h*n];
			int startX = 0;
			int startY = i;
			while(startX < h) {	
				visited[startX * n + startY] = 1;
				if(map[startX * n + startY] == 0) {
					startX++;
				}else { // 1 이상 
					if(startY+1 < n && map[startX * n + startY + 1] == map[startX * n + startY] && visited[startX * n + startY + 1] == 0)
						startY++;
					else if(startY-1 >=0 && map[startX * n + startY - 1] == map[startX * n + startY] && visited[startX * n + startY - 1] == 0 ) {
						startY--;
					}else {
						startX++;
					}
				}
			}
//			System.out.println(startY + " " + i);
			if(startY != i) return false;
		}
		return true;
	}
	static void go(int index, int[] map, int cnt, int num) {
		if(cnt > 3) return;
		
		// 문제의 부분 ..
		// 매번 simulate를 들리는 게 아니라 
		// 인덱스가 끝까지 갔을 경우에 
		// 그 때 cnt가 0,1,2,3만 살아있을꺼임 그때 simulate 
		if(index == al.size()) {
			if(simulate(map) == true) {
				if(ans > cnt) {
					ans = cnt;
				}
				return;
			}
			
			return;
		}
		PPP p = al.get(index);
		int x = p.x;
		int y = p.y;
		if(map[x*n + y] == 0 && map[x*n + y+1] == 0) {
			map[x*n + y] = num;
			map[x*n + (y+1)] = num;
			go(index+1, map, cnt+1, num+1);
			map[x*n + y] = 0;
			map[x*n + (y+1)] = 0;
		}
		go(index+1,  map, cnt, num);
	}
}
class PPP{
	int x;
	int y;
	PPP(int x, int y){
		this.x = x;
		this.y = y;
	}
}