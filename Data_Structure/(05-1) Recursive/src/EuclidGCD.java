// EuclidGCD
// pg170  
// 최대공약수 (재귀)

import java.util.Scanner;

public class EuclidGCD {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		System.out.print("큰 수부터 입력해주세요.");
		int m = stdIn.nextInt();
		System.out.print("작은 수 입력해주세요.");
		int n = stdIn.nextInt();
		
		System.out.printf("%d 와 %d 의 최대공약수는 %d 입니다.", m, n, euclidGCD(m,n));
		
		
	}
	static int euclidGCD(int x, int y) {
		if(y==0)
			return x;
		else
			return euclidGCD(y, x%y);
	}
}
