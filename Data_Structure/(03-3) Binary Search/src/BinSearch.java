// BinSearch
// pg111 
// 이진 검색 (Binary Search)

import java.util.Scanner;
public class BinSearch {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
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
		int idx = binSearch(x, num, key);
		
		if(idx == -1)
			System.out.println("검색 값이 없습니다.");
		else
			System.out.println("x["+idx+"] 에 있습니다.");
	}
	static int binSearch(int[] a, int n, int key) { // a는 정렬되어 있어야함. 
		int l = 0;
		int r = n-1; // n = 배열이 길이 
		
		do {
			int m = (l+r)/2; // 배열의 중앙 인덱스 
			if(a[m]<key) // 중앙 요소가 key보다 작으면 찾고자하는 것은 우측 
				l = m+1;
			else if(a[m]>key) // 중앙 요소가 key보다 크면 찾고자하는 것은 좌측 
				r = m-1;
			else // 일치할 경우 (검색 성공) 
				return m;
		}while(l<=r); // 종료 조건 l>r
		return -1;
	}
}
