// 2623번 
// 음악 프로그램 
// 위상 정렬 (Topological sort) 
// 다른 자료구조 사용하여 다시 풀어볼 것 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2623 {
	static int[] seq;
	static ArrayList<Integer> result = new ArrayList<Integer>(); 
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int M = stdIn.nextInt();
		
		int[][] ar = new int[M][];

		seq = new int[N+1];
		
		for(int i=0;i<M;i++) {
			int s = stdIn.nextInt();
			ar[i] = new int[s];
			for(int j=0;j<s;j++) {
				ar[i][j] = stdIn.nextInt();
			}
		}

		topologicalSort(ar);
		
		if(result.size() == N) {
			for(int i=0;i<result.size();i++) {
				System.out.println(result.get(i));
			}
		}else {
			System.out.println(0);
		}
			
		
	}
	static void topologicalSort(int[][] sa) {
		Queue<Integer> q = new LinkedList();
		for(int i=0;i<sa.length;i++) {
			for(int j=1;j<sa[i].length;j++) {
				seq[sa[i][j]] += j;
			}
		}
		
		for(int i=1;i<seq.length;i++) {
			if(seq[i] == 0) {
				q.add(i);
				seq[i]--;
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.peek();
			result.add(n);
			q.remove();
			
			for(int i=0;i<sa.length;i++) {
				boolean f=false;
				for(int j=0;j<sa[i].length;j++) {
					if(f ==true)
						seq[sa[i][j]]--;
					if(sa[i][j] == n)
						f = true;
				}	
			}
			for(int i=1;i<seq.length;i++) {
				if(seq[i] == 0) {
					q.add(i);
					seq[i]--;
				}
			}
			
			
		}
	}
}
