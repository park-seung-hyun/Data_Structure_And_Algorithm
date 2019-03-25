// ArraysSortTester 
// pg250 
// Quick Sort
// 표준 라이브러리로 제공되는 Arrays.sort 사용 

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: ");
		int n = stdIn.nextInt();
		int[] nx = new int[n];
		for(int i=0;i<n;i++) {
			nx[i] = stdIn.nextInt();
		}
		// Sort 
		Arrays.sort(nx);
		System.out.println(Arrays.toString(nx));
	}
}
