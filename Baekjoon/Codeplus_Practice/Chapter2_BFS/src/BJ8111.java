// 8111번 
// 0과1   
// BFS
// 나머지 원리 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ8111 {	
	static int[] visited;
	static int[] track;
	static int[] number;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			visited = new int[n]; // 0 ~ n-1 
			track = new int[n];
			number = new int[n];
			solve(n);
			System.out.println();
		}
	}
	static void solve(int n) {
		
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(1%n);
		visited[1%n] = 1;
		track[1%n] = -1;
		number[1%n] = 1;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			System.out.println(h);
			for(int i=0;i<=1;i++) {
				int newNum = ((h*10) + i)%n; // Mod 분배 법칙 
				if(visited[newNum] == 0) {
					q.add(newNum);
					visited[newNum] = 1;
					track[newNum] = h;
					number[newNum] = i;
				}
			}
		}
		if(visited[0] == 0) {
			System.out.println("BRAK");
		}else {
			track(0);
		}
		
	}
	static void track(int n) {
		if(n == -1) return;
		track(track[n]);
		System.out.printf("%d",number[n]);
	}
}
