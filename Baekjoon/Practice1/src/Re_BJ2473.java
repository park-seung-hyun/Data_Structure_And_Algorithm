// 2473번 (복습) 
// 세 용액 
// l, r 인덱스를 사용하여 탐색 

import java.util.Arrays;
import java.util.Scanner;
public class Re_BJ2473 {
	static long[] ar;
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		ar = new long[n];

		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve2(n);
		
	}
	static void solve2(int n) {
		Arrays.sort(ar);
		
		long a = 0;
		long b = 0;
		long c = 0;
		
		long min = 3000000000L;
		
		for(int i=0;i<n-2;i++) {
			
			long s = ar[i];
	
			int l = i+1;
			int r = n-1;

			boolean flag = true;
			while(l<r) {
				if(min > Math.abs(s+ar[l]+ar[r])){
					a = s;
					b = ar[l];
					c = ar[r];
					min = Math.abs(s+ar[l]+ar[r]);
				}
				
				if(s+ar[l]+ar[r] < 0) {
					l++;
				}else if(s+ar[l]+ar[r] > 0) {
					r--;
				}else {
					a = s;
					b = ar[l];
					c = ar[r];
					flag = false;
					break;
				}
			}
			if(flag == false) {
				break;
			}	
		}
		System.out.printf("%d %d %d",a,b,c);
	}

}
