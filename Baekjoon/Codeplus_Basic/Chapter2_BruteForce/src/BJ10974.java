// 10974번
// 모든 순열  
// 첫 수열부터 마지막 수열까지 다음 수열의 반복
// 1~N 의 모든 순열의 개수는 N!
// 다음 순열 과정 N
// 전체 시간복잡도 O(N*N!)

import java.util.Scanner;
public class BJ10974 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		permutation(n);
	}
	static void permutation(int n) {
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = i+1;
		}
		while(true) {
			printArr(ar);
			if(nextPermutation(ar) == false) {
				break;
			}
		}
	}
	static void printArr(int[] ar) {
		for(int i=0;i<ar.length;i++) {
			System.out.printf("%d ",ar[i]);
		}
		System.out.println();
	}
	static boolean nextPermutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] >= ar[i]) i-=1;
		if(i<=0) return false;
		int j = n-1;
		while(ar[j]<=ar[i-1]) j-=1;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar, i,j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int t = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = t;
	}
}
