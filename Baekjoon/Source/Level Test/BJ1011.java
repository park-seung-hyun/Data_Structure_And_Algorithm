// 1011번  
// Fly me to the Alpha Centauri  
// 규칙 찾기
// 어려움...

import java.util.Scanner;

public class BJ1011 {
	public static void main(String[] args) {
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
	static int count(int[] ar) {
		
		int d = ar[1] - ar[0];
		int len = (int) Math.sqrt(d);
		int count = 2*len;
		
		if((d - len*len) >len)
			count++;
		else if((d - len*len) == 0)
			count--;
		
		return count;
	}
	static long count2(int[] ar) {

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
