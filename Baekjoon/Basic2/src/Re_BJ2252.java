// 2252번 (복습)
// 줄 세우기 
// 위상 정렬 (Topological sort) 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ2252 {
	static ArrayList<Integer>[] al;
	static int[] inConnect;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		al = (ArrayList<Integer>[]) new ArrayList[n+1];
		inConnect = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			al[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			al[a].add(b);
			inConnect[b]++;
		}
		solve(n);
	}
	static void solve(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++) {
			if(inConnect[i] == 0) {
				q.add(i);
				inConnect[i] = -1;
			}
		}
		
		while(!q.isEmpty()) {
			
			int h = q.remove();
			System.out.printf("%d ", h);
			
			for(int i: al[h]) {
				inConnect[i]--;
			}
			
			
			for(int i=1;i<=n;i++) {
				if(inConnect[i] == 0) {
					q.add(i);
					inConnect[i] = -1;
				}
			}
			
			
		}
		
		
	}
}
