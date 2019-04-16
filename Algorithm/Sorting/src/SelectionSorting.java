// 선택 정렬  
// 백준 2750번 

import java.util.Scanner;
public class SelectionSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		selectionSorting(n);
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static void selectionSorting(int n) {
		for(int i=0;i<n;i++) {
			int index = i;
			int min = 1000;
			for(int j=i;j<n;j++) {
				if(min > num[j]) {
					min = num[j];
					index = j;
				}
			}
			swap(num, i, index);
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
}
