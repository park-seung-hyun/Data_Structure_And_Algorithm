// 버블 정렬  
// 백준 2750번 

import java.util.Scanner;
public class BubbleSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		bubbleSorting(n);
	}
	static void bubbleSorting(int n) {
		for(int i=n-1 ;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(num[j] > num [j+1]) {
					swap(num, j, j+1);
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}
