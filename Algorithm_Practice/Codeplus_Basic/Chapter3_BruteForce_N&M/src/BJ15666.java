// 15666번
// N과 M (12)
// 재귀 호출 

import java.util.Arrays;
import java.util.Scanner;
public class BJ15666 {
	static int num_length=0;
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
		for(int i=1;i<n;i++) {
			if(x == ar[i]) {
			}else {
				num[k] = x;
				x = ar[i];
				k++;
			}
		}
		num[k] = x;
		num_length = k+1;
		
//		solve(0,0,n,m,"");
		solve2(0,0,n,m);
	}
	static void solve(int index,int start, int n ,int m, String s) {
		if(index == m) {
			System.out.println(s);
			return ;
		}
		for(int i = start;i<n;i++) {
			if(num[i]>0) {
				solve(index+1, i, n, m, s+num[i]+" ");
			}
		}
	}
	static void solve2(int index, int selected, int n, int m) {
		if(selected == m) {
			for(int i=0;i<num_length;i++) {
				for(int j=0;j<cnt[i];j++) {
					System.out.printf("%d ",num[i]);	
				}
			}
			System.out.println();
			return;
		}
		if(index == num_length) {
			return;
		}
		for(int i = m - selected;i>=0;i--) {
			cnt[index] = i;
			solve2(index+1, selected + i, n, m);
		}
		
	}
	
}
