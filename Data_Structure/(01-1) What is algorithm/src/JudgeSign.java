import java.util.Scanner;

// JudgeSign
// pg22
// 부호를 구하는 알고리즘
public class JudgeSign {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("값을 입력해주세요.");
		int a = stdIn.nextInt();
		judgeSign(a);
	}
	static void judgeSign(int a) {
		if(a>0)
			System.out.println("양수입니다.");
		else if(a<0)
			System.out.println("음수입니다.");
		else
			System.out.println("0입니다.");
	}
}
