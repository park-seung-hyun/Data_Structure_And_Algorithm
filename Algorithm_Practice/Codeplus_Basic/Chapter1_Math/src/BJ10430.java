// 10430번
// 나머지 
// (A+B)%C = ((A%C) + (B%C))%C 
// 이는 곱하기, 뺴기 연산에서도 동일하다.
// 뺴기의 경우 음수가 나올 수 있으므로 ((A%C) - (B%C) + C)%C 

import java.util.Scanner;
public class BJ10430 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int A = stdIn.nextInt();
		int B = stdIn.nextInt();
		int C = stdIn.nextInt();
		System.out.println(plusModular1(A,B,C));
		System.out.println(plusModular2(A,B,C));
		System.out.println(multiplyModular1(A,B,C));
		System.out.println(multiplyModular2(A,B,C));
	}
	static int plusModular1(int a, int b, int c) {
		return (a+b)%c;
	}
	static int plusModular2(int a, int b, int c) {
		int na = a%c;
		int nb = b%c;
		return (na+nb)%c;
	}
	static int multiplyModular1(int a, int b, int c) {
		return (a*b)%c;
	}
	static int multiplyModular2(int a, int b, int c) {
		int na = a%c;
		int nb = b%c;
		return (na*nb)%c;
	}
}
