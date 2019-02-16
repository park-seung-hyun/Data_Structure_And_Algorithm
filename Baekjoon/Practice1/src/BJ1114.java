import java.util.Arrays;
import java.util.Scanner;

public class BJ1114 {
	static long[] ar;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		long L = stdIn.nextInt();
		long K = stdIn.nextInt();
		long C = stdIn.nextInt();
		ar = new long[10010];
		for(int i=1;i<=K;i++) {
			ar[i] = stdIn.nextInt();
		}
		ar[0] = 0;
		ar[(int) ++K] = L;
		Arrays.sort(ar,0,(int) (K+1));
//		System.out.println(Arrays.toString(ar));
		cutTree(L,K,C);
		
	}
	static void cutTree(long l, long k, long c) {
		
		long left = 0;
		long right = 2000000001;
		long ans = 2000000000;
		
		while(left<=right) {
			long mid = (left + right)/2;
			if(isPossible(mid, k, c)) {
//				System.out.println(mid);
				if(ans > mid)
					ans = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.printf("%d %d", ans, findIndex(ans, k,c));
		
	}
	static long findIndex(long ans, long K, long c) {
		long dif = 0;
		long cnt = 0;
		long id = K;
		for(long k=K-1;k>=0;k--) {
			if(dif>ans) {
				cnt++;
				dif = ar[(int) (k+1)] - ar[(int) k];
				id = k+1;
			}
		}
		if(cnt<c) id = 1;
		return ar[(int) id];
	}
	static boolean isPossible(long mid, long K, long c) {
		long k;
		long cnt = 0;
		long dif = 0;
		for(k = K-1;k>=0;k--) {
			dif += ar[(int) (k+1)] - ar[(int) k];
			if(dif>mid) {
				dif = ar[(int) (k+1)] - ar[(int) k];
				cnt++;
				if(dif>mid) {
					cnt = c+1;
					break;
				}
			}
		}
		return cnt<=c;
	}
}
