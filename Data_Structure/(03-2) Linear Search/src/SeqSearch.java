// SeqSearch 
// pg102 
// 선형 검색 (순차 검색)

import java.util.Scanner;
public class SeqSearch {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"] :");;
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int key = stdIn.nextInt();
		int idx = seqSearch(x, num, key);
		
		if(idx == -1)
			System.out.println("검색 값 없습니다. ");
		else
			System.out.println(key + "은 x["+idx+"] 에 있습니다. ");
	}
	static int seqSearch(int[] a, int n, int key) { // 순차 검색 
		int i=0;
		while(true) {
			if(i == n) // 배열의 길이에 닿을 경우 
				return -1;
			if(a[i]== key) // key 발견 
				return n;
			
			i++;
		}
	}
	static int seqSearch2(int[] a, int n, int key) { // 순차 검색 
		for(int i=0;i<n;i++) {
			if(a[i] == key)
				return i;
		}
		return -1;
	}
	
}
