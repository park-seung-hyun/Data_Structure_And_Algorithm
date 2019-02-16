// 1013번 (복습)
// Contact
// DFA (Deterministic Finite Automata) 사용 

import java.util.Scanner;

public class Re_BJ1013 {
	static int[][] st = {
			{5,1},
			{2,9},
			{3,9},
			{3,4},
			{5,7},
			{9,6},
			{5,1},
			{8,7},
			{3,6},
			{9,9}
	};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		stdIn.nextLine();
		for(int i=0;i<t;i++) {
			String s = stdIn.nextLine();	
			System.out.println(solve(s)?"YES":"NO");
		}
	}
	static boolean solve(String s) {
		int state = 0;
		boolean flag = true;
		for(int i=0;i<s.length();i++) {
			int next = s.charAt(i)-'0';
			state = st[state][next];
			if(state == 9) {
				break;
			}
		}
		if(state == 4 || state == 6 || state == 7)
			return true;
		else
			return false;
	}
}
