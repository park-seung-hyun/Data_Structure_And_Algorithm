// 1463번  
// 1로 만들기 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Top-Down) -> solve2
// BFS -> solve3

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1463 {
	static int[] d = new int[1000001]; // dp용 
	static int[] visited = new int[1000001]; // bfs용 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		
//		solve(n);
//		System.out.println(d[n]);
		
		System.out.println(solve2(n));
		
//		bfs
//		solve3(n);
//		System.out.println(visited[1]-1);
	}
	static void solve(int n) {
		d[1] = 0;
		for(int i=2;i<=n;i++) {
			int min = 0;
			if(i-1 >= 0) {
				min = d[i-1] + 1;
			}
			if(i%2 == 0) {
				if(min > d[i/2] + 1)
					min = d[i/2] + 1;
			}
			if(i%3 == 0) {
				if(min > d[i/3] + 1)
					min = d[i/3] + 1;
			}
			d[i] = min;
		}
	}
	static int solve2(int n) {
		if(n == 1)
			return 0;
		
		if(d[n]>0) 
			return d[n];
		
		int min = 0;
		if(n-1>=0) {
			min = solve2(n-1)+1;
		}
		if(n%2 == 0) {
			int temp = solve2(n/2) +1;
			if(temp < min)
				min = temp;
		}
		if(n%3 == 0) {
			int temp = solve2(n/3) +1;
			if(temp < min)
				min = temp;
		}
		d[n] = min;
		return d[n];
	}
	static void solve3(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h==1)
				break;
			
			if(h%3 == 0) {
				if(visited[h/3] == 0) {
					q.add(h/3);
					visited[h/3] = visited[h] +1;
				}
			}
			if(h%2 == 0) {
				if(visited[h/2] == 0) {
					q.add(h/2);
					visited[h/2] = visited[h] +1;
				}
			}
			if(h-1>=0) {
				if(visited[h-1] == 0) {
					q.add(h-1);
					visited[h-1] = visited[h] +1;
				}
			}
		}
	}
}
//public class BJ1463{
//	static int[] d;
//	public static void main(String[] args) {
//		Scanner stdIn=  new Scanner(System.in);
//		int n = stdIn.nextInt();;
//		d = new int[n+1];
//		solve(n);
//	}
//	static void solve(int n) {
//		d[1] = 0;
//		for(int i=2;i<=n;i++) {
//			int min = d[i-1] + 1;
//			if(i%2 == 0) {
//				if(min > d[i/2] + 1)
//					min =d[i/2] + 1;
//			}
//			if(i%3 == 0) {
//				if(min > d[i/3] + 1)
//					min =d[i/3] + 1;
//			}
//			d[i] = min;
//		}
//		System.out.println(d[n]);
//	}
//}