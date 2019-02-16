// 1013번
// Contact
// DFA (Deterministic Finite Automata) 사용 

// http://blog.naver.com/PostView.nhn?blogId=moonsoo5522&logNo=220697122343
// http://eine.tistory.com/entry/%EB%B0%B1%EC%A4%80%EC%A0%80%EC%A7%80-1013%EB%B2%88-Contact-2671%EB%B2%88-%EC%9E%A0%EC%88%98%ED%95%A8-%EC%8B%9D%EB%B3%84-%ED%92%80%EC%9D%B4
// https://www.youtube.com/watch?v=40i4PKpM0cI
// https://www.youtube.com/watch?v=4bjqVsoy6bA 
// https://www.youtube.com/watch?v=--CSVsFIDng 
import java.util.Scanner;
public class BJ1013 {
	public static void main(String args[]) {
		// 입출력 
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
	// patternAnalysis 
	// DFA를 사용하여 문자열 패턴을 분석한다. 
	static boolean patternAnalysis(String input) {
		// DFA 상태전이표 
		// st[i][j]
		// 해당 state에서 0일 경우 i state로 이동 
		// 해당 state에서 1일 경우 j state로 이동 
		int[][] st = {
			{5,1}, // 0 state -> Initial state 
			{2,9}, // 1 state
			{3,9}, // 2 state
			{3,4}, // 3 state
			{5,7}, // 4 state -> Final state 
			{9,6}, // 5 state
			{5,1}, // 6 state -> Final state 
			{8,7}, // 7 state -> Final state 
			{3,6}, // 8 state -> Final state 
			{9,9}, // 9 state -> Dead state
		};
		int state = 0; // initial state
		
		// O(n) 내에 해결 가능 
		for(int i=0;i<input.length();i++) {
			// Char - '0' -> Int
			state = st[state][input.charAt(i) - '0'];
		}
		
		if(state ==6||state == 4 || state ==7 ||state == 8) // Final state일 경우 
			return true;
		else
			return false;
		
	}
}
