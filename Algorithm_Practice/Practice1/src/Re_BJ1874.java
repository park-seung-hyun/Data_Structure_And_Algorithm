// 1874번 (복습)
// 스택 수열 
// 스택 (Stack)

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class Re_BJ1874 {
	static int[] ar;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(n);
	}
	static void solve(int n) {
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<Character> ans = new ArrayList<Character>();
		int i = 1;
		int j = 0;
		s.push(i);
		ans.add('+');
		while(j<n && i<=n) {
			
			if(!s.isEmpty() && s.peek() == ar[j]) {
				ans.add('-');
				s.pop();
				j++;
			}else {
				ans.add('+');
				s.push(++i);
			}
			
		}
		if(ans.size() == 2*n) {
			for(char c: ans) {
				System.out.println(c);
			}
		}
		else
			System.out.println("NO");
		
		
	}
}
