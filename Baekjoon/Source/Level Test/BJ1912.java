// 1912번  
// 연속합 
// 동적 계획법 (Dynamic Programming)

import java.util.Scanner;
public class BJ1912 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ns = new int[n];
		for(int i=0;i<n;i++){
			ns[i] = stdIn.nextInt();
		}
//		System.out.print(bestSum(ns));
		System.out.print(dp(ns));
	}
	static int bestSum(int[] arr) {
		int best = -1000;
		for(int i=0;i<arr.length;i++) {
			int j = i;
			int sum = 0;
			while(sum>=-1000 && j<arr.length) {
				sum+=arr[j];
				j++;
				if(sum>best) {
					best = sum;
				}
			}
		}
		return best;
	}
	static int dp (int[] arr) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(sum[i-1]+arr[i]>arr[i])
				sum[i] = sum[i-1]+arr[i];
			else
				sum[i] = arr[i];
		}
		
		int max = sum[0];
		for(int j=0;j<sum.length;j++) {
			if(max<sum[j])
				max  = sum[j];
		}
		
		return max;
	}
}
