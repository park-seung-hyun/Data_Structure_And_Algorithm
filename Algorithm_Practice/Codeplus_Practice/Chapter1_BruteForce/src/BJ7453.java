import java.util.Arrays;
import java.util.Scanner;

public class BJ7453 {
	static long[] A;
	static long[] B;
	static long[] C;
	static long[] D;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		A = new long[n];
		B = new long[n];
		C = new long[n];
		D = new long[n];
		for(int i=0;i<n;i++) {
			A[i] = stdIn.nextLong();
			B[i] = stdIn.nextLong();
			C[i] = stdIn.nextLong();
			D[i] = stdIn.nextLong();
		}
		
		long[] AB = new long[n*n];
		long[] CD = new long[n*n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				AB[i*n+j] = A[i] + B[j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				CD[i*n+j] = C[i] + D[j];
			}
		}
		Arrays.sort(AB);
		long cnt = 0;
		for(int i=0;i<n*n;i++) {
			long target = -1*CD[i];
			int l = 0;
			int r = n*n;
			int m = 0;
			while(l<r) {
				m = (l+r)/2;
				if(AB[m] < target) {
					l = m+1;
				}else {
					r = m;
				}
			}
			int l2 = 0;
			int r2 = n*n;
			int m2 = 0;
			while(l2<r2) {
				m2 = (l2+r2)/2;
				if(AB[m2] <= target) {
					l2 = m2 +1;
				}else {
					r2 = m2;
				}
			}
			cnt += (l2-l);
		}
		System.out.println(cnt);
	}
}
