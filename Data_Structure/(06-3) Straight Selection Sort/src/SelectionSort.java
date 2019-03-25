// SelectionSort 
// pg210 
// 단순 선택 정렬 
// Selection Sort

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("선택 정렬 ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("x["+i+"] :");
			x[i] = stdIn.nextInt();
		}
		selectionSort(x,n);
		System.out.println(Arrays.toString(x));
		
	}
	// 두 값을 스왑 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	// 선택 정렬 
	static void selectionSort(int[] a, int n) {
		for(int i=0;i < n-1; i++) { 
			int min = i; // min -> 정렬되지 않은 부분에서 가장 작은 요소 
			for(int j = i+1;j<n;j++) { // 정렬되지 않은 부분 모두 탐색하며 min 찾기 
				if(a[min]>a[j]) // 가장 작은 요소 찾기 
					min = j;
			}
			swap(a, i, min); // i-> 정렬되지 않은 부분의 가장 첫 원소 , min-> 정렬되지 않은 부분의 가장 작은 요소 
		}
	}
}
