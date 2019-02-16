// 1874번  
// 스택 수열 
// 스택 (Stack)

import java.util.Scanner;
import java.util.Stack;

public class BJ1874 {
	static boolean[] check ; // +. - 저장용 배열 
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		check = new boolean[n*2];
		
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		if(isLIFO(ar,n)) {
			for(int i=0;i<n*2;i++) {
				System.out.println(check[i]?'+':'-');
			}
		}else {
			System.out.println("NO");
		}
	}
	static boolean isLIFO(int[] ar,int n) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		int i=0; // 수열 배열 인덱스 
		int j=1; // 스택에 들어갈 숫자 
		int k=1; // check 배열 인덱스 
		
		// 초기 1 push 
		s.push(1); 
		check[0] = true; 
		
		while(i<n) {
			
			// 스택의 peek와 수열의 숫자가 일치할 경우 
			if(!s.isEmpty() && ar[i] == s.peek()) {
				check[k] = false;
				k++;
				i++;
				s.pop();
				
			}
			// 스택의 숫자보다 수열의 숫자가 작을 경우 -> 불가능 
			else if(!s.isEmpty() && ar[i] < s.peek()) {
				return false;
			}
			// 그 외에의 경우 
			else {
				check[k] = true;
				k++;
				j++;
				s.push(j);
			}
		}
		
		if(s.isEmpty())
			return true;
		else 
			return false;
	}
}
