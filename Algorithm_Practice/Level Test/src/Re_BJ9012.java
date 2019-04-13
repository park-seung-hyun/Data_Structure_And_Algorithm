// 9012번 (복습) 
// 괄호 

import java.util.Scanner;
import java.util.Stack;
public class Re_BJ9012 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			solve(s);
		}
	}
	static void solve(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> st = new Stack<Character>();
		st.push(ch[0]);
		int i=1;
		while(i<s.length()) {
			if(st.isEmpty()) {
				st.push(ch[i]);
			}else {
				char c = st.peek();
				if(!(ch[i] == ')' && c == '(')) {
					st.push(ch[i]);
				}else {
					st.pop();
				}
			}
			i++;
		}

		System.out.println(st.isEmpty()?"YES":"NO");
	}
}
