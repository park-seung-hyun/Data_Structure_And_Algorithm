import java.util.Scanner;

// Max3
// pg13 
// 최댓값을 구하는 알고리즘
public class Max3 {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("세 정수의 최댓값을 구합니다.");
		System.out.println("a: ");
		int a = stdIn.nextInt();
		System.out.println("b: ");
		int b = stdIn.nextInt();
		System.out.println("c: ");
		int c = stdIn.nextInt();
		
		int max = a;
		if(b>max) max = b;
		if(c>max) max = c;
		
		System.out.println("최댓값은 "+max+"입니다.");
		
	}
}
