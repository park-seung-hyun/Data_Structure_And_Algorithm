// 1697번 (복습)
// 숨바꼭질 
// BFS
// BFS, DFS 언제 사용하는지 공부하기 
// 최소 비용 문제이므로 BFS 
// 조건으로 모든 가중치가 1로 같아야함. 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ1697 {
	static int[] dist = new int[100001];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		solve(n,k);
		System.out.println(dist[k]-1);
	}
	static void solve(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		dist[n] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h+1<=100000 && dist[h+1]==0) {
				q.add(h+1);
				dist[h+1] = dist[h] +1;
			}
			if(h*2<=100000 && dist[h*2]==0) {
				q.add(h*2);
				dist[h*2] = dist[h] +1;
			}
			if(h-1>=0 && dist[h-1]==0) {
				q.add(h-1);
				dist[h-1] = dist[h] +1;
			}
		}
	}
}
