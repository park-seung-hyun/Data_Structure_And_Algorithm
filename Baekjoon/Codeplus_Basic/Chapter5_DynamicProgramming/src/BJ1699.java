// 1699번  
// 제곱수의 합 
// Dynamic Programming (Bottom-Up) -> solve1
// bfs -> solve2

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1699 {
	static int[] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		d = new int[n+1];
		solve2(n);
	}
	static void solve(int n) {
		
		for(int i=1;i<=n;i++) {
			d[i] = i;
			for(int j=1;j*j<=i;j++) {
				if(d[i] > d[i-j*j]+1)
					d[i] = d[i-j*j] + 1;
			}
		}
		System.out.println(d[n]);
	}
	static void solve2(int n) {
		Arrays.fill(d, -1);
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(n);
		d[n] = 0;
		while(!q.isEmpty()) {
			int h = q.remove();
			for(int i=1;i*i<=h;i++) {
				if(d[h-i*i] == -1) {
					q.add(h-i*i);
					d[h-i*i] = d[h] + 1; 
				}
			}
		}
		System.out.println(d[0]);

	}
}
