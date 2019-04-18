// 셸 정렬  
// 백준 2750번 

import java.util.Scanner;
public class ShellSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		shellSorting(n);
	}
	static void insertionSorting(int first, int last, int gap) {
		// 부분 삽입 정렬 
		int i,j,key;
		for(i=first+gap;i<=last;i+=gap) {
			key = num[i];
			for(j=i-gap;j>=first && num[j]>key;j-=gap) { // 역순으로 
				num[j+gap] = num[j]; // 한칸 앞으로 이동 
			}
			num[j+gap] = key;
		}
	}
	static void shellSorting(int n) {
		int gap = n/2;
		while(gap>=1) {
			if(gap%2==0) gap++;
			for(int i=0;i<gap;i++) {
				insertionSorting(i, n-1, gap);
			}
			gap/=2;
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
}
