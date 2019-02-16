// 15663번
// N과 M (9)
// 재귀 호출 
// cnt 만드는 법 다시 보기. 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15663 {
	static int[] cnt = new int[10];
	static int[] ans = new int[10];
	static int[] num = new int[10];
	public static void main (String[] args) {
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
        for (int i=1; i<n; i++) {
            if (x == ar[i]) {
                c += 1;
            } else {
            		num[k] = x;
                cnt[k] = c;
                k += 1;
                x = ar[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
		solve(0,n,m,ar);
	}
	static void solve(int index, int n, int m, int[] ar) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.printf("%d ",num[ans[i]]);
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(cnt[i]>0) {
				cnt[i]-=1;
				ans[index] = i;
				solve(index+1, n, m, ar);
				cnt[i]+=1;
			}
		}
	}
}
