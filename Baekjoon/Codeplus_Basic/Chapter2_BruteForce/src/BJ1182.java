// 1182번 
// 부분집합의 합 
// 재귀 호출 
// solve -> 재귀 호출 
// solve2 -> 비트 마스크 

import java.util.Scanner;
public class BJ1182 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int s = stdIn.nextInt();
		int[] ar = new int[n]; 
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		
//		int ans = solve(ar, s, 0,0);
//		if(s == 0)
//			System.out.println(ans -1);
//		else 
//			System.out.println(ans);
		
		System.out.println(solve2(n,ar,s));
	}
	static int solve2(int n, int[] ar, int s) {
		int cnt = 0;
		// 만들 수 있는 모든 부분집합 경우 
		for(int i=1;i<(1<<n);i++) { // 000..001 ~ 111...111
			int sum = 0;
			// 현재 값이 있는지 없는지 확인 (-7,-3,-2,5,8)
			for(int j =0;j<n;j++) { // 0 ~ n-1
				// 있을 경우 sum에 누적 
				 if((i&(1<<j)) != 0)
					 sum += ar[j];
			}
			if(sum == s)
				cnt++;
		}
		return cnt;
	}
	static int solve(int[] ar,int s, int i, int sum) {
		// sum == s 더라도 뒷부분에서 다시 조건을 만족할 수 도 있으므로 i==ar.length 추가 
		if(sum == s && i== ar.length) { // 정답인 경우 (1)
			return 1;
		}
		if(i==ar.length) { // 불가능한 경우 (2)
			return 0;
		}
		// 다음 경우 호출 (3)
		int num = 0;
		num +=solve(ar, s, i+1, sum+ar[i]);
		num +=solve(ar, s, i+1, sum);
		return num;
	}
}
