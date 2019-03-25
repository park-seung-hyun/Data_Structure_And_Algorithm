// QuickSort 
// pg232 
// 퀵 정렬 

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class QuickSort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("배열을 나눕니다. ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i=0;i<n;i++) {
			x[i] = stdIn.nextInt();
		}
		quickSort2(x,0, n-1);
		
		System.out.println(Arrays.toString(x));
	}
	// 두 값을 스왑 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	// 퀵 소트 
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서  
		int pr = right; // 오른쪽 커서 
		int x = a[(pl+pr)/2]; // Pivot
		
		// 배열을 pivot(x) 기준으로 나눕니다. 
		do {
			while(a[pl]<x)pl++; // Pivot보다 크거나 같은 값 찾을 떄까지 왼쪽으로 스캔 
			while(a[pr]>x)pr--; // Pivot보다 작거나 같은 값 찾을 떄까지 오른쪽으로 스캔 
			if(pl<=pr) // pr이 pl보다 오른쪽에 있으면 swap 
				swap(a, pl++,pr--);
		}while(pl<=pr); // pl > pr 일 동안 반복 
		
		// 요소의 개수가 2이상인 경우 
		// 요소가 1일때는 실행 안함. 
		if(left<pr) quickSort(a, left, pr); // 재귀 호출 (왼쪽 그룹)
		if(pl<right) quickSort(a, pl, right); // 재귀호출 (오른쪽 그룹)
	}
	// 퀵 소트 (비 재귀적 알고리즘)
		static void quickSort2(int[] a, int left, int right) {
			
			Stack<Integer> lstack = new Stack<Integer>();
			Stack<Integer> rstack = new Stack<Integer>();
			
			// 제일 처음 끝과 끝 
			lstack.push(left);
			rstack.push(right);
			
			while(lstack.isEmpty()!=true) {
				int pl = left = lstack.pop();
				int pr = right = rstack.pop();
				int x = a[(left+right)/2];
				
				// 배열을 pivot(x) 기준으로 나눕니다. 
				do {
					while(a[pl]<x)pl++; // Pivot보다 크거나 같은 값 찾을 떄까지 왼쪽으로 스캔 
					while(a[pr]>x)pr--; // Pivot보다 작거나 같은 값 찾을 떄까지 오른쪽으로 스캔 
					if(pl<=pr) // pr이 pl보다 오른쪽에 있으면 swap 
						swap(a, pl++,pr--);
				}while(pl<=pr); // pl > pr 일 동안 반복 
				
				// 요소의 개수가 2이상인 경우 
				// 요소가 1일때는 실행 안함. 
				if(left<pr) { 
					// 나뉜 왼쪽 그룹의 끝과 끝 push 
					lstack.push(left);
					rstack.push(pr);
				}
				if(pl<right) {
					// 나뉜 오른쪽 그룹의 끝과 끝 push 
					lstack.push(pl);
					rstack.push(right);
				}
			}
		}
}
