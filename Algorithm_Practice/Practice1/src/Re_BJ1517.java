// 1517번 (복습)
// 버블 소트 
// Bubble Sort -> 시간 초과 O(n^2)  
// Merge Sort에서 Merge 과정에서 count 

import java.util.Scanner;
public class Re_BJ1517 {
	static int[] ar;
	static int[] ans;
	static long cnt=0;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		ans = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(n);
		System.out.println(cnt);
	}
	static void solve(int n) {
		if(n!=1) {
			mergeSort(0,n-1);
		}
		
	}
	static void merge(int l, int mid, int r) {
		
		int i = l;
		int j = mid+1;
		int k = l;
		
		while(i<=mid && j<=r) {
			if(ar[i]<ar[j]) {
				ans[k] = ar[i];
				i++;
			}else {
				ans[k] = ar[j];
				j++;
				cnt += mid-i+1;
			}
			k++;			
		}
		while(i<=mid) {
			ans[k] = ar[i];
			k++;
			i++;
		}
		while(j<=r) {
			ans[k] = ar[j];
			k++;
			j++;
		}
		
		for(k=l;k<=r;k++) {
			ar[k] = ans[k];
		}
	}
	static void mergeSort(int l, int r) {

		if(l==r)
			return;
		
		int mid = (l+r)/2;
		mergeSort(l,mid);
		mergeSort(mid+1,r);
		merge(l,mid,r);

	}
}
