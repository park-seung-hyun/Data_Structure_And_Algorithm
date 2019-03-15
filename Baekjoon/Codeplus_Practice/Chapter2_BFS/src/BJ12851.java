// 12851번 
// 숨바꼭질2
// BFS
// solve -> 레벨 고려하며 풀이 
// solve2 -> DP 적용

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ12851 {
	static int[] visited = new int[100001];
	static int[] count = new int[100001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		solve(n, k);
	}
	static void solve2(int n, int k) {
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 0;
		count[n] = 1;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h-1>=0 && visited[h-1] == -1) {
				q.add(h-1);
				visited[h-1] = visited[h] + 1;
				count[h-1] += count[h]; // 방법 수 누적 
			}else if(h-1>=0 && visited[h-1] == visited[h] + 1){
				count[h-1] += count[h]; // 방법 수 누적 
			}
			if(h+1<=100000 && visited[h+1] == -1) {
				q.add(h+1);
				visited[h+1] = visited[h] + 1;
				count[h+1] += count[h]; 
			}else if(h+1<=100000 && visited[h+1] == visited[h] + 1){
				count[h+1] += count[h]; 
			}
			
			if(h*2<=100000 && visited[h*2] == -1) {
				q.add(h*2);
				visited[h*2] = visited[h] + 1;
				count[h*2] += count[h]; 
			}else if(h*2<=100000 && visited[h*2] == visited[h] + 1){
				count[h*2] += count[h]; 
			}
		}
		System.out.printf("%d %d", visited[k], count[k]);
	}
	static void solve(int n, int k) {
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			
			if(h==k) {
				cnt ++;
			}
			if(visited[k] != -1 && visited[k] < visited[h]) {
				break;
			}
				
			if(h-1>=0 && (visited[h-1] == -1 || visited[h-1] == visited[h] + 1)) {
				
				q.add(h-1);
				visited[h-1] = visited[h] + 1;
				
			
			}
			if(h+1<=100000 && (visited[h+1] == -1|| visited[h+1] == visited[h] + 1)) {

				q.add(h+1);
				visited[h+1] = visited[h] + 1;
				
		
			}
			if(h*2<=100000 && (visited[h*2] == -1|| visited[h*2] == visited[h] + 1)) {
				
				q.add(h*2);
				visited[h*2] = visited[h] + 1;
				
			}
		}
		System.out.printf("%d %d", visited[k], cnt);

	}
}
