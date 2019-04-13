// 2623번 (복습)
// 음악 프로그램 
// 위상 정렬 (Topological sort) 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ2623 {
	static int[] inDegree;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static ArrayList<Integer>[] al;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m= stdIn.nextInt();
		al = (ArrayList<Integer>[]) new ArrayList[1+n];
		for(int i=0;i<=n;i++) {
			al[i] = new ArrayList<Integer>();
		}
		inDegree = new int[1+n];
		for(int i=0;i<m;i++) {
			int k = stdIn.nextInt();
			int a = stdIn.nextInt();
			for(int j=0;j<k-1;j++) {
				int b = stdIn.nextInt();
				al[a].add(b);
				a = b;
				inDegree[b]++;
			}
		}
		solve(n);
	}
	static void solve(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				inDegree[i] = -1;
			}
		}
		while(!q.isEmpty()) {
			int h = q.remove();
			ans.add(h);
			for(int i: al[h]) {
				inDegree[i]--;
			}
			
			for(int i=1;i<=n;i++) {
				if(inDegree[i] == 0) {
					q.add(i);
					inDegree[i] = -1;
				}
			}
		}
		if(ans.size() != n) {
			System.out.println(0);
		}else {
			for(int i: ans) {
				System.out.println(i);
			}
		}
	}
}
