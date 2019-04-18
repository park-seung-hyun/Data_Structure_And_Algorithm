// 퀵 정렬  
// 백준 2750번 

import java.util.Scanner;
public class QuickSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		quickSorting(0,n-1,n);
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
	static void quickSorting(int b, int e, int n) {
		if(b<e) {
			int p = getPivot(b,e,n);
			quickSorting(b,p-1,n);
			quickSorting(p+1,e,n);
		}
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static int getPivot(int b, int e, int n) {
		int pivot, l,r;
		l = b;
		r = e;
		pivot = (l+r)/2; // 균등한 분할을 위해 
		while(l<r) {
			while(num[l]<num[pivot] && l<r) l++;
			while(num[r]>=num[pivot] && l<r) r--;
			if(l<r) {
				swap(num,l,r);
				
				// 위에서 pivot이 움직였을 경우 
				if(pivot == l) 
					pivot = r;
			}
		}
		swap(num,pivot,r);
		return r;
	}
}
