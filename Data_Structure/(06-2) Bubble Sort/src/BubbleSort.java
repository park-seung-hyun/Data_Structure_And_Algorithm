// BubbleSort
// pg202 
// 버블 정렬 
// Bubble Sort

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("버블 정렬 ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("x["+i+"] :");
			x[i] = stdIn.nextInt();
		}
		bubbleSort1(x,n);
		System.out.println(Arrays.toString(x));
		
	}
	// 두 값을 스왑 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	// 버블 정렬 
	static void bubbleSort(int[] a, int n) {
		for(int i=0;i < n-1; i++) { // 총 n-1번 (pass)
			for(int j = n-1;j>i;j--) { // 확정난 요소 제외하고 모두 비교 및 교환 (확정난 요소는 상위 반복문이 돌아감에따라 +1)
				if(a[j-1]>a[j])
					swap(a, j-1, j);
			}
		}
	}
	// 버블 정렬 (개선 1)
	// 어떤 pass에서 교환 작업이 한번도 없었을 경우 -> 이미 정렬된 상태 
	static void bubbleSort1(int[] a, int n) {
		for(int i=0;i < n-1; i++) { // 총 n-1번 (pass)
			int exc = 0;
			for(int j = n-1;j>i;j--) { 
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
					exc++;
				}
			}
			if(exc == 0) // 교환이 한번도 없던 경우 
				break;
		}
	}
	// 버블 정렬 (개선 2)
	// 어떤 시점부터 끝날때까지 교환이 없었다면 그 부분은 생략 가능 
	static void bubbleSort2(int[] a, int n) {
		int k=0; // 첫 pass는 모두 검사 
		while(k<n-1){
			int last = n-1;
			for(int j = n-1;j>k;j--) { 
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
					last = j;
				}
			}
			k = last; // pass 범위를 제한 
		}
	}
}
