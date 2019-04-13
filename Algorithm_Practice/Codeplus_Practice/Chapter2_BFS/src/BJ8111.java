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
					track[newNum] = h; // 추적 
					number[newNum] = i; // 해당 자리의 숫자 
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

//public class BJ8111{
//	static int[] visited;
//	static int[] track;
//	static int[] number;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int n = stdIn.nextInt();
//			visited = new int[n];
//			track = new int[n];
//			number = new int[n];
//			solve(n);
//		}
//	}
//	static void solve(int n) {
//		Queue<Num> q= new LinkedList<Num>();
//		q.add(new Num(1%n,"1"));
//		visited[1%n] = 1;
//		track[1%n] = -1;
//		number[1%n] = 1;
//		while(!q.isEmpty()) {
//			Num r = q.remove();
//			int h = r.n;
//			String s = r.s;
//			if(h == 0) {
//				track(h);
//				System.out.println();
//				return;
//			}
//			for(int i=0;i<2;i++) {
//				int newh = ((h*10) + i) % n;
//				if(visited[newh] == 0) {
//					q.add(new Num(newh, s + i));
//					visited[newh] = 1;
//					track[newh] = h;
//					number[newh] = i;
//				}
//			}
//		}
//		System.out.println("BRAK");
//	}
//	static void track(int n) {
//		if(n == -1) return;
//		track(track[n]);
//		System.out.printf("%d", number[n]);
//	}
//}
//
//class Num{
//	int n;
//	String s;
//	Num(int n, String s){
//		this.n= n;
//		this.s = s;
//	}
//}