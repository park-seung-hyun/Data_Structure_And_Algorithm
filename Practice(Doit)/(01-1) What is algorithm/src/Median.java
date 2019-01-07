import java.util.Scanner;

// Median
// pg21
// 중앙값을 구하는 알고리즘
public class Median {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("세 값을 입력해주세요.");
		System.out.println("a: ");
		int a = stdIn.nextInt();
		System.out.println("b: ");
		int b = stdIn.nextInt();
		System.out.println("c: ");
		int c = stdIn.nextInt();
	
		int med = med3(a,b,c);
		System.out.println("중앙값은 "+med+"입니다.");
		
	}
	static int med3(int a, int b, int c){
		int median = 0;
		
		if(a>=b) {
			if(b>=c)
				return b;
			else if(a<=c)
				return a;
			else
				return c;
		}
		else if(a>c)
			return a;
		else if(b>c)
			return c;
		else
			return b;
	
	}
}
