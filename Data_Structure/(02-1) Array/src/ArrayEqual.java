import java.util.Scanner;

// ArrayEqual  
// pg62 
// 정수형 배열 (두 배열의 비교)    
public class ArrayEqual {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("배열 a의 요솟수: ");
		int sa = stdIn.nextInt();
		int[] a = new int[sa]; 
		for(int i=0;i<sa;i++) {
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("배열 b의 요솟수: ");
		int sb = stdIn.nextInt();
		int[] b = new int[sb]; 
		for(int i=0;i<sb;i++) {
			b[i] = stdIn.nextInt();
		}
		// boolean ? true일 경우 : false일 경우 
		System.out.println("배열 a와 배열 b는 "+ (equals(a,b) ?"같습니다.": "틀립니다."));
	
	}
	static boolean equals(int[] a, int[] b ) {
		if(a.length != b.length) { // 길이 체크 
			return false;
		}
		for(int i=0;i<a.length;i++) { // 각 요소 체크 
			if(a[i]!=b[i]) // 값이 틀릴 경우 
				return false;
		}
		// 값이 모두 같을 경우 반복문 통과 
		return true;
	}
}
