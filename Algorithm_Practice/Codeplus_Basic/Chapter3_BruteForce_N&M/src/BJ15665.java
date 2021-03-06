// 15665번
// N과 M (11)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15665 {
	static int[] num = new int[10];
	static int[] cnt = new int[10];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		Arrays.sort(ar);
		
		int k = 0;
		int x = ar[0];
		int c = 1;
		for(int i=1;i<n;i++) {
			if(x == ar[i]) {
				c++;
			}else {
				cnt[k] = c;
				num[k] = x;
				x = ar[i];
				k++;
				c = 1;
			}
		}
		num[k] = x;
		cnt[k] = c;
		solve(0,n,m, "");
	}
	static void solve(int index, int n, int m, String s) {
		if(index == m) {
			System.out.println(s);
			return;
		}
		for(int i=0;i<n;i++) {
			if(num[i]>0) {
				solve(index+1, n,m,s+num[i]+" ");
			}
		}
	}
}
