// 1912번  
// 연속합 
// 동적 계획법 (Dynamic Programming)  

// https://www.crocus.co.kr/371

import java.util.Scanner;
public class BJ1912 {
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ns = new int[n];
		for(int i=0;i<n;i++){
			ns[i] = stdIn.nextInt();
		}
//		System.out.print(bestSum(ns));
		System.out.print(dp(ns));
	}
	// bestSum
	// 연속합 최대 값을 찾는 함수 
	// 그냥 푼 방법 
	static int bestSum(int[] arr) {
		int best = -1000; // 최소값 -1000 기준 
		// 각 인덱스를 시작점으로 오른쪽으로 누적 
		for(int i=0;i<arr.length;i++) {
			int j = i;
			int sum = 0;
			// 최소값 -1000을 기준으로 보다 작으면 stop
			// i부터 끝까지 반복 
			while(sum>=-1000 && j<arr.length) {
				sum+=arr[j];
				j++;
				if(sum>best) { // 최대값 update 
					best = sum;
				}
			}
		}
		return best;
	}
	// dp 
	// 분할 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Bottom-Up 방식 
	static int dp (int[] arr) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			// 점화식 
			if(sum[i-1]+arr[i]>arr[i])
				sum[i] = sum[i-1]+arr[i];
			else
				sum[i] = arr[i];
		}
		
		int max = sum[0];
		for(int j=0;j<sum.length;j++) {
			if(max<sum[j])
				max  = sum[j];
		}
		
		return max;
	}
}
