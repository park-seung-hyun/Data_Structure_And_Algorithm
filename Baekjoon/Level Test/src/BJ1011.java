// 1011번  
// Fly me to the Alpha Centauri  
// 규칙 찾기
// 어려움...

// https://oper6210.tistory.com/34

import java.util.Scanner;
public class BJ1011 {
	public static void main(String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = stdIn.nextInt();
			arr[i][1] = stdIn.nextInt();
		}
		for(int i=0;i<n;i++) {
			System.out.println(count2(arr[i]));
		}
		
	}
	// count 
	// 우주선 최소 작동 횟수를 구하는 함수 
	static int count(int[] ar) {
		// 노트 확인 (규칙 복잡)
		
		int d = ar[1] - ar[0];
		int len = (int) Math.sqrt(d);
		int count = 2*len;
		
		if((d - len*len) >len)
			count++;
		else if((d - len*len) == 0)
			count--;
		
		return count;
	}
	// count2 
	// 우주선 최소 작동 횟수를 구하는 함수 
	static long count2(int[] ar) {
		// 노트 확인 (규칙 복잡)
		
		int d = ar[1] - ar[0];
		
		for(long i=1 ;; i++) {
			if(d >= i*i-i+1 && d<= i*i+i) {
				if(d<=i*i)
					return i*2-1;
				else
					return i*2;
			}
		}
	}
}
