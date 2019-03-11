// 2251번 
// 물통 
// BFS
// 굳이 3차원 배열 안써도됨.
// 물 손실 없으므로 두 개의 정보로 가능.

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2251 {
	static int a;
	static int b;
	static int c;
	static int[][][] visited;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		a = stdIn.nextInt();
		b = stdIn.nextInt();
		c = stdIn.nextInt();
		visited = new int[a+1][b+1][c+1];
		solve(0,0,c);
	}
	static void solve(int a, int b, int c) {
		Queue<Water> q = new LinkedList<Water>();
		q.add(new Water(a,b,c));
		visited[a][b][c] = 1;
		
		while(!q.isEmpty()) {
			Water h = q.remove();
			
			if(h.a == 0) {
				ans.add(h.c);
			}
			
			move1(q,h);
			move2(q,h);
			move3(q,h);	
		}
		Collections.sort(ans);
		for(int num : ans) {
			System.out.printf("%d ", num);
		}
		
	}
	static void move1(Queue<Water> q, Water w) {
		int w1 = w.a;
		int w2 = w.b;
		int w3 = w.c;
		if(w1 != 0) {
			if(w1 < b-w2) {
				if(visited[0][w1+w2][w3]==0) {
					q.add(new Water(0,w1+w2,w3));
					visited[0][w1+w2][w3] = 1;
				}
			}
			else{
				if(visited[w1+w2-b][b][w3]==0) {
					q.add(new Water(w1+w2-b,b,w3));
					visited[w1+w2-b][b][w3] = 1;
				}
			}
			if(w1 < c-w3) {
				if(visited[0][w2][w3+w1]==0) {
					q.add(new Water(0,w2,w3+w1));
					visited[0][w2][w3+w1]=1;
				}
			}else {
				if(visited[w1+w3-c][w2][c]==0) {
					q.add(new Water(w1+w3-c,w2,c));
					visited[w1+w3-c][w2][c]= 1;
				}
			}
		}
	}
	static void move2(Queue<Water> q, Water w) {
		int w1 = w.a;
		int w2 = w.b;
		int w3 = w.c;
		if(w2 != 0) {
			if(w2 < a-w1) {
				if(visited[w1+w2][0][w3]==0) {
					q.add(new Water(w1+w2,0,w3));
					visited[w1+w2][0][w3]=1;
				}
			}
			else{
				if(visited[a][w1+w2-a][w3]==0) {
					q.add(new Water(a,w1+w2-a,w3));
					visited[a][w1+w2-a][w3]=1;
				}
					
			}
			if(w2 < c-w3) {
				if(visited[w1][0][w3+w2]==0) {
					q.add(new Water(w1,0,w3+w2));
					visited[w1][0][w3+w2]=1;
				}
					
			}else {
				if(visited[w1][w2+w3-c][c]==0) {
					q.add(new Water(w1,w2+w3-c,c));
					visited[w1][w2+w3-c][c] = 1;
				}
					
			}
		}
	}
	static void move3(Queue<Water> q, Water w) {
		int w1 = w.a;
		int w2 = w.b;
		int w3 = w.c;
		if(w3 != 0) {
			if(w3 < a-w1) {
				if(visited[w1+w3][w2][0] == 0) {
					q.add(new Water(w1+w3,w2,0));
					visited[w1+w3][w2][0] = 1;
				}
				
			}
			else{
				if(visited[a][w2][w1+w3-a] == 0) {
					q.add(new Water(a,w2,w1+w3-a));
					visited[a][w2][w1+w3-a] = 1;
				}
				
			}
			if(w3 < b-w2) {
				if(visited[w1][w2+w3][0] == 0) {
					q.add(new Water(w1,w2+w3,0));
					visited[w1][w2+w3][0] = 1;
				}
				
			}else {
				if(visited[w1][b][w2+w3-b] == 0) {
					q.add(new Water(w1,b,w2+w3-b));
					visited[w1][b][w2+w3-b] = 1;
				}
				
			}
		}
	}
}
class Water{
	int a;
	int b;
	int c;
	Water(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
