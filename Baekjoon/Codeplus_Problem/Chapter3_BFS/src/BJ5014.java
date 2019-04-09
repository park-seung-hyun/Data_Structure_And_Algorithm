// 5014번
// 스타트링크 
// BFS

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ5014 {
//	static int[] visited;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int f = stdIn.nextInt();
//		int s = stdIn.nextInt();
//		int g = stdIn.nextInt();
//		int u = stdIn.nextInt();
//		int d = stdIn.nextInt();
//		visited = new int[f+1];
//		solve(f,s,g,u,d);
//	}
//	static void solve(int f,int s, int g, int u, int d) {
//		Queue<Integer> q= new LinkedList<Integer>();
//		q.add(s);
//		visited[s] = 1;
//		while(!q.isEmpty()) {
//			int h= q.remove();
//			if(h+u <= f && visited[h+u] == 0) {
//				q.add(h+u);
//				visited[h+u] = visited[h] + 1;
//			}
//			
//			if(h-d > 0 && visited[h-d] == 0) {
//				q.add(h-d);
//				visited[h-d] = visited[h] + 1;
//			}
//		}
//		
//		System.out.println(visited[g]- 1 == -1 ? "use the stairs" : visited[g]-1);
//	}
//}


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ5014{
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int f = stdIn.nextInt();
		int s = stdIn.nextInt();
		int g = stdIn.nextInt();
		int u = stdIn.nextInt();
		int d = stdIn.nextInt();
		visited = new int[f+1];
		solve(f,s,g,u,d);
	}
	static void solve(int f, int s, int g, int u, int d) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = 1;
		q.add(s);
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h+u<=g && visited[h+u] == 0) {
				visited[h+u] = visited[h] + 1;
				q.add(h+u);
			}
			if(h-d>=0 && visited[h-d] == 0) {
				visited[h-d] = visited[h] + 1;
				q.add(h-d);
			}
		}
		System.out.println(visited[g] == 0 ? "use the stairs" : visited[g]-1);
		
	}
}