// Recur 
// pg171
// 재귀 알고리즘 분석 
// Top-Down , Bottom-Up 
// 재귀 -> 비재귀 (어려움)
import java.util.Scanner;
import java.util.Stack;
public class Recur {
	static void recur(int n) {
		if(n>0) {
			recur(n-1);
			System.out.print(n);
			recur(n-2);
		}
	}
	static void recur2(int n) {
		// 재귀 -> 비재귀 
		// 임시 저장 필요 -> 스택 사용 
		Stack<Integer> s = new Stack<Integer>();
		while(true) {
			if(n>0) {
				s.push(n); 
				// push된 값 -1 -> 왼쪽 가지로 내려감. 
				n = n-1;
				continue;
			}
			// n<=0인 순간 위 박스로 올라옴. 
			// 그 후 스택의 peek에 있던 값 pop 후 출력 
			// 다시 그 값을 n으로 하여 반복 
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.print(n);
				// pop된 값 -2 -> 오른쪽 가지로 내려감. 
				n = n-2;
				continue;
			}
			break;
		}
		
		
	}
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수를 입력하세요. ");
		int n = stdIn.nextInt();
		recur2(n);
	}
}
