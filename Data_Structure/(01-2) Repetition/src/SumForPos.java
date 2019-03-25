import java.util.Scanner;

// SumForPos 
// pg32 
// 반복문을 통해 합을 구하는 알고리즘
public class SumForPos {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			// n이 0보다 작거나 같으면 반복합니다. 
			// n이 0보다 크면 반복문을 빠져나옵니다.
			System.out.println("값을 입력해주세요.");
			n = stdIn.nextInt();
		}while(n<=0);

		int sum = sumForPos(n);
		System.out.println("합은 "+sum+"입니다.");
	}
	static int sumForPos(int n) {
		int sum = 0;

		for(int i = 0;i<=n;i++) {
			sum = sum + i;
		}
		return sum;
	}
}
