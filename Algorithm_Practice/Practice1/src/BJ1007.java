// 1007번  
// 벡터 매칭
// 조합 (Combination)

// https://stack07142.tistory.com/25
// https://limkydev.tistory.com/156

import java.util.Scanner;
public class BJ1007 {
	static double min;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int[][][] ar = new int[t][][];
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			ar[i] = new int[n][2];
			for(int j=0;j<n;j++) {
				ar[i][j][0] = stdIn.nextInt();
				ar[i][j][1] = stdIn.nextInt();
			}
		}
		for(int i=0;i<t;i++) {
			min = 2000000000;
			getMinimum(ar[i]);
		}
	}	
	// getMinimum
	// 벡터 매칭에 있는 벡터의 합의 길이의 최솟값을 구하는 함수 
	static void getMinimum(int[][] ar) {
		int[] arr = new int[ar.length];
		// 조합 사용 
		// nC(n/2)
		// 시작점 절반만 구하면 됨.
		combination(arr, 0,ar.length,ar.length/2,0, ar);
		System.out.println(min);
	}
	// combination 
	// 조합 
	public static void combination(int[] arr, int index, int n, int r, int target, int[][] ar) { 
		if (r == 0) { 
			calculate(arr, index, ar); 
		}
		else if (target == n) return; 
		else { 
			arr[index] = target; 
			combination(arr, index + 1, n, r - 1, target + 1, ar); 
			combination(arr, index, n, r, target + 1, ar); 
			} 
	}
	// calculate 
	// 조합해서 나온 원소들로 벡터의 최솟값 연산 
	public static void calculate(int[] arr, int length, int[][] ar) { 
		
		boolean[] check = new boolean[ar.length];

		for (int i = 0; i < length; i++) {
			check[arr[i]] = true; 
		}
		int x=0;
		int y=0;
		for(int i=0;i<ar.length;i++) {
			if(check[i]) {
				x+=ar[i][0];
				y+=ar[i][1];
			}else {
				x-=ar[i][0];
				y-=ar[i][1];
			}
		}
		
		if(min>getDistance(x,y))
			min = getDistance(x,y);
	}
	// getDistance 
	// 벡터의 길이 계산 
	static double getDistance(int x, int y) {
		double dx = x;
		double dy = y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
}
