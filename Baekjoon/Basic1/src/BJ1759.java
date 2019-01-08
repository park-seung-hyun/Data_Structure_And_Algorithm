// 1759번
// 암호 만들기
// DFS (Depth First Search) 사용 

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class BJ1759 {
	static int L;
	static int C;
	public static void main (String args[]) {
		// 입출력 
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
	// getCandidates
	// 후보 계산 
	static void getCandidates(char[] a) {
		
		for(int i = 0;i<a.length;i++) {
			char[] na = new char[a.length-i];
			for(int j=0;j<a.length-i;j++) {
				na[j] = a[j+i];
			}
			
			// 알파벳 배열의 첫 원소를 pop하면서 dfs() 호출
			// acistw -> cistw -> istw -> ....
			dfs(na);			
		}
		
	}
	// dfs
	// 깊이 우선 탐색 (Depth First Search) 사용 
	static void dfs(char[] a) {

		// 스택 사용 
		// 배열의 첫 원소 push
		Stack<Character> stack = new Stack<Character>();
		int i=0;
		stack.push(a[i]);
		// 스택이 빌때까지 반복 
		while(!stack.isEmpty()) {
			
			i++;

			// 스택 크기가 L가 같을 경우 
			if(stack.size() == L) {
				// 자음, 모음 개수가 맞으면 출력 
				if(check(stack)) {
					printAlphabet(stack);
				}
				// 최상단 원소 pop
				stack.pop();
				i--;
			}
			// i가 배열의 크기를 벗어날 경우 
			else if(i>=a.length) {
				// 스택의 최상단 원소의 인덱스 -> i
				// pop 전에 하는 이유는 어짜피 다음 반복문에서 i++이 있기 때문 
				i = String.valueOf(a).indexOf(stack.peek());
				// pop
				stack.pop();
			}
			// 그 외의 경우 
			else {
				// push
				stack.push(a[i]);
			}
			
		}
	}
	// sortAlphabet
	// 알파벳 순서에 맞게 정렬한 배열을 반환 
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
	// printAlphabet
	// 스택의 순서에 맞게 출력 
	static void printAlphabet(Stack<Character> stack) {
		stack.forEach(k->{
			System.out.print(k);
		});
		System.out.println();
	}
	// check
	// 모음과 자음 개수를 확인하여 조건을 만족하면 true 반환 
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
