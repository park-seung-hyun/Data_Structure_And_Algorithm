// 9012번  
// 괄호 

import java.util.Scanner;
import java.util.Stack;

public class BJ9012 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		String[] ps = new String[n];
		
		stdIn.nextLine();
		
		for(int i=0;i<n;i++) {
			ps[i] = stdIn.nextLine();
		}
		for(int i=0;i<n;i++) {
			System.out.println(isVps(ps[i]) ? "YES" : "NO");
		}
	}
	static boolean isVps(String ps) {
		
		Stack<Character> st = new Stack<Character>();
		
		if(ps.charAt(0) == '(')
			st.push(ps.charAt(0));
		else
			return false;
		
		for(int i=1;i<ps.length();i++) {
			
			if(!st.isEmpty() && st.peek() == '(' && ps.charAt(i) ==')')
				st.pop();
			else
				st.push(ps.charAt(i));
		}
	
		return st.isEmpty() ? true : false;
	}
}
