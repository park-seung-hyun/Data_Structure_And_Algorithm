// 1759번
// 암호 만들기
// DFS (Depth First Search) 사용 

import java.util.Scanner;
import java.util.Stack;
public class BJ1759 {
	static int L;
	static int C;
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		L = stdIn.nextInt();
		C = stdIn.nextInt();
		char[] alpha = new char[C];
		for(int i=0;i<C;i++) {
			alpha[i]= stdIn.next().charAt(0);
		} 
		char[] sortedAlpha = sortAlphabet(alpha);
		getCandidates(sortedAlpha);
	}
	static void getCandidates(char[] a) {
		
		for(int i = 0;i<a.length;i++) {
			char[] na = new char[a.length-i];
			for(int j=0;j<a.length-i;j++) {
				na[j] = a[j+i];
			}
			dfs(na);			
		}
		
	}
	static void dfs(char[] a) {

		Stack<Character> stack = new Stack<Character>();
		int i=0;
		stack.push(a[i]);
		while(!stack.isEmpty()) {
			i++;
			if(stack.size() == L) {
				if(check(stack)) {
					printAlphabet(stack);
				}
				stack.pop();
				i--;
			}
			else if(i>=a.length) {
				i = String.valueOf(a).indexOf(stack.peek());
				stack.pop();
			}
			else {
				stack.push(a[i]);
			}
			
		}
	}
	static char[] sortAlphabet(char[] alpha) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] score = new int[alpha.length];
		char[] sortedAlpha = new char[alpha.length];
		
		for(int i = 0;i<alpha.length;i++) {
			score[i] = alphabet.indexOf(alpha[i]);
		}
		
		for(int i=0;i<score.length;i++) {
			int r = 0;
			for(int j=0;j<score.length;j++) {
				if(score[i]>score[j]) r++;
			}
			sortedAlpha[r] = alpha[i];
		}
		
		return sortedAlpha;
	}
	static void printAlphabet(Stack<Character> stack) {
		stack.forEach(k->{
			System.out.print(k);
		});
		System.out.println();
	}
	static boolean check(Stack<Character> stack) {
		int m=0;
		int j=0;
		for(Character k : stack) {
			if(k=='a'||k=='e'||k=='i'||k=='o'||k=='u') {
				m++;
			}else {
				j++;
			}
			if(m>=1&&j>=2)
				return true;
	    }
		return false;
	}
}
