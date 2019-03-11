// 2473번 
// 세 용액 
// l, r 인덱스를 사용하여 탐색 
// 2467번이랑 똑같음. 

import java.util.Scanner;
public class BJ2473 {
	static int l1 = 0;
	static int l2 = 0;
	static int l3 = 0;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		long[] ar = new long[n];
		for(int i=0;i<n;i++) {
			ar[i]= stdIn.nextInt();
		}
		sort(ar);
		findLiquid(ar, n);
	}
	// findLiquid 
	// 용액의 합이 0에 가까운 세 용액을 찾음. 
	// 두 개를 찾는 2467번을 응용 
	static void findLiquid(long[] ar, int n) {
		
		long min = Long.MAX_VALUE;
		
		// 2467번에서 반복문 하나 더 씌워주고  
		// 용액 한개를 고정하고 나머지 두개에 대해 탐색 
		for(int i=0;i<n-2;i++) {
			int l = i+1;
			int r = n-1;
			while(!(l>=r)) {
				long cur = (ar[l]+ar[r]+ar[i]);
				// 여기서 long 타입 문제가 생긴거 같음.
				// ar 배열도 long으로 선언 
				if(min >= Math.abs(cur)) {
					l1 = i;
					l2 = l;
					l3 = r;
					min = Math.abs(cur);
				}
				if(min == 0)
					break;
				
				if(cur>0) {
					r--;
					
				}else if(cur<0){
					l++;
				}
			}
		}
		
		System.out.printf("%d %d %d",ar[l1],ar[l2],ar[l3] );

	}
	// sort
	// 버블 정렬 사용 
	static void sort(long[] ar) {
		for(int i=0;i<ar.length-1;i++) {
			for(int j=0;j<ar.length-1-i;j++) {
				if(ar[j]>ar[j+1])
					swap(ar,j,j+1);
			}
		}
	}
	// swap 
	// 배열의 두 요소 교환 
	static void swap(long[] ar, int id1, int id2) {
		long t = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = t;
	}
}
