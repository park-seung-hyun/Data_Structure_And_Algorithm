// 2740번  
// 행렬 곱셈 

import java.util.Scanner;
public class BJ2740 {
	public static void main(String[] args) {
		// 입출력
		Scanner stdIn = new Scanner(System.in);
		
		int N = stdIn.nextInt();
		int M = stdIn.nextInt();
		int[][] A = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				A[i][j] = stdIn.nextInt();
			}
		}
		
		M = stdIn.nextInt();
		int K = stdIn.nextInt();
		int[][] B = new int[M][K];
		for(int i=0;i<M;i++) {
			for(int j=0;j<K;j++) {
				B[i][j] = stdIn.nextInt();
			}
		}
		int[][] result = productMatrix(A,B);
		
		for(int i=0;i< N;i++) {
			for(int j=0;j<K;j++) {
				System.out.printf("%d ",result[i][j]);
			}
			System.out.println();
		}
		
	}
	// productMatrix 
	// 두 행렬을 곱하는 함수 
	static int[][] productMatrix(int[][]a, int[][] b) {
		
		// N * K 
		int[][] result = new int[a.length][b[0].length];
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				for(int k=0;k<b.length;k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return result;
	}
}
