// BinarySearchTester 
// pg120 
// 이진 검색 (Binary Search)
// 표준 라이브러리로 제공되는 Arrays.binarySearch 사용 

import java.util.Scanner;
import java.util.Arrays; // Arrays 클래스의 binarySearch 메서드 사용 (표준 라이브러리)
public class BinarySearchTester {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner (System.in);
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순 입력 부탁합니다. ");
		System.out.print("x[0] :");
		x[0] = stdIn.nextInt();
		for(int i=1;i<num;i++) {
			do {
				System.out.print("x["+ i + "]: ");
				x[i] = stdIn.nextInt();
			}while(x[i]<x[i-1]);
		}
		System.out.print("검색할 값: ");
		int key = stdIn.nextInt();
		int idx = Arrays.binarySearch(x, key); // 
		
		if(idx < 0) // 실패했을 경우의 Arrays.binarySearch 반환값은 조금 다름. 
			System.out.println("검색 값이 없습니다.");
		else
			System.out.println("x["+idx+"] 에 있습니다.");
	}
	
}
