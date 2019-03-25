// Fsort 
// pg269
// 도수 정럴 

import java.util.Arrays;
import java.util.Scanner;

public class Fsort {
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max+1];
		int[] b = new int[n];
		
		for(int i=0;i<n;i++) f[a[i]]++; // 1단계 도수분포표 만들기 
		for(int i=1;i<=max;i++)f[i] += f[i-1]; // 2단계 누적도수분포표 만들기 
		for(int i = n-1;i>=0;i--) b[--f[a[i]]] = a[i]; // 3단계 목적 배열 만들기 
		for(int i=0;i<n;i++) a[i] = b[i]; // 4단계 배열 복사하기 
	}
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("도수 정렬 ");
		System.out.print("요솟수: ");
		int n = stdIn.nextInt();
		int[] nx = new int[n];
		
		for(int i=0;i<n;i++) {
			nx[i] = stdIn.nextInt();
		}
		// 요소의 최대값 구하기 
		int max = nx[0];
		for(int i=1;i<n;i++) {
			if(max<nx[i])
				max = nx[i];
		}
		fSort(nx,n,max);
		System.out.println(Arrays.toString(nx));
	}
}
