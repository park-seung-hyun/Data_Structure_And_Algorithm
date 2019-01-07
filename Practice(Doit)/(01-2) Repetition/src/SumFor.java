import java.util.Scanner;

// SumFor 
// pg29 
// 반복문을 통해 합을 구하는 알고리즘
public class SumFor {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("값을 입력해주세요.");
		int n = stdIn.nextInt();
		int sum = sumFor(n);
		System.out.println("합은 "+sum+"입니다.");
	}
	static int sumFor(int n) {
		int sum = 0;

		for(int i = 0;i<=n;i++) {
			sum = sum + i;
		}
		return sum;
	}
}
