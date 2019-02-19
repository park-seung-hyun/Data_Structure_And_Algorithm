// 13023번 
// ABCDE 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class BJ13023 {
	static ArrayList<Integer>[] adj2;
	static boolean[] visited;
	static int max = 0;
	static int cnt = 0;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int e = stdIn.nextInt();
		
		adj2 = (ArrayList<Integer>[] )new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj2[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			adj2[a].add(b);
			adj2[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			Collections.sort(adj2[i]);
		}
		
		System.out.println(solve(n)?1:0);
	}
	static boolean solve(int n) {
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			if(max == 4) {
				break;
			}
			visited[i] = true;
			search(n,i);
			visited[i] = false;
		}
		return (max >= 4)?true:false;
	}
	static void search(int n, int p) {
		if(max < cnt)
			max = cnt;
		
		if(max == 4) {
			return;
		}
		for(int i: adj2[p]) {
			if(visited[i]==false) {
				visited[i] = true;
				cnt++;
				search(n,i);
				cnt--;
				visited[i] = false;
			}
		}
	}
}
