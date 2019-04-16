// 합병 정렬  
// 백준 2750번 

import java.util.Scanner;
public class MergeSortng {
	static int[] num;
	static int[] buff;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		mergeSorting(n);
	}
	static void mergeSorting(int n) {
		
		buff = new int[n];
		__mergeSort(0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
	static void __mergeSort(int left, int right) {
		
		if(left< right) { // 크기가 2 이상일 경우
			int i;
			int center = (left + right)/2;
			int p = 0;
			int j = 0;
			int k = left;
			
			__mergeSort(left, center);
			__mergeSort(center+1, right);
			
			// Merger 과정 
			for(i=left;i<=center;i++) 
				buff[p++] = num[i];
			
			// p -> 왼쪽 배열 크기만큼 이동 
			// i -> 왼쪽에서 중앙까지 이동 
			
			while(i<=right && j<p) {
				num[k++] = (buff[j] <= num[i]) ? buff[j++] : num[i++];
			}
			// i -> 오른쪽까지 이동 
			// j<p를 통해 buff 인덱스 에러 방지 
			// k는 왼쪽에서 오른쪽으로 이동 

			
			// 오른쪽 배열이 더 작아서 왼쪽 배열이 남은 경우 채워줌.
			while(j<p) {
				num[k++] = buff[j++];
			}
			
		}
	}
}
