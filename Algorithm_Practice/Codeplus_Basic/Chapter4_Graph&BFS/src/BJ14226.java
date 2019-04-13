// 14226번 
// 이모티콘  
// bfs
// -> 최소 비용 문제
// -> 간선의 가중치가 1개 
// -> 정점과 간선 개수 적어야함.
// -> 하나의 정점이 서로 다른 두개의 정보를 가짐. (s, c 값이 중요)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ14226 {
	static int[][] time = new int[1001][1001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int s = stdIn.nextInt();
		bfs();
		
		// 최솟값 구하는 방법 
		int min = -1;
		for(int i=0;i<=1000;i++) {
			if(time[s][i] !=0) {
				if(min == -1 || min > time[s][i])
					min = time[s][i];
			}
		}
		System.out.println(min-1);
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(0);
		time[1][0] = 1;
		while(!q.isEmpty()) {
			int s = q.remove();
			int c = q.remove();
			
			if(time[s][s] == 0) {
				time[s][s] = time[s][c]+1;
				q.add(s);
				q.add(s);
			}
			if(s+c<=1000 && time[s+c][c] == 0) {
				time[s+c][c] = time[s][c]+1;
				q.add(s+c);
				q.add(c);
			}
			if(s-1>=0 && time[s-1][c] == 0) {
				time[s-1][c] = time[s][c]+1;
				q.add(s-1);
				q.add(c);
			}
		}
	}
}
//public class BJ14226 {
//	static int[][] visited = new int[1001][1001];
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int S = stdIn.nextInt();
//		
//		Queue<Image> q = new LinkedList<Image>();
//		q.add(new Image(1,0));
//		while(!q.isEmpty()) {
//			Image h = q.remove();
//			int s = h.s;
//			int c = h.c;
//			if(s == S) {
//				System.out.println(visited[s][c]);
//				return;
//			}
//			
//			if(s-1>=0 && visited[s-1][c] == 0) {
//				q.add(new Image(s-1, c));
//				visited [s-1][c] = visited[s][c] + 1; 
//			}
//			if(visited[s][s] == 0) {
//				q.add(new Image(s, s));
//				visited[s][s] = visited[s][c] + 1; 
//			}
//			if(s+c<=1000 && visited[s+c][c] == 0) {
//				q.add(new Image(s+c, c));
//				visited[s+c][c] = visited[s][c] + 1; 
//			}
//		}
//		
//	}
//}
//class Image{
//	int s;
//	int c;
//	Image(int s, int c){
//		this.s = s;
//		this.c = c;
//	}
//}