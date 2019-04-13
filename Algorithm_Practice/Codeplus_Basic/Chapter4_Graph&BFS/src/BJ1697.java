// 1697번 
// 숨바꼭질  
// bfs
// -> 최소 비용 문제
// -> 간선의 가중치가 1개 
// -> 정점과 간선 개수 적어야함.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1697 {
	static int[] time = new int[100001];
	static int n;
	static int k;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		k = stdIn.nextInt();
		Arrays.fill(time, -1);
		bfs();
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		time[n] = 0;
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h==k) {
				System.out.println(time[h]);
				break;
			}
			if(h-1>=0 && time[h-1] == -1) {
				q.add(h-1);
				time[h-1] = time[h] +1;
			}
			if(h+1<=100000 && time[h+1] == -1) {
				q.add(h+1);
				time[h+1] = time[h] +1;
			}
			if(h*2<=100000 && time[h*2] == -1) {
				q.add(h*2);
				time[h*2] = time[h] +1;
			}
		}
	}
	
}
