// 10973번
// 이전 순열  
// 다음 순열과 반대 과정 
// O(N+N+1+N) -> O(N) 

import java.util.Scanner;
public class BJ10973 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n =  stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		if(previousPermutation(ar)==false) {
			System.out.println(-1);
			return ; 
		}
		for(int i=0;i<n;i++) {
			System.out.println(ar[i]);
		}
	}
	static boolean previousPermutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i]>=ar[i-1]) i-=1; // i 찾기 
		if(i<=0) return false;
		int j = n-1;
		while(ar[j]>=ar[i-1]) j-=1; // i-1 보다 뒤에서 i-1보다 작은 값 찾기 (그 중 최댓값)
		swap(ar, j, i-1); // i-1, j 스왑 
		j = n-1;
		while(i<=j) { // 뒷자리 마지막 순열로 바꾸기 
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
