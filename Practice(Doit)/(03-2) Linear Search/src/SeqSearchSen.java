// SeqSearch 
// pg106 
// 선형 검색 
// 보초법 (Sentinal Method) 

import java.util.Scanner;
public class SeqSearchSen {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"] :");;
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int key = stdIn.nextInt();
		x[num] = key;
		// 배열 마지막에 보초를 세움. 
		
		int idx = seqSearchSen(x, num, key);
		
		if(idx == -1)
			System.out.println("검색 값 없습니다. ");
		else
			System.out.println(key + "은 x["+idx+"] 에 있습니다. ");
	}
	static int seqSearchSen(int[] a, int n, int key) { // 순차 검색 (보초법)
		int i=0;
		while(true) {
			if(a[i]== key) // 배열의 길이에 도달했을때 점검하는 if문 생략됨 -> 비용 절감 
				return i == n ? -1 : i;
			i++;
		}
	}
}
