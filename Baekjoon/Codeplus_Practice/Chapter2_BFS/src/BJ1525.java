// 1525번 
// 퍼즐 
// BFS
// 9!개의 노드(퍼즐 형태이므로 쉽게 저장이 안됨.)
// HashMap 사용 

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1525 {
	static HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = 0;
		int cnt = 8;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				int a = stdIn.nextInt();
				n += a*Math.pow(10, cnt);
				cnt--;
			}
		}
		solve(n);
	}
	static void solve(int n) {
		Queue<Integer> q= new LinkedList<Integer>();
		
		q.add(n);
		hm.put(n, 0);
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == 123456780)
				break;
			next(q, h);
		}
		
		if(hm.get(123456780) == null) {
			System.out.println(-1);
		}
		else{
			System.out.println(hm.get(123456780));
		}
		
		
	}
	static void next(Queue<Integer> q, int n) {
		int x = 0;
		int y = 0;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int[][] ar = new int[3][3];
		int oldn = n;
		int cnt = 8;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				ar[i][j] = (int) (n/(Math.pow(10,cnt)));
				if(ar[i][j] == 0) {
					x = i;
					y = j;
				}
				n -= (ar[i][j] * (Math.pow(10,cnt)));
				cnt--;
			}
		}
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0 && ny >=0 && nx<3 && ny<3) {
				ar[x][y] = ar[nx][ny];
				ar[nx][ny] = 0;
				
				int newn = 0;
				cnt = 8;
				for(int j=0;j<3;j++) {
					for(int m=0;m<3;m++) {
						newn += ar[j][m]*Math.pow(10, cnt);
						cnt--;
					}
				}

				if(!hm.containsKey(newn)) {
					q.add(newn);
					hm.put( newn, hm.get(oldn) + 1);
				}
				
				ar[nx][ny] = ar[x][y];
				ar[x][y] = 0;
			}
		}
		
		
		
		
	}
}
