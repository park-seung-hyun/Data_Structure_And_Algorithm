// 1748번 
// 수 이어 쓰기1 
// 브루트 포스 

import java.util.Scanner;
public class BJ1748 {
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int len = Integer.toString(n).length();
		int cnt = 0;
		int i=0;
		
		// 브루트 포스지만 전체 경우 탐색하지 않고, 
		// 자리 수 기준으로 !! -> 1억이면 9번만 반복 
		for(;i+1<len;i++) {
			// 1 ~ 9 (1) 9
			// 10 ~ 99 (2) 90
			// 100 ~ 999 (3) 900
			// 1000 ~ 9999 (4) 9000 
			cnt += (i+1) * 9 * Math.pow(10, i);
		}
		cnt += len*(n - (Math.pow(10, i)) + 1);
		System.out.println(cnt);
	}
}
