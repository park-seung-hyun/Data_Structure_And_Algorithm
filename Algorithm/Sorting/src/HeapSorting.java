// 힙 정렬  
// 백준 2750번 

import java.util.Scanner;
public class HeapSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		heapSorting(n);
	}
	static void swap(int[] ar, int id1,int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static void heapSorting(int n) {
		for(int i=n/2-1;i>=0;i--) {
			makeHeap(n,i);
		}
		for(int i=n-1;i>0;i--) {
			swap(num,i,0);
			makeHeap(i,0);
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
	static void makeHeap(int n, int i) {
		int p = i;
		int l = i*2+1;
		int r = i*2+2;
		
		if(l<n && num[p]<num[l]) p = l;
		if(r<n && num[p]<num[r]) p = r;
		
		if(p!=i) {
			swap(num,p,i);
			makeHeap(n,p);
		}
	}
}
