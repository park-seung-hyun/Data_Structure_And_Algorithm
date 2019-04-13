// 10819번
// 차이를 최대로  
// 첫 수열부터 마지막 수열까지 다음 수열의 반복
// 1~N 의 모든 순열의 개수는 N!
// 다음 순열 과정 N
// 전체 시간복잡도 O(N*N!)
// N이 8까지 이므로 모든 경우의 수를 돌려보기 충분함. 

//import java.util.Arrays;
//import java.util.Scanner;
//public class BJ10819 {
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int[] ar = new int[n];
//		for(int i=0;i<n;i++) {
//			ar[i] = stdIn.nextInt();
//		}
//		System.out.println(solve(ar));
//	}
//	static int solve(int[] ar) {
//		Arrays.sort(ar);
//		int max = 0;
//		while(true) {
//			
//			int c = calculate(ar);
//			if(max <= c)
//				max = c;
//			
//			if(nextPermutation(ar) == false) {
//				break;
//			}
//		}
//		return max;
//	}
//	static int calculate(int[] ar) {
//		int sum = 0;
//		for(int i=0;i<ar.length-1;i++) {
//			sum += Math.abs(ar[i]-ar[i+1]);
//		}
//		return sum;
//	}
//	static boolean nextPermutation(int[] ar) {
//		int n = ar.length;
//		int i = n-1;
//		while(i>0 && ar[i-1]>=ar[i]) i-=1;
//		if(i==0)return false;
//		int j = n-1;
//		while(ar[i-1]>=ar[j]) j-=1;
//		swap(ar, i-1, j);
//		j = n-1;
//		while(i<j) {
//			swap(ar, i,j);
//			i++;
//			j--;
//		}
//		return true;
//	}
//	static void swap(int[] ar, int id1, int id2) {
//		int t = ar[id1];
//		ar[id1] = ar[id2];
//		ar[id2] = t;
//	}
//}

import java.util.Arrays;
import java.util.Scanner;
public class BJ10819{
	static int[] ar;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		for(int i=0;i<n;i++) ar[i] = stdIn.nextInt();
		Arrays.sort(ar);
		int max = 0;
		do {
			int sum =0;
			for(int i=0;i<n-1;i++) {
				sum += (Math.abs(ar[i] - ar[i+1]));
			}
			if(max < sum) max = sum;
		}while(np(ar));
		System.out.println(max);
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] >= ar[i]) i--;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1] >= ar[j]) j--;
		swap(ar, i-1,j);
		j = n-1;
		while(i<j) {
			swap(ar, i,j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	
}