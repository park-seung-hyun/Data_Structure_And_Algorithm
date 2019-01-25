// InsertionSort 
// pg214 
// 단순 삽입 정렬 
// Insertion Sort

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("삽입 정렬 ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("x["+i+"] :");
			x[i] = stdIn.nextInt();
		}
		
		insertionSort(x,n);
		System.out.println(Arrays.toString(x));
		
	}
	// 삽입 정렬 
	static void insertionSort(int[] a, int n) {
		for(int i=1;i<n;i++) { // 두번째 요소 부터 시작 
			int j;
			int temp = a[i]; // 임시 저장 
			for(j = i; j>0&&a[j-1]>temp;j--) { // j>0 -> j 는 0 보다 크고, a[j-1]>temp -> 왼쪽 요소가 더 클 경우 
				a[j] = a[j-1]; // 왼쪽 요소를 오른쪽 요소에 삽입 
			}
			a[j] = temp; // 삽입 
		}
	}
}
