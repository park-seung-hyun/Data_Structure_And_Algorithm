// Partition 
// pg227   
// 퀵 정렬 
// Quick Sort 의 Partition 부분 

import java.util.Arrays;
import java.util.Scanner;
public class Partition {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("배열을 나눕니다. ");
		System.out.print("요솟수 :");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i=0;i<n;i++) {
			x[i] = stdIn.nextInt();
		}
		
		partition(x,n);
	}
	// 두 값을 스왑 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	// 두 그룹으로 나누는 함수 
	static void partition(int[] a, int n) {
		int pl = 0; // 시작 pl 
		int pr = n-1; // 시작 pr 
		int x = a[n/2]; // Pivot
		
		// 배열을 pivot(x) 기준으로 나눕니다. 
		do {
			while(a[pl]<x)pl++; // Pivot보다 크거나 같은 값 찾을 떄까지 왼쪽으로 스캔 
			while(a[pr]>x)pr--; // Pivot보다 작거나 같은 값 찾을 떄까지 오른쪽으로 스캔 
			if(pl<=pr) // pr이 pl보다 오른쪽에 있으면 swap 
				swap(a, pl++,pr--);
		}while(pl<=pr); // pl > pr 일 동안 반복 
		
		System.out.println("피벗 값은 " + x +"입니다. ");
		
		System.out.println("피벗 이하의 그룹 "); 
		for(int i=0;i<=pl-1;i++) { // a[0] ~ a[pl-1] 
			System.out.println(a[i]+ " ");
		}
		if(pr+1<pl) {
			System.out.println("피벗과 일치하는 그룹 "); 
			for(int i=pr+1;i<=pl-1;i++) { // a[pr+1] ~ a[pl-1] 
				System.out.println(a[i]+ " ");
			}
		}
		System.out.println("피벗 이상의 그룹 "); 
		for(int i=pr+1;i<=n-1;i++) { // a[pr+1] ~ a[n-1] 
			System.out.println(a[i]+ " ");
		}	
	}
}
