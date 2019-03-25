import java.util.Scanner;

// SumWhile
// pg27
// 반복문을 통해 합을 구하는 알고리즘
public class SumWhile {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("값을 입력해주세요.");
		int n = stdIn.nextInt();
		int sum = sumWhile(n);
		System.out.println("합은 "+sum+"입니다.");
	}
	static int sumWhile(int n) {
		int sum = 0;
		int i = 0;
		while(n>=i) {
			sum += i;
			i++;
		}
		return sum;
	}
}
