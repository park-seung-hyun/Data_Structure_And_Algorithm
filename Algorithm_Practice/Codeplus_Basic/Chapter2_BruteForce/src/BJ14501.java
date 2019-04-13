// 14501번 
// 퇴사  
// 재귀 호출 

//import java.util.Scanner;
//public class BJ14501 {
//	static int max = 0;
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int d = stdIn.nextInt();
//		int[] t = new int[d+1];
//		int[] p = new int[d+1];
//		for(int i=1;i<=d;i++) {
//			t[i] = stdIn.nextInt();
//			p[i] = stdIn.nextInt();
//		}
//		solve(t,p,d,0,1);
//		System.out.println(max);
//	}
//	static void solve(int[] t, int[] p,int n, int sum, int day) {
//		if(day == n+1) { // 정답인 경우 (1)
//			if(max<sum)
//				max = sum;
//			return;
//		}
//		if(day>n+1){ // 불가능한 경우 (2)
//			return ;
//		}
//		// 다음 경우 호출 (3)
//		solve(t,p,n, sum+p[day], day+t[day]);
//		solve(t,p,n, sum, day+1);
//	}
//}

import java.util.Scanner;
public class BJ14501{
	static int[][] schedule;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		schedule = new int[n][2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				schedule[i][j] = stdIn.nextInt();
			}
		}
		go(0,0,n);
		System.out.println(ans);
	}
	static void go(int day, int price, int n) {
		if(day > n) return;
		if(day == n) {
			if(ans < price) ans = price;
			return;
		}
		go(day + schedule[day][0], price + schedule[day][1],n); // 해당 날 상담 
		go(day + 1, price,n); // 해당 날 상담 ㄴㄴ 
	}
}