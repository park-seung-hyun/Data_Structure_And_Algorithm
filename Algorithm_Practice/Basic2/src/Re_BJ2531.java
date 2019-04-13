// 2531번 (복습)
// 회전 초밥
// Sliding Window 

import java.util.Scanner;
public class Re_BJ2531 {
	static int[] dishes;
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int d = stdIn.nextInt();
		int k = stdIn.nextInt();
		int c = stdIn.nextInt();
		dishes = new int[n];
		visited = new int[d+1];
		for(int i=0;i<n;i++) {
			dishes[i] = stdIn.nextInt();
		}
		solve(n,d,k,c);
	}
	static void solve(int n, int d, int k, int c) {
		int max = 0;
		
		visited[c]++;
		
		int l = 0;
		int r = k-1;
		
		for(int i=l;i<=r;i++) {
			visited[dishes[i]]++;
		}
		
		while(true) {
			int cnt = count();
			if(cnt>max)
				max = cnt;
			
			visited[dishes[l]]--;
			l++;
			r++;
			if(r==n)
				r=0;
			visited[dishes[r]]++;
			
			if(l== n)
				break;
		}
		System.out.println(max);
	}
	static int count() {
		int sum =0;
		for(int i=0;i<visited.length;i++) {
			if(visited[i] >= 1)
				sum++;
		}
		return sum;
	}
	
}
