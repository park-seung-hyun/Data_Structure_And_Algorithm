import java.util.Random;
import java.util.Scanner;

// MaxOfArrayRand 
// pg54
// 정수형 배열 (최댓값 + 난수 생성)  
public class MaxOfArrayRand {
	public static void main (String args[]) {
		// 난수 생성을 위한 Random 객체 생성 
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");
		int N = stdIn.nextInt();
		int[] H = new int[N];
		for(int i=0;i<N;i++) {
			H[i] = 100 + rand.nextInt(90); // 난수 = 0~89 
			System.out.println("H["+i+"] = "+H[i]);
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
