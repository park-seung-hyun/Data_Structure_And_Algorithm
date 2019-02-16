// 15658번
// 연산자 끼워넣기 (2)
// 재귀 호출 

import java.util.Scanner;
public class BJ15658 {
	static int max = -1000000001;
	static int min = 1000000001;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		int[] cnt = new int[4];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		for(int i=0;i<4;i++) {
			cnt[i] = stdIn.nextInt();
		}
		solve(ar,1, ar[0], cnt[0],cnt[1],cnt[2],cnt[3]);
		System.out.println(max);
		System.out.println(min);
	}
	static void solve(int[] ar, int i, int sum, int p, int mi, int mu, int d) {
		if(i==ar.length) {
			if(max<sum)
				max = sum;
			if(min>sum)
				min = sum;
			return;
		}
		if(p>0) 
			solve(ar, i+1, sum+ar[i], p-1,mi,mu,d);
		if(mi>0) 
			solve(ar, i+1, sum-ar[i], p,mi-1,mu,d);
		if(mu>0) 
			solve(ar, i+1, sum*ar[i], p,mi,mu-1,d);
		if(d>0) 
			solve(ar, i+1, sum/ar[i], p,mi,mu,d-1);
		
	}
}
