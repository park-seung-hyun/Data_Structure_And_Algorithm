// 14501번 
// 퇴사  
// 재귀 호출 

import java.util.Scanner;
public class BJ14501 {
	static int max = 0;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int d = stdIn.nextInt();
		int[] t = new int[d+1];
		int[] p = new int[d+1];
		for(int i=1;i<=d;i++) {
			t[i] = stdIn.nextInt();
			p[i] = stdIn.nextInt();
		}
		solve(t,p,d,0,1);
		System.out.println(max);
	}
	static void solve(int[] t, int[] p,int n, int sum, int day) {
		if(day == n+1) { // 정답인 경우 (1)
			if(max<sum)
				max = sum;
			return;
		}
		if(day>n+1){ // 불가능한 경우 (2)
			return ;
		}
		// 다음 경우 호출 (3)
		solve(t,p,n, sum+p[day], day+t[day]);
		solve(t,p,n, sum, day+1);
	}
}
