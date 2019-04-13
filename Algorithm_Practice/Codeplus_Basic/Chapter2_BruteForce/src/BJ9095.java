// 9095번
// 1,2,3 더하기 
// solve -> 브루트 포스 
// solve2 -> 재귀 호출 
// solve3 -> 다이나믹 프로그래밍 

//import java.util.Scanner;
//public class BJ9095 {
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int n = stdIn.nextInt();
//			
////			System.out.println(solve(n));
//			System.out.println(solve2(0,n));
////			System.out.println(solve3(n));
//		}
//	}
//	static int solve3(int n) {
//		if(n==1)
//			return 1;
//		if(n==2)
//			return 2;
//		if(n==3)
//			return 4;
//		
//		int[] dp = new int[n+1];
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 4;
//		for(int i=4;i<=n;i++) {
//			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//		}
//		return dp[n];
//	}
//	static int solve2(int sum, int goal) {
//		if(sum == goal) // 정답인 경우 (1)
//			return 1;
//		if(sum > goal) // 불가능한 경우 (2)
//			return 0;
//		
//		// 다음 경우 호출 (3)
//		int num = 0;
//		num+=solve2(sum+1, goal);
//		num+=solve2(sum+2, goal);
//		num+=solve2(sum+3, goal);
//		
//		return num;
//	}
//	static int solve(int n) {
//		int count = 0;
//		for(int i=1;i<=3;i++) {
//			if(i == n)
//				count ++;
//			for(int i2=1;i2<=3;i2++) {
//				if(i+i2 == n)
//					count ++;
//				for(int i3=1;i3<=3;i3++) {
//					if(i+i2+i3 == n)
//						count ++;
//					for(int i4=1;i4<=3;i4++) {
//						if(i+i2+i3+i4 == n)
//							count ++;
//						for(int i5=1;i5<=3;i5++) {
//							if(i+i2+i3+i4+i5 == n)
//								count ++;
//							for(int i6=1;i6<=3;i6++) {
//								if(i+i2+i3+i4+i5+i6 == n)
//									count ++;
//								for(int i7=1;i7<=3;i7++) {
//									if(i+i2+i3+i4+i5+i6+i7 == n)
//										count ++;
//									for(int i8=1;i8<=3;i8++) {
//										if(i+i2+i3+i4+i5+i6+i7+i8== n)
//											count ++;
//										for(int i9=1;i9<=3;i9++) {
//											if(i+i2+i3+i4+i5+i6+i7+i8+i9 == n)
//												count ++;
//											for(int i10=1;i10<=3;i10++) {
//												if(i+i2+i3+i4+i5+i6+i7+i8+i9+i10 == n)
//													count ++;
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		return count;
//	}
//}

import java.util.Scanner;
public class BJ9095{
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			solve(n);
		}
	}
	static void solve(int n) {
		
		System.out.println(go(0,n));
		
	}
	static int go(int sum, int n) {
		
		if(sum == n) return 1;
		if(sum > n) return 0;
		int cnt = 0;
		cnt += go(sum+1, n);
		cnt += go(sum+2, n);
		cnt += go(sum+3, n);
		return cnt;
	}
}