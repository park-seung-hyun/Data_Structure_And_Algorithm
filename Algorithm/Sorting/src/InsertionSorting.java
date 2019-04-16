// 삽입 정렬  
// 백준 2750번 

import java.util.Scanner;
public class InsertionSorting {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = stdIn.nextInt();
		}
		insertionSorting(n);
	}
	static void insertionSorting(int n) {
//		for(int i=1;i<n;i++) {
//			
//			int temp = num[i];
//			int id = 0;
//			
//			for(int j=i-1;j>=0;j--) {
//				if(temp > num[j]) {
//					id = j+1;
//					break;
//				}
//			}
//			for(int j=i;j>id;j--) {
//				num[j] = num[j-1];
//			}
//			num[id] = temp;
//		}
		for(int i=1;i<n;i++) {
			
			int temp = num[i];
			int id = 0;
			for(int j=i-1;j>=0;j--) {
				if(temp <= num[j]) {
					num[j+1] = num[j]; 
				}else {
					id = j+1;
					break;
				}
			}
			num[id] = temp;
			
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}
}
