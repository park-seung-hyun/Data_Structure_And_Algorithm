// 13549번 
// 숨바꼭질3 
// 최소 비용 문제의 조건 -> 모든 가중치가 1
// 위 조건을 위배함. (순간이동의 가중치가 0)
// 이는 큐 2개 또는 덱 1개를 통해 해결 가능 
// 가중치가 0일 경우 덱의 맨 앞에 (현재 대상과 같은 레벨 위치) 추가하고,
// 가중치가 1일 경우 뒤에 추가한다. 

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;
public class BJ13549 {
	static int visited[] = new int[100001];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n =stdIn.nextInt();
		int k =stdIn.nextInt();
		Arrays.fill(visited, -1);
		bfs2(n);
		System.out.println(visited[k]);
	}
	static void bfs(int n) {
		Queue<Integer> cq = new LinkedList<Integer>();
		Queue<Integer> nq = new LinkedList<Integer>();
		
		cq.add(n);
		visited[n] = 0;
		
		while(!cq.isEmpty()) {
			int h = cq.remove();
			
			if(h*2<=100000 && visited[h*2] == -1) {
				cq.add(h*2);
				visited[h*2] = visited[h];
			}
			
			if(h+1<=100000 && visited[h+1] == -1) {
				nq.add(h+1);
				visited[h+1] = visited[h]+1;
			}
			
			if(h-1>=0 && visited[h-1] == -1) {
				nq.add(h-1);
				visited[h-1] = visited[h]+1;
			}
			
			if(cq.isEmpty()) {
				cq = nq;
				nq = new LinkedList<Integer>();
			}
		}
		
	}
	static void bfs2(int n) {
		 ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		 dq.add(n);
		 visited[n] = 0;
		 while(!dq.isEmpty()) {
			 int h = dq.removeFirst();
			 if(h*2<=100000 && visited[h*2] == -1) {
				 dq.addFirst(h*2);
				 visited[h*2] = visited[h];
			 }
			 if(h+1<=100000 && visited[h+1] == -1) {
				 dq.addLast(h+1);
				 visited[h+1] = visited[h] +1;
			 }
			 if(h-1>=0 && visited[h-1] == -1) {
				 dq.addLast(h-1);
				 visited[h-1] = visited[h] +1;
			 }
		 }
		 
	}
}
