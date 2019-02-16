// 15664번
// N과 M (10)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15664 {
	static int[] num = new int[10];
	static int[] cnt = new int[10]; 
	static int[] ans = new int[10];
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
				num[k] = x;
				cnt[k] = c;
				k++;
				c = 1;
				x = ar[i];
			}
		}
		num[k] = x;
        cnt[k] = c;
		solve(0,0,n,m);
	}
	static void solve(int index,int start, int n, int m) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ", num[ans[i]]);
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {
			if(cnt[i]>0) {
				cnt[i] --;
				ans[index] = i;
				solve(index+1, i, n, m);
				cnt[i]++;
			}
		}
	}
}
