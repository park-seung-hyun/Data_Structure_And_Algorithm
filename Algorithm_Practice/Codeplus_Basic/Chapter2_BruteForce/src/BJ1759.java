// 1759번
// 암호 만들기
// 재귀 호출 

//import java.util.Arrays;
//import java.util.Scanner;
//public class BJ1759 {
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int l = stdIn.nextInt();
//		int c = stdIn.nextInt();
//		
//		char[] ar = new char[c];
//		for(int i=0;i<c;i++) {
//			ar[i] = stdIn.next().charAt(0);
//		}
//		// 우선 정렬 (알파벳 오름차순)
//		Arrays.sort(ar);
//		solve(l, ar, "", 0);
//	}
//	static void solve(int l, char[] alpha, String pw, int i) {
//		if(l==pw.length()) { // 정답인 경우 (1)
//			if(check(pw)) {
//				System.out.println(pw);
//			}
//			return;
//		}
//		if(i>= alpha.length) { // 불가능한 경우 (2)
//			return;
//		}
//		// 다음 경우 호출 (3)
//		solve(l, alpha, pw+alpha[i], i+1);
//		solve(l, alpha, pw, i+1);
//	}
//	static boolean check(String pw) {
//		int mo = 0;
//		int ja = 0;
//		for(int i=0;i<pw.length();i++) {
//			int c = pw.charAt(i);
//			if(pw.charAt(i)=='a'||pw.charAt(i)=='e'||pw.charAt(i)=='i'||pw.charAt(i)=='o'||pw.charAt(i)=='u') {
//				mo++;
//			}
//			else {
//				ja++;
//			}
//		}
//		if(ja>=2 && mo>=1)
//			return true;
//		else
//			return false;
//		
//	}
//}

import java.util.Arrays;
import java.util.Scanner;
public class BJ1759{
	static int l;
	static int c;
	static char[] alpha;
	static char[] mo = {'a','e','i','u','o'};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		l = stdIn.nextInt();
		c = stdIn.nextInt();
		alpha = new char[c];
		for(int i=0;i<c;i++) alpha[i] = stdIn.next().charAt(0);
		Arrays.sort(alpha);
		go(0,"");
		
	}
	static void go(int index, String s) {
		if(s.length() == l) {
			int mo = 0;
			int ja = 0;
			for(char c : s.toCharArray()) {
				if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u') {
					mo++;
				}else {
					ja++;
				}	
			}
			if(mo>=1 && ja>=2) {
				System.out.println(s);
			}
			return;
		}
		if(index >= c) return;
		go(index+1, s+alpha[index]);
		go(index+1, s);
	}
}