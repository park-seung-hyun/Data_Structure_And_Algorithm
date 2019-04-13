// 15649번
// N과 M (1)
// 재귀 호출 

//import java.util.Scanner;
//public class BJ15649 {
//	static int[] ans = new int[10];
//	static boolean[] check ; // 방문 여부 -> 중복 불가이므로 
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		check = new boolean[n]; 
//		solve(0,m,n);
//	}
//	static void solve(int index, int m, int n) {
//		if(index == m) {
//			for(int i=0;i<m;i++) {
//				System.out.printf("%d ",ans[i]);
//			}
//			System.out.println();
//			return;
//		}
//		for(int i=0;i<n;i++) {
//			if(check[i] == false) {
//				ans[index] = i+1;
//				check[i] = true;
//				solve(index+1,m,n);
//				check[i] = false;
//			}
//		}
//	}
//}

import java.util.Scanner;
public class BJ15649{
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ar = new int[m];
		visited = new int[n];
		go(0,ar,n,m);
	}
	static void go(int id, int[] ar, int n, int m) {
		if(id == m) {
			for(int i : ar)
				System.out.printf("%d ", i);
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(visited[i-1] == 1) continue;
			ar[id] =i;
			visited[i-1] = 1;
			go(id+1,ar,n,m);
			visited[i-1] = 0;
		}
	}
}