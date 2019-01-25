// ShellSort 
// pg220  
// 셀 정렬 
// Shell Sort
// 기존 삽입 정렬을 보완 

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("셀 정렬 ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("x["+i+"] :");
			x[i] = stdIn.nextInt();
		}
		
		shellSort1(x,n);
		System.out.println(Arrays.toString(x));
	}
	// 셀 정렬
	static void shellSort(int[] a, int n) {
		for(int h = n/2;h>0;h/=2) { // n이 8이면 -> 4, 2, 1 순으로 반복 
			for(int i=h;i<n;i++) { // 각 그룹 반복 
				int j;
				int temp = a[i];
				for(j=i-h; j>=0&&a[j]>temp;j-=h) { // 그룹 내 정렬 
					a[j+h] = a[j];
				}
				a[j+h] =temp;
			}
		}
	}
	// 셀 정렬 (개선 1)
	// h가 서로 배수가 되지 않게
	// 충분히 그룹들이 섞이도록 함. -> h 조정 
	// n이 9보다 작으면 문제....
	static void shellSort1(int[] a, int n) {
		int h ;
		for(h=0;h<n/9;h=h*3+1) ;
		
		for(;h>0;h/=3) { // n이 8이면 -> 4, 2, 1 순으로 반복 
			for(int i=h;i<n;i++) { // 각 그룹 반복 
				int j;
				int temp = a[i];
				for(j=i-h; j>=0&&a[j]>temp;j-=h) { // 그룹 내 정렬 
					a[j+h] = a[j];
				}
				a[j+h] =temp;
			}
		}
	}
}
