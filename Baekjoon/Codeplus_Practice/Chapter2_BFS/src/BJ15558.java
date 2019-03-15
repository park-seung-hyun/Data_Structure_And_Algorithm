// 15558번 
// 점프 게임   
// BFS
// 여기서 time -> level 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ15558 {
	static char[] c1;
	static char[] c2;
	static int[] visited;
	static int[] visited2;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k= stdIn.nextInt();
		c1 = new char[n];
		c2 = new char[n];
		stdIn.nextLine();
		String s1 = stdIn.nextLine();
		for(int i=0;i<n;i++) {
			c1[i] = s1.charAt(i);
		}
		String s2 = stdIn.nextLine();
		for(int i=0;i<n;i++) {
			c2[i] = s2.charAt(i);
		}
		visited = new int[n];
		visited2 = new int[n];
		solve(n,k);
	}
	static void solve( int n, int k) {
		Queue<Jump> q = new LinkedList<Jump>();
		q.add(new Jump(0,1,0));
		visited[0] = 1;
		
		while(!q.isEmpty()) {
			Jump h = q.remove();
			int x = h.x;
			int num = h.num;
			int time = h.time;

			if(time >= n) break;
			
			if(x+1 >= n || x+k >= n) {
				System.out.println(1);
				return;
			}
			
			if(num == 1) {
				
				// 방문 여부 꼭 따지기 
				if(x-1>=0 && x-1 > time && c1[x-1] == '1' && visited[x-1] == 0) {
					q.add(new Jump(x-1, 1, time + 1));
					visited[x-1] = 1;
				}
				if(x+1<n && x+1 > time && c1[x+1] == '1' && visited[x+1] == 0) {
					q.add(new Jump(x+1, 1, time + 1));
					visited[x+1] = 1;
				}
				if(x+k<n && x+k > time && c2[x+k] == '1' && visited2[x+k] == 0) {
					q.add(new Jump(x+k, 2, time + 1));
					visited2[x+k] = 1;
				}
				
			}else {
				
				if(x-1>=0 && x-1 > time && c2[x-1] == '1' && visited2[x-1] == 0) {
					q.add(new Jump(x-1, 2, time + 1));
					visited2[x-1] = 1;
				}
				if(x+1<n && x+1 > time && c2[x+1] == '1' && visited2[x+1] == 0) {
					q.add(new Jump(x+1, 2, time + 1));
					visited2[x+1] = 1;
				}
				if(x+k<n && x+k > time && c1[x+k] == '1' && visited[x+k] == 0) {
					q.add(new Jump(x+k, 1, time + 1));
					visited[x+k] = 1;
				}
			}			
		
		}
		System.out.println(0);
	}
}
class Jump{
	int x;
	int num;
	int time;
	Jump(int x, int num, int time){
		this.x = x;
		this.num = num;
		this.time = time;
	}
}
