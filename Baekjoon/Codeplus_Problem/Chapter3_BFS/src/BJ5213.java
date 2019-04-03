import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ5213 {
	static Tile[] ts;
	static int[] visited;
	static int[] track;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n= stdIn.nextInt();
		visited = new int[n*n-n/2+1];
		track = new int[n*n-n/2+1];
		ts = new Tile[n*n-n/2+1];
		
		for(int i=1;i<= n*n-n/2;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			ts[i]= new Tile(a,b);
		}
		solve(n);
	}
	static void solve(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = 1;
		track[1] = -1;
		while(!q.isEmpty()) {
			int h = q.remove();
			if(h == n*n-n/2) {
				break;
			}
			Tile t = ts[h];
			int f = t.f;
			int s = t.s;
			ArrayList<Integer> fc = getFirstConnected(h,n);
			for(int i : fc) {
				if(visited[i] == 0 && ts[h].f == ts[i].s) {
					visited[i] = visited[h] + 1;
					track[i] = h;
					q.add(i);
				}
			}
			ArrayList<Integer> sc = getSecondConnected(h,n);
			for(int i : sc) {
				if(visited[i] == 0 && ts[h].s == ts[i].f) {
					visited[i] = visited[h] + 1;
					track[i] = h;
					q.add(i);
				}
			}
			
		}
		int i = n*n-n/2;
		for(i= n*n-n/2;i>0;i--) {
			if(visited[i] != 0) break;
		}
		System.out.println(visited[i]);
		track(i);
	}
	static void track(int n) {
		if(n == -1) return;
		track(track[n]);
		System.out.printf("%d ",n);
	}
	static ArrayList<Integer> getFirstConnected(int h, int n){
		ArrayList<Integer> connect = new ArrayList<Integer>();
		int[] dx = {-n, -1, n-1};
		for(int i=0;i<3;i++) {
			if((i==0 || i==2) && (h-1)%(2*n-1) != 0 && h+dx[i] > 0 && h+dx[i] <= n*n-n/2)
				connect.add(h+dx[i]);
			if(i==1 && (h-1)%(2*n-1) != 0 && (h-(n+1)) % (2*n-1) !=0)
				connect.add(h+dx[i]);
		}
		return connect;
	}
	static ArrayList<Integer> getSecondConnected(int h, int n){
		ArrayList<Integer> connect = new ArrayList<Integer>();
		int[] dx = {1-n, 1, n};
		for(int i=0;i<3;i++) {
			if((i==0 || i==2) && (h-n)%(2*n-1) != 0 && h+dx[i] > 0 && h+dx[i] <= n*n-n/2)
				connect.add(h+dx[i]);
			if(i==1 && (h-n)%(2*n-1) != 0 && h % (2*n-1) !=0)
				connect.add(h+dx[i]);
		}
		
		return connect;
	}
}
class Tile{
	int f;
	int s;
	Tile(int f, int s){
		this.f = f;
		this.s = s;
	}
}
