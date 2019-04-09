// 1107번 
// 리모컨 
// 브루트 포스 

import java.util.ArrayList;
import java.util.Scanner;
//public class BJ1107 {
//	static final int max = 999999;
//	static int[] Num; // 1 -> 고장
//	static int dif = Integer.MAX_VALUE;
//	static int des;
//	static int ans = 0;
//	static ArrayList<Integer> al = new ArrayList<Integer>();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		des = stdIn.nextInt(); // 도착지 
//		int t = stdIn.nextInt();
//		Num = new int[10]; // 고장난 버튼 
//		for(int i=0;i<t;i++) { 
//			int n = stdIn.nextInt();
//			Num[n] = 1;
//		}
//		solve();
//	}
//	static void solve() {
//		dif = Math.abs(100 - des);
//		// 고장나지 않은 버튼들 
//		for(int i=0;i<10;i++) { 
//			if(Num[i] == 0) al.add(i);
//		}
//		String num = "";
//		for(int i : al) {
//			clickButton(num + "" + i, 1);
//		}
//		System.out.println(dif);
//	}
//	static void clickButton(String num, int cnt){
//		int numInt = Integer.parseInt(num);
//		if(cnt >= 7) return;
//		if(Math.abs(numInt - des) + cnt < dif) {
//			dif = Math.abs(numInt - des) + cnt;
//		}
//		for(int i : al) {
//			clickButton(num + "" + i, cnt+1);
//		}
//	}
//}

public class BJ1107{
	static int[] button = new int[10];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		for(int i=0;i<m;i++) {
			int b = stdIn.nextInt();
			button[b] = 1;
		}
		solve(n);
	}
	static int getLength(int n) {
		int len = 0;
		if(n == 0) { 
			if(button[0] == 1) return 0;
			else return 1;
		}
		while(n>0) {
			if(button[n%10] == 1) return 0;
			n /= 10;
			len++;
		}
		return len;
	}
	static void solve(int n) {
		
		int ans = Math.abs(n-100);
		
		// 브루트 포스 
		for(int i=0;i<=1000000;i++) {
			// 일단 가능한 모든 곳 이동 
			int len = getLength(i);
			if(len == 0) continue;
			if(ans > len + Math.abs(n-i)) ans = len + Math.abs(n-i);
		}
		System.out.println(ans);	
	}
}
