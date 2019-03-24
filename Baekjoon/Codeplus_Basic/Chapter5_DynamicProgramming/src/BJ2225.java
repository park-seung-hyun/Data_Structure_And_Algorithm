// 2225번  
// 합분해 
// Dynamic Programming (Bottom-Up) -> solve1
// Dynamic Programming (Bottom-Up) 시간 복잡도 감소 -> solve2
// bfs -> solve3 -> 메모리 초과 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2225 {
	static long[][] d;
	static final long mod = 1000000000L;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		d = new long[n+1][k+1];
		solve2(n,k);
	}
	static void solve(int n, int k) {
		for(int i=0;i<=n;i++) d[i][1] = 1;
		
		for(int i=0;i<=n;i++) {
			for(int m=2;m<=k;m++) {
				for(int j=0;j<=i;j++) {
					d[i][m] += d[i-j][m-1];
				}
				d[i][m] %= mod;
			}
		}
		System.out.println(d[n][k]);
	}
	static void solve2(int n, int k) {
		// 초기화 까다롭..
		for(int i=0;i<=n;i++) d[i][1] = 1;
		for(int i=0;i<=k;i++) d[0][i] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int m=2;m<=k;m++) {
				d[i][m] = d[i][m-1] + d[i-1][m];
				d[i][m] %= mod;
			}
		}
		System.out.println(d[n][k]);
	}
	// bfs
	// 실패..
	static void solve3(int n, int k) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(n,1));
		int ans = 0;
		while(!q.isEmpty()) {
			Pair h = q.remove();
			int num = h.n;
			int cnt = h.c;
			if(cnt < k) {
				for(int i=0;i<=num;i++) {
					if(num-i>=0)
						q.add(new Pair(num-i, cnt+1));
				}
			}else if(k==cnt){
				ans++;
			}
			h = null;
		}
		System.out.println(ans);
	}
}
class Pair{
	int n;
	int c;
	Pair(int n, int c){
		this.n = n;
		this.c = c;
	}
}
//public class BJ2225{
//	static long[][] d;
//	static final long mod = 1000000000;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int k = stdIn.nextInt();
//		d = new long[n+1][k+1];
//		solve2(n,k);
//	}
//	static void solve(int n, int k) {
//		for(int i=0;i<=n;i++) d[i][1] = 1;
//		for(int i=2;i<=k;i++) {
//			for(int j=0;j<=n;j++) {
//				long sum =0;
//				for(int m=0;m<=j;m++) {
//					sum += d[j-m][i-1];
//					sum %= mod;
//				}
//				d[j][i] = sum;
//			}
//		}
//		System.out.println(d[n][k]);;
//	}
//	static void solve2(int n, int k) {
//		for(int i=0;i<=n;i++) d[i][1] = 1;
//		for(int i=0;i<=k;i++) d[0][i] = 1;
//		
//		for(int i=2;i<=k;i++) {
//			for(int j=1;j<=n;j++) {
//				d[j][i] = d[j-1][i] + d[j][i-1];
//				d[j][i] %= mod;
//			}
//		}
//		
//		System.out.println(d[n][k]);;
//	}
//}