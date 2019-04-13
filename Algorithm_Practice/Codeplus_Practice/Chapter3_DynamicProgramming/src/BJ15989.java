// 15989번
// 1,2,3 더하기4  
// DP
// 순서 다른 것은 같은 것 -> 각각의 숫자마다 d배열을 채우고 다음 숫자 넘어가기 

import java.util.Scanner;
public class BJ15989 {
	static int[][] d = new int[4][10001];
	static int[] d2 = new int[10001];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
//		dp();
//		for(int i=0;i<t;i++) {
//			int a = stdIn.nextInt();
//			System.out.println(d[3][a]);
//		}
		dp2();
		for(int i=0;i<t;i++) {
			int a = stdIn.nextInt();
			System.out.println(d2[a]);
		}
	}
	static void dp2() {
		// 1차원 배열 사용 
		// 9095번에서 1,2,3 숫자를 반복하는 반복문을 밖으로 하면 됨.
		d2[0] = 1;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=10000;j++) {
				if(j-i>=0) d2[j] += d2[j-i];
			}
		}
	}
	static void dp() {
		for(int i=1;i<=3;i++) d[i][0] = 1;
		for(int i=0;i<=10000;i++) d[1][i] = 1;
		
		for(int i=2;i<=3;i++) {
			for(int j=1;j<=10000;j++) {
				d[i][j] += d[i-1][j];
				if(j-i>=0) {
					d[i][j] += d[i][j-i];
//					d[i][j] += (d[i][j-i] - d[i-1][j-i]);
				}
			}
		}
//		for(int i=0;i<=3;i++) {
//			for(int j=0;j<=10;j++) {
//				System.out.printf("%d ", d[i][j]);
//			}
//			System.out.println();
//		}
		
	}
}
