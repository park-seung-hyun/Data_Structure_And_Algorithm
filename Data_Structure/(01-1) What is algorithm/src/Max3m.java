import java.util.Scanner;

// Max3m
// pg17 
// 최댓값을 구하는 알고리즘
// 최댓값을 구하는 일이 반복될 경우 메서드로 처리합니다.
public class Max3m {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("세 값을 입력해주세요.");
		System.out.println("a: ");
		int a = stdIn.nextInt();
		System.out.println("b: ");
		int b = stdIn.nextInt();
		System.out.println("c: ");
		int c = stdIn.nextInt();
		
		int max = max3(a,b,c);
		System.out.println("최댓값은 "+max+"입니다.");
		
	}
	static int max3 (int a, int b, int c) {
		int max = a;
		if(b>max) max = b;
		if(c>max) max = c;
		return max;
	}
}
