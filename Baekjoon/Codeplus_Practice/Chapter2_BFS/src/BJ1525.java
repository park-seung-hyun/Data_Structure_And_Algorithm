// 1525번 
// 퍼즐 
// BFS
// 배열의 인덱스로 숫자가 허용이 안됨. -> HashMap 사용 
// 굳이 배열로 바꿀 필요없음. x = n/3, y = n%3  <-> n = x*3+y 

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
				if(a == 0) a = 9;
				n += a*Math.pow(10, cnt);
				cnt--;
			}
		}
//		solve(n);
		solve2(n);
	}
	static void solve2(int n) {
		Queue<Integer> q= new LinkedList<Integer>();
		
		q.add(n);
		hm.put(n, 0);
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == 123456789)
				break;
			next2(q, h);
		}
		
		if(hm.get(123456789) == null) {
			System.out.println(-1);
		}
		else{
			System.out.println(hm.get(123456789));
		}
		
		
	}
	static String swap(String s, int id1, int id2) {
		StringBuilder sb = new StringBuilder(s);
		char temp = s.charAt(id1);
		sb.setCharAt(id1, s.charAt(id2));
		sb.setCharAt(id2, temp);
		s = sb.toString();
//		char[] ca = s.toCharArray();
//		char c = s.charAt(id1);
//		char c2 = s.charAt(id2);
//		ca[id1] = c2;
//		ca[id2] = c;
//		s = String.valueOf(ca);
		return s;
	}
	static void next2(Queue<Integer> q, int n) {
		
		int x = 0;
		int y = 0;
		String s = Integer.toString(n);
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '9') {
				x = i/3;
				y = i%3;
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0 && ny >=0 && nx<3 && ny<3) {

				String news = swap(s,x*3+y,nx*3+ny);
				int newn = Integer.parseInt(news);
				if(!hm.containsKey(newn)) {
					q.add(newn);
					hm.put( newn, hm.get(n) + 1);
				}
			
			}
		}
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
		// 숫자 -> Map 변환 
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
				
				// Map -> 숫자 변환 
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
