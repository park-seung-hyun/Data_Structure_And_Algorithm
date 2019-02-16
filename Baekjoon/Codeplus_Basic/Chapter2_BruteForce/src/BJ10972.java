// 10972번
// 다음 순열  
// O(N+N+1+N) -> O(N) 

import java.util.Scanner;
public class BJ10972 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n =  stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		if(nextPermutation(ar)==false) {
			System.out.println(-1);
			return ; 
		}
		for(int i=0;i<n;i++) {
			System.out.println(ar[i]);
		}
	}
	static boolean nextPermutation(int[] ar) {
		int i = ar.length-1;
		while(i>0 && ar[i-1]>=ar[i]) i -= 1; // i 찾기 
		if(i<=0) return false;
		int j = ar.length-1;
		while(ar[j]<=ar[i-1]) j-=1; // i-1 뒤에서 i-1보다 큰 j 찾기 (그 중 최솟값)
		swap(ar, i-1, j); // i-1, j 스왑 
		j = ar.length-1;
		while(i<j) { // 뒷자리 첫 순열로 바꾸기 
			swap(ar,i,j);
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
