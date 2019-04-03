// 2251번 
// 물통 
// BFS
// 굳이 3차원 배열 안써도됨.
// 물 손실 없으므로 두 개의 정보로 가능.
// From, To 사용 !! 반복문으로 간단하게 

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//public class BJ2251 {
//	static int a;
//	static int b;
//	static int c;
//	static int[][][] visited;
//	
//	static final int[] from = {0,0,1,1,2,2};
//	static final int[] to =   {1,2,0,2,0,1};
//	static boolean[][] visited2;
//	
//	static ArrayList<Integer> ans = new ArrayList<Integer>();
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		a = stdIn.nextInt();
//		b = stdIn.nextInt();
//		c = stdIn.nextInt();
//		visited = new int[a+1][b+1][c+1];
//		visited2 = new boolean[a+1][b+1];
////		solve(0,0,c);
//		solve2();
//	}
//	static void solve2() {
//		int sum = c;
//		int[] cup = {a,b,c};
//		
//		Queue<Water2> q = new LinkedList<Water2>();
//		q.add(new Water2(0,0));
//		while(!q.isEmpty()) {
//			
//			Water2 h = q.remove();
//			
//			int a = h.a;
//			int b = h.b;
//			int c = sum-a-b;
//			int[] cur = {a,b,c};
//			
//			for(int k=0;k<6;k++) {
//				int[] next = {cur[0], cur[1], cur[2]};
//				// 일단 부어 
//				next[to[k]] += next[from[k]];
//				next[from[k]] = 0;
//				// 만약 넘쳤을 경우 
//				if(next[to[k]]>=cup[to[k]]) {
//					next[from[k]] = next[to[k]] - cup[to[k]];
//					next[to[k]] = cup[to[k]];
//				}
//				if(!visited2[next[0]][next[1]]) {
//					visited2[next[0]][next[1]]  = true;
//					q.add(new Water2(next[0], next[1]));
//					if(next[0] == 0) {
//						ans.add(next[2]);
//					}
//				}
//				
//			}
//			
//			
//		}
//		Collections.sort(ans);
//		for(int num : ans) {
//			System.out.printf("%d ", num);
//		}
//	}
//	
//	static void solve(int a, int b, int c) {
//		Queue<Water> q = new LinkedList<Water>();
//		q.add(new Water(a,b,c));
//		visited[a][b][c] = 1;
//		
//		while(!q.isEmpty()) {
//			Water h = q.remove();
//			
//			if(h.a == 0) {
//				ans.add(h.c);
//			}
//			
//			move1(q,h);
//			move2(q,h);
//			move3(q,h);	
//		}
//		Collections.sort(ans);
//		for(int num : ans) {
//			System.out.printf("%d ", num);
//		}
//		
//	}
//	static void move1(Queue<Water> q, Water w) {
//		int w1 = w.a;
//		int w2 = w.b;
//		int w3 = w.c;
//		if(w1 != 0) {
//			if(w1 < b-w2) {
//				if(visited[0][w1+w2][w3]==0) {
//					q.add(new Water(0,w1+w2,w3));
//					visited[0][w1+w2][w3] = 1;
//				}
//			}
//			else{
//				if(visited[w1+w2-b][b][w3]==0) {
//					q.add(new Water(w1+w2-b,b,w3));
//					visited[w1+w2-b][b][w3] = 1;
//				}
//			}
//			if(w1 < c-w3) {
//				if(visited[0][w2][w3+w1]==0) {
//					q.add(new Water(0,w2,w3+w1));
//					visited[0][w2][w3+w1]=1;
//				}
//			}else {
//				if(visited[w1+w3-c][w2][c]==0) {
//					q.add(new Water(w1+w3-c,w2,c));
//					visited[w1+w3-c][w2][c]= 1;
//				}
//			}
//		}
//	}
//	static void move2(Queue<Water> q, Water w) {
//		int w1 = w.a;
//		int w2 = w.b;
//		int w3 = w.c;
//		if(w2 != 0) {
//			if(w2 < a-w1) {
//				if(visited[w1+w2][0][w3]==0) {
//					q.add(new Water(w1+w2,0,w3));
//					visited[w1+w2][0][w3]=1;
//				}
//			}
//			else{
//				if(visited[a][w1+w2-a][w3]==0) {
//					q.add(new Water(a,w1+w2-a,w3));
//					visited[a][w1+w2-a][w3]=1;
//				}
//					
//			}
//			if(w2 < c-w3) {
//				if(visited[w1][0][w3+w2]==0) {
//					q.add(new Water(w1,0,w3+w2));
//					visited[w1][0][w3+w2]=1;
//				}
//					
//			}else {
//				if(visited[w1][w2+w3-c][c]==0) {
//					q.add(new Water(w1,w2+w3-c,c));
//					visited[w1][w2+w3-c][c] = 1;
//				}
//					
//			}
//		}
//	}
//	static void move3(Queue<Water> q, Water w) {
//		int w1 = w.a;
//		int w2 = w.b;
//		int w3 = w.c;
//		if(w3 != 0) {
//			if(w3 < a-w1) {
//				if(visited[w1+w3][w2][0] == 0) {
//					q.add(new Water(w1+w3,w2,0));
//					visited[w1+w3][w2][0] = 1;
//				}
//				
//			}
//			else{
//				if(visited[a][w2][w1+w3-a] == 0) {
//					q.add(new Water(a,w2,w1+w3-a));
//					visited[a][w2][w1+w3-a] = 1;
//				}
//				
//			}
//			if(w3 < b-w2) {
//				if(visited[w1][w2+w3][0] == 0) {
//					q.add(new Water(w1,w2+w3,0));
//					visited[w1][w2+w3][0] = 1;
//				}
//				
//			}else {
//				if(visited[w1][b][w2+w3-b] == 0) {
//					q.add(new Water(w1,b,w2+w3-b));
//					visited[w1][b][w2+w3-b] = 1;
//				}
//				
//			}
//		}
//	}
//}
//class Water2{
//	// 합이 일정하므로 굳이 세 개의 정수를 저장할 필요없음. 
//	int a;
//	int b;
//	Water2(int a, int b){
//		this.a = a;
//		this.b = b;
//	}
//}
//class Water{
//	int a;
//	int b;
//	int c;
//	Water(int a, int b, int c){
//		this.a = a;
//		this.b = b;
//		this.c = c;
//	}
//}

//public class BJ2251{
//	static int[][] visited = new int[201][201];
//	public static void main(String[] args) {
//		Scanner stdIn=  new Scanner(System.in);
//		int a = stdIn.nextInt();
//		int b = stdIn.nextInt();
//		int c = stdIn.nextInt();
//		solve(a,b,c);
//	}
//	static void spill(int f, int s, int t, Queue<W> q) {
//		if(visited[f][s] == 0) {
//			q.add(new W(f,s));
//			visited[f][s] = 1;
//		}
//	}
//	static void solve(int a, int b, int c) {
//		int sum= c;
//		Queue<W> q = new LinkedList<W>();
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//		q.add(new W(0,0));
//		
//		while(!q.isEmpty()) {
//			W h = q.remove();
//			int f = h.f;
//			int s = h.s;
//			int t = sum -f-s;
////			System.out.printf("%d %d %d \n", f,s,t);
//			if(f == 0 && !ans.contains(t)) ans.add(t);
//			
//			// f->s
//			if(f+s > b) {
//				int nf = f+s-b;
//				int ns = b; 
//				spill(nf,ns,t,q);
//			}else {
//				int nf = 0;
//				int ns = f+s;
//				spill(nf,ns,t,q);
//			}
//			// f<-s
//			if(f+s > a) {
//				int nf = a;
//				int ns = f+s-a; 
//				spill(nf,ns,t,q);
//				
//			}else {
//				int nf = f+s;
//				int ns = 0;
//				spill(nf,ns,t,q);
//			}
//			// f->t
//			if(f+t > c) {
//				int nf = f+t-c;
//				int nt = c; 
//				spill(nf,s,nt,q);
//			}else {
//				int nf = 0;
//				int nt = f+t;
//				spill(nf,s,nt,q);
//			}
//			// f<-t
//			if(f+t > a) {
//				int nf = a;
//				int nt = f+t-a; 
//				spill(nf,s,nt,q);
//				
//			}else {
//				int nf = f+t;
//				int nt = 0;
//				spill(nf,s,nt,q);
//			}
//			
//			// s->t
//			if(s+t > c) {
//				int ns = s+t-c;
//				int nt = c; 
//				spill(f,ns,nt,q);
//			}else {
//				int ns = 0;
//				int nt = s+t;
//				spill(f,ns,nt,q);
//			}
//			// s<-t
//			if(s+t > b) {
//				int ns = b;
//				int nt = s+t-b; 
//				spill(f,ns,nt,q);
//				
//			}else {
//				int ns = s+t;
//				int nt = 0;
//				spill(f,ns,nt,q);
//			}
//		}
//		Collections.sort(ans);
//		for(int i: ans) {
//			System.out.printf("%d ", i);
//		}
//		
//	}
//}
public class BJ2251{
	static int a;
	static int b;
	static int c;
	static int[][] visited = new int[201][201];
	static final int[] from = {0,0,1,1,2,2};
	static final int[] to = {1,2,0,2,0,1};
	public static void main(String[] args) {
		Scanner stdIn=  new Scanner(System.in);
		a = stdIn.nextInt();
		b = stdIn.nextInt();
		c = stdIn.nextInt();
		solve();
	}
	static void solve() {
		int sum= c;
		Queue<W> q = new LinkedList<W>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		q.add(new W(0,0));
		visited[0][0] = 1;
		while(!q.isEmpty()) {
			W h = q.remove();
			int f = h.f;
			int s = h.s;
			int t = sum-f-s;
//			System.out.println(f+ " " + s + " " + t);
			if(f == 0 && !ans.contains(t)) ans.add(t);
			spill(f,s,t, q);
		}
		Collections.sort(ans);
		for(int i: ans) {
			System.out.printf("%d ", i);
		}
		
	}
	static void spill(int f, int s, int t, Queue<W> q) {
		int[] cup = {a,b,c};
		
		for(int i=0;i<6;i++) {
			int[] next = {f,s,t};
				
			next[to[i]] += next[from[i]];
			next[from[i]] = 0;
			
			if(next[to[i]] > cup[to[i]]) {
				int temp =  next[to[i]] - cup[to[i]];
				next[from[i]] += temp;
				next[to[i]]-=temp;
			}
			if((visited[next[0]][next[1]] == 0)) {
				q.add(new W(next[0],next[1]));
				visited[next[0]][next[1]] = 1;
			}
		}
		
		
	}
}
class W{
	int f;
	int s;
	W(int f, int s){
		this.f = f;
		this.s =s;
	}
}