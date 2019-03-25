// Factorial 
// pg166  
// 팩토리얼 (재귀)

import java.util.Scanner;

public class Factorial {
	static int factorial (int n) {
		if(n>0)
			return n * factorial(n-1);
		else
			return 1;
	}
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수를 입력하세요. ");
		int n = stdIn.nextInt();
		
		System.out.printf("%d 의 팩토리얼은 %d 입니다. ", n, factorial(n));
	}
}
