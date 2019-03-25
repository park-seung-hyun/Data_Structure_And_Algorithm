// MergeSort 
// pg245 
// 병합 정렬 

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	static int[] buff; // 작업용 버퍼
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("병합 정렬 ");
		System.out.print("요솟수: ");
		int n = stdIn.nextInt();
		int[] nx = new int[n];
		
		for(int i=0;i<n;i++) {
			nx[i] = stdIn.nextInt();
		}
		mergeSort(nx, n);
		System.out.println(Arrays.toString(nx));
	}
	static void __mergeSort(int[] a, int left, int right) {
		
		// a[left] ~ a[right]를 재귀적으로 병합 정렬
		// 하나의 배열로 인덱스만 바꿔가며 작업
		if(left<right) { // 배열의 요소가 2개 이상의 경우 
			int i;
			int center = (left+right) /2; // 중앙 
			int p = 0;
			int j = 0;
			int k = left;
			
			// 재귀 호출 
			__mergeSort(a, left, center); // 왼쪽 배열 
			__mergeSort(a, center+1, right); // 오른쪽 배열 
			
			// Merge 과정 
			for(i = left; i<=center; i++)
				buff[p++] = a[i]; // 왼쪽 배열을 작업용 배열에 복사 
			
			// 대소 비교하며 병합 
			while(i<=right && j<p)
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
				
			// 왼쪽 배열 남았을 경우 채워 넣음.
			// 오른쪽 배열 안하는 이유 -> 이미 채워져 있음. 
			while(j<p)
				a[k++] = buff[j++];
		}
	}
	static void mergeSort(int[] a, int n) {
		buff = new int[n]; // 작업용 배열 생성 
		__mergeSort(a, 0 , n-1); // 배열 전체를 병합 정렬 
		buff = null; // 작업용 배열을 해제 
	}
}
