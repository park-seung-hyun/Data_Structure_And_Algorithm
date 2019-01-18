// BinarySearchTester 
// pg123 
// 이진 검색 (Binary Search)
// 표준 라이브러리로 제공되는 Arrays.binarySearch 사용 
// 자연 정렬로 정렬된 배열에서 검색하기 (정수형, 문자열) 

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner (System.in);
		String[] x = {
				"abstract", "assert", "boolean", "break", "case", "catch"
		};
		System.out.print("검색할 값: ");
		String key = stdIn.next();
		int idx = Arrays.binarySearch(x, key); // 
		
		if(idx < 0)
			System.out.println("검색 값이 없습니다.");
		else
			System.out.println("x["+idx+"] 에 있습니다.");
	}
}
