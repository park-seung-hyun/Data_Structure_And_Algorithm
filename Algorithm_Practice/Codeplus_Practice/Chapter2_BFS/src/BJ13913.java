// 13913번 
// 숨바꼭질4
// BFS

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ13913 {
	static int[] visited = new int[100001];
	static int[] track = new int[100001]; // 어디서 왔는지 저장 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		solve(n,k);
	}
	static void solve(int n, int k) {
		Arrays.fill(visited, -1);
		Arrays.fill(track, -1);
		Queue<Integer> q=  new LinkedList<Integer>();
		q.add(n);
		visited[n] = 0;
	
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == k)
				break;
			
			if(h-1>=0 && visited[h-1] == -1) {
				q.add(h-1);
				visited[h-1] = visited[h] + 1;
				track[h-1] = h; // h-1은 h에서 옴. 
			}
			if(h+1<=100000 && visited[h+1] == -1) {
				q.add(h+1);
				visited[h+1] = visited[h] + 1;
				track[h+1] = h;
			}
			if(h*2<=100000 && visited[h*2] == -1) {
				q.add(h*2);
				visited[h*2] = visited[h] + 1;
				track[h*2] = h;
			}
		}
		System.out.println(visited[k]);
		trackNum(k); // 역추적 

	}
	static void trackNum(int n) {
		if(n == -1) { // trackNum(track[5] == -1) 일때 
			return;
		}
		
		trackNum(track[n]);
		System.out.printf("%d ", n);
	}
}
//public class BJ13913{
//	static int[] visited = new int[100001];
//	static int[] track = new int[100001];
//	public static void main (String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n= stdIn.nextInt();
//		int k= stdIn.nextInt();
//		solve(n,k);
//		System.out.println(visited[k]-1);
//		trackNum(k);
//	}
//	static void trackNum(int n) {
//		if(n == -1) return;
//		trackNum(track[n]);
//		System.out.printf("%d ",n);
//	}
//	static void solve(int n, int k) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(n);
//		visited[n] = 1;
//		track[n] = -1;
//		while(!q.isEmpty()) {
//			int h = q.remove();
//			if(h == k) break;
//			if(h-1>=0 && visited[h-1] == 0) {
//				q.add(h-1);
//				visited[h-1] = visited[h] + 1;
//				track[h-1] = h;
//			}
//			if(h+1<=100000 && visited[h+1] == 0) {
//				q.add(h+1);
//				visited[h+1] = visited[h] + 1;
//				track[h+1] = h;
//			}
//			if(h*2<=100000 && visited[h*2] == 0) {
//				q.add(h*2);
//				visited[h*2] = visited[h] + 1;
//				track[h*2] = h;
//			}
//		}
//	}
//}
//
