// 9019번 
// DSLR
// BFS
// 왼쪽, 오른쪽 shift

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ9019 {
	static int[] visited = new int[10000];
	static char[] track = new char[10000]; // 추적 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		
		for(int i=0;i<t;i++) {
			Arrays.fill(visited, -1);
			track = new char[10000];
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			solve(a,b);
		}
	}
	static void solve(int a, int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = -2;
	
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == b)
				break;
			
			d(q,h);
			s(q,h);
			l(q,h);
			r(q,h);	
		}
//		trackNum(b);
//		System.out.println();
		trackNum2(a,b);
		System.out.println();
	}
	static void trackNum(int n) {
		if(visited[n] ==  -2)
			return;
		
		trackNum(visited[n]);
		System.out.printf("%c",track[n]);
	}
	static void trackNum2(int a, int b) {
		if(a==b) {
			return;
		}
		trackNum2(a, visited[b]);
		System.out.printf("%c",track[b]);
	}
	static void d(Queue<Integer> q, int h) {
		if(h*2 < 10000 && visited[h*2] == -1) {
			q.add(h*2);
			visited[h*2] = h;
			track[h*2] = 'D';
		}
		if(h*2>=10000 && visited[(h*2)%10000] == -1) {
			int c = (h*2)%10000;
			q.add(c);
			visited[c] = h;
			track[c] = 'D';
		}
	}
	static void s(Queue<Integer> q, int h) {
		if(h-1 >= 0 && visited[h-1] == -1) {
			q.add(h-1);
			visited[h-1] = h;
			track[h-1] = 'S';
		}
		if(h==0 && visited[9999] == -1) {;
			q.add(9999);
			visited[9999] = h;
			track[9999] = 'S';
		}
	}
	static void l(Queue<Integer> q, int h) {
//		int a = h/1000;
//		int b = (h-a*1000)/100;
//		int c = (h-a*1000-b*100)/10;
//		int d = (h-a*1000-b*100-c*10);
//		
//		int newh = b*1000 + c*100 + d*10 + a;

		
		int newh = (h%1000) * 10 + h/1000;
		
		if(visited[newh] == -1) {
			q.add(newh);
			visited[newh] = h;
			track[newh] = 'L';
		}		
	}
	static void r(Queue<Integer> q, int h) {
//		int a = h/1000;
//		int b = (h-a*1000)/100;
//		int c = (h-a*1000-b*100)/10;
//		int d = (h-a*1000-b*100-c*10);
//		
//		int newh = d*1000 + a*100 + b*10 + c;
		int newh = (h/10) + (h%10) * 1000; 
		if(visited[newh] == -1) {
			q.add(newh);
			visited[newh] = h;
			track[newh] = 'R';
		}
	}
}
