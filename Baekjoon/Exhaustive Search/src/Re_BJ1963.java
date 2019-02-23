// 1963번 (복습)
// 소수 경로 
// BFS -> 최소 비용 문제 (모든 가중치가 1)
// 소수 (Prime) -> 에라토스테네스의 체 
// Java 형 변환 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ1963 {
	static int[] dist;
	static boolean[] check = new boolean[10000];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		erathosthese(10000);

		for(int i=0;i<t;i++) {
			dist = new int[10000];
			int a= stdIn.nextInt();
			int b =stdIn.nextInt();
			solve(a,b);
		}
	}
	static void erathosthese(int n) {
		for(int i=2;i*i<n;i++) { // 2 ~ 9999
			if(check[i] == false) {
				for(int j=2*i;j<n;j+=i) {
					check[j] = true;
				}
			}
		}
	}
	static boolean isFour(int n) {
		return (n>=1000 && n<10000)?true:false;
	}
	static void solve(int a,int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		dist[a] = 1;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			String s = Integer.toString(h);
			if(h == b) {
				System.out.println(dist[h]-1);
				return;
			}
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<10;j++) {
					char[] c = s.toCharArray();
					if(c[i] != Integer.toString(j).charAt(0)) {
						c[i] = Integer.toString(j).charAt(0);
						int n = Integer.parseInt(new String(c));
						if(check[n] == false && isFour(n) && dist[n] == 0) {
							q.add(n);
							dist[n] = dist[h] + 1;
						}
					}
				}
			}
		}
		System.out.println("Impossible");
	}
}
