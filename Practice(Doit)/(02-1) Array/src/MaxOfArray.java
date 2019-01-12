import java.util.Scanner;

// MaxOfArray
// pg52
// 정수형 배열 (최댓값) 
public class MaxOfArray {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");
		int N = stdIn.nextInt();
		int[] H = new int[N];
		for(int i=0;i<N;i++) {
			H[i] = stdIn.nextInt();
		}
		int M = maxOf(H);
		System.out.println("최대값은 "+ M+"입니다.");
	}
	static int maxOf(int[] a) {
		// a는 H가 참조하는 곳을 전달받음. 
		// 배열 본체에 대한 참조를 전달받음. 
		int max = a[0];
		for(int i=0; i<a.length;i++) {
			if(a[i]>max)
				max = a[i];
		}
		return max;
	}
}
