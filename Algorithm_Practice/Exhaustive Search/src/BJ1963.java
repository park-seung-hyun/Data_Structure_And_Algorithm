// 1963번 
// 소수 경로 
// BFS
// 소수 (Prime)
// Java 형 변환 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1963 {
	// 해당 숫자가 소수인지 아닌지 를 저장하는 배열 
	static boolean[] isNotPrime = new boolean[10000];
	// 소수 경로 최솟값 
	static int MIN = 2000000000;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int[][] pw = new int[t][2];
		for(int i=0;i<t;i++) {
			pw[i][0] = stdIn.nextInt();
			pw[i][1] = stdIn.nextInt();
		}
		notPrime();

		for(int i=0;i<t;i++) {
			changePW(pw[i]);
			System.out.println(MIN);
			MIN = 2000000000;
		}
		
	}
	// changePW
	// 비밀번호를 변경하는데 최소 경로를 알려주는 알고리즘 
	// BFS
	// 큐 사용 
	// 어렵지 않지만 형 변환이 복잡했음. 
	static void changePW(int[] pw) {
		// 해당 번호를 방문했는지 여부 
		int[] cntAr = new int[10000];
		int beforePW = pw[0];
		int afterPW = pw[1];
		// Integer -> Charater Array
		char[] stbPW = Integer.toString(beforePW).toCharArray();
		
		Queue<char[]> q = new LinkedList<char[]>();
		q.add(stbPW);
		
		while(!q.isEmpty()) {

			// 최솟값보다 현재 경로가 큰 경우 제거 
			if(cntAr[Integer.parseInt(String.valueOf(q.peek()))] > MIN) {
				q.remove();
			}
			// 소수가 아닌 경우 제거 
			else if(isNotPrime[Integer.parseInt(String.valueOf(q.peek()))]) { 
				q.remove();
				
			}
			// 정답을 찾은 경우 
			else if(Integer.parseInt(String.valueOf(q.peek())) == afterPW) { 

				// 더 빠른 경우를 염두하여 
				// 최솟값 여부 판단 
				if(MIN > cntAr[Integer.parseInt(String.valueOf(q.peek()))]) {
					MIN = cntAr[Integer.parseInt(String.valueOf(q.peek()))];
				}
				q.remove();
				
			}
			// 그 외 경우 
			else {
				char[] qp = q.peek();
				q.remove();
				int cntCu = cntAr[Integer.parseInt(String.valueOf(qp))];
				
				for(int i=0;i<4;i++) {
					for(int j=0;j<10;j++) {
						// 첫 번째 자리가 0인 경우는 제외 
						// 같은 숫자 제외 
						if(!(i==0&&j==0) && !(qp[i]==(char)(j + '0'))) { 
							char[] t = qp.clone();
							t[i] = (char) (j + '0');
							
							// 방문했던 숫자를 다시 방문하지 않도록 방지 
							if(cntAr[Integer.parseInt(String.valueOf(t))] ==0 || cntAr[Integer.parseInt(String.valueOf(t))] > cntCu + 1) {
								cntAr[Integer.parseInt(String.valueOf(t))] = cntCu + 1;
								q.add(t);
							}
						}					
					}
				}
			}
		}		
	}
	static void notPrime() {
		for(int i=2;i*i<10000;i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i;j<10000;j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		isNotPrime[1]=true;
	}
}
