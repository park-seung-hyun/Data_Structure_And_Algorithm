// 2467번 (복습) 
// 용액 
// l, r 인덱스를 사용하여 탐색 

import java.util.Scanner;
public class Re_BJ2467 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(ar);
	}
	static void solve(int[] ar) {
		int a = 0;
		int b = 0;
		
		int i = 0;
		int j = ar.length-1;
		int ans = 2000000000;
		while(i<j) {
			if(Math.abs(ar[i]+ar[j]) < ans) {
				ans = Math.abs(ar[i]+ar[j]);
				a = ar[i];
				b = ar[j];
			}
			
			if(ar[i]+ar[j]>0) {
				j--;
			}else if(ar[i]+ar[j]<0) {
				i++;
			}else {
				break;
			}
		}
		System.out.printf("%d %d", a,b);
	}
}
