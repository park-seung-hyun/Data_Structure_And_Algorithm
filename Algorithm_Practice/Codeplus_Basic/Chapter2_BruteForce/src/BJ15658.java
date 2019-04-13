// 15658번
// 연산자 끼워넣기 (2)
// 재귀 호출 

//import java.util.Scanner;
//public class BJ15658 {
//	static int max = -1000000001;
//	static int min = 1000000001;
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int[] ar = new int[n];
//		int[] cnt = new int[4];
//		for(int i=0;i<n;i++) {
//			ar[i] = stdIn.nextInt();
//		}
//		for(int i=0;i<4;i++) {
//			cnt[i] = stdIn.nextInt();
//		}
//		solve(ar,1, ar[0], cnt[0],cnt[1],cnt[2],cnt[3]);
//		System.out.println(max);
//		System.out.println(min);
//	}
//	static void solve(int[] ar, int i, int sum, int p, int mi, int mu, int d) {
//		if(i==ar.length) {
//			if(max<sum)
//				max = sum;
//			if(min>sum)
//				min = sum;
//			return;
//		}
//		if(p>0) 
//			solve(ar, i+1, sum+ar[i], p-1,mi,mu,d);
//		if(mi>0) 
//			solve(ar, i+1, sum-ar[i], p,mi-1,mu,d);
//		if(mu>0) 
//			solve(ar, i+1, sum*ar[i], p,mi,mu-1,d);
//		if(d>0) 
//			solve(ar, i+1, sum/ar[i], p,mi,mu,d-1);
//		
//	}
//}
import java.util.Scanner;
public class BJ15658{
	static int[] num;
	static int N = 0;
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		N = stdIn.nextInt();
		num = new int[N];
		for(int i=0;i<N;i++) num[i] = stdIn.nextInt();
		int pl = stdIn.nextInt();
		int mi = stdIn.nextInt();
		int mu = stdIn.nextInt();
		int di = stdIn.nextInt();		
		go(num[0],0,pl,mi,mu,di);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	static void go(int n, int index, int pl, int mi, int mu, int di) {
		
		if(index == N-1) {
			if(MIN > n) MIN = n;
			if(MAX < n) MAX = n;
			return;
		}
		if(pl>0)
			go(n + num[index+1], index +1, pl-1, mi,mu,di);
		if(mi>0)
			go(n - num[index+1], index +1, pl, mi-1,mu,di);
		if(mu>0)
			go(n * num[index+1], index +1, pl, mi,mu-1,di);
		if(di>0)
			go(n / num[index+1], index +1, pl, mi,mu,di-1);
	}
}