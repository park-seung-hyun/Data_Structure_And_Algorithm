// 14002번  
// 가장 긴 증가하는 부분 수열 4
// LIS(Longest Increasing Subsequence)

import java.util.Arrays;
import java.util.Scanner;
public class BJ14002 {
	static int[] ar;
	static int[] d;
	static int[] v;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		d = new int[n];
		v = new int[n];		
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		Arrays.fill(v, -1);
		solve(n);
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(v));
	}
	static void solve(int n) {
		for(int i=0;i<n;i++) d[i] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(ar[i]>ar[j] && d[i]< d[j]+1) {
					d[i] = d[j] +1;
					v[i] = j;
				}
			}
		}
		
		int maxIndex = 0;
		for(int i=0;i<n;i++) {
			if(d[maxIndex]<d[i])
				maxIndex = i;
		}
		System.out.println(d[maxIndex]);
		printAr(maxIndex);
		System.out.println();
	}
	static void printAr(int id) {
		if(id == -1) return; // id == 0 안됨 -> 모든 숫자가 같을 때 0 자체가 없으므로 -1로 배열 접근 (런타임 에러)
		printAr(v[id]);
		System.out.printf("%d ",ar[id]);
		return;
	}
}
