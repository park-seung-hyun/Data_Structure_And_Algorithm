// 1013번
// Contact
// DFA (Deterministic Finite Automata) 사용 

import java.util.Scanner;
public class BJ1013 {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		String[] input = new String[N];
		
		for(int i=0;i<N;i++) {
			input[i]= stdIn.next();
		}
		for(int i=0;i<N;i++) {
			System.out.println(patternAnalysis(input[i])?"YES":"NO");
		}
	}
	static boolean patternAnalysis(String input) {
		int[][] st = {
			{5,1},
			{2,9},
			{3,9},
			{3,4},
			{5,7},
			{9,6},
			{5,1},
			{8,7},
			{3,6},
			{9,9},
		};
		int state = 0;
    
		for(int i=0;i<input.length();i++) {
			state = st[state][input.charAt(i) - '0'];
		}
		
		if(state ==6||state == 4 || state ==7 ||state == 8)
			return true;
		else
			return false;
		
	}
}
