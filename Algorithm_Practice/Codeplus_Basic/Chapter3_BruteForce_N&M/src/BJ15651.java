// 15651번
// N과 M (3)
// 재귀 호출 
// N과 M (1)에서 중복 체크가 사라지고 똑같음. 

//import java.util.Scanner;
//public class BJ15651 {
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		solve(0,n,m,"");
//	}
//	static void solve(int index, int n, int m, String ans) {
//		if(index == m) {
//			System.out.println(ans); // 기존 반복문 print는 시간초과를 야기함. 
//			return;
//		}
//		// 중복 체크 없어짐. 
//		for(int i=1;i<=n;i++) {
//			solve(index+1, n, m, ans + i+ " ");
//		}
//	}
//}

import java.util.Scanner;
public class BJ15651{
	static int n = 0;
	static int m= 0;
	static int[] ar;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt();
		m= stdIn.nextInt();
		ar = new int[m];
		go(0,"");
	}
	static void go(int id, String s) {
		if(id == m) {
			System.out.println(s);
			return;
		}
		for(int i=1;i<=n;i++) {
			go(id+1, s + i + " ");
		}
	}
}