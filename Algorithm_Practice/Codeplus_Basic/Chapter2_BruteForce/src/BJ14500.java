// 14500번
// 테트로미노  

//import java.util.Scanner;
//public class BJ14500 {
//	// 테트로미노의 모든 모양에 대해 위치 저장
//	// 0,0을 기준으로 저장 
//	static int[][][] block = {
//			
//			// []
//			// []
//			// [][]
//			{{1,0},{2,0},{2,1}},
//			{{1,0},{0,1},{0,2}},
//			{{0,1},{1,1},{2,1}},
//			{{0,1},{0,2},{-1,2}},
//			{{1,0},{2,0},{2,-1}},
//			{{1,0},{1,1},{1,2}},
//			{{1,0},{2,0},{0,1}},
//			{{0,1},{0,2},{1,2}},
//			
//			// [][][][]
//			{{0,1},{0,2},{0,3}},
//			{{1,0},{2,0},{3,0}},
//			
//			// [][]
//			// [][]
//			{{1,0},{0,1},{1,1}},
//			
//			//   [][]
//			// [][]
//			{{1,0},{1,1},{2,1}},
//			{{0,1},{-1,1},{-1,2}},
//			{{0,1},{1,1},{1,2}},
//			{{1,0},{1,-1},{2,-1}},
//			
//			//   []
//			// [][][]
//			{{0,1},{0,2},{1,1}},
//			{{0,1},{0,2},{-1,1}},
//			{{1,0},{2,0},{1,-1}},
//			{{1,0},{2,0},{1,1}},
//	};
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		int[][] ar = new int[n][m];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				ar[i][j] = stdIn.nextInt();
//			}
//		}
//		solve(ar, n,m);
//	}
//	static void solve(int[][] ar, int n, int m) {
//		int max = 0;
//		for(int k=0;k<19;k++) {
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					int sum = ar[i][j];
//					boolean flag = true;
//					
//					for(int s=0;s<3;s++) {
//						int a = block[k][s][0] + i;
//						int b = block[k][s][1] + j;
//						
//						if(a>=0 && a<n && b>=0 && b<m) {
//							sum += ar[a][b];
//						}else {
//							flag = false;
//							break;
//						}
//					}
//					if(flag == true && sum>max) {
//						max = sum;
//					}
//				}
//			}
//		}
//		
//		System.out.println(max);
//	}
//}

import java.util.Scanner;
public class BJ14500{
	static int[][][] block = {
	
		// []
		// []
		// [][]
		{{1,0},{2,0},{2,1}},
		{{1,0},{0,1},{0,2}},
		{{0,1},{1,1},{2,1}},
		{{0,1},{0,2},{-1,2}},
		{{1,0},{2,0},{2,-1}},
		{{1,0},{1,1},{1,2}},
		{{1,0},{2,0},{0,1}},
		{{0,1},{0,2},{1,2}},
	
		// [][][][]
		{{0,1},{0,2},{0,3}},
		{{1,0},{2,0},{3,0}},
		
		// [][]
		// [][]
		{{1,0},{0,1},{1,1}},
	
		//   [][]
		// [][]
		{{1,0},{1,1},{2,1}},
		{{0,1},{-1,1},{-1,2}},
		{{0,1},{1,1},{1,2}},
		{{1,0},{1,-1},{2,-1}},
	
		//   []
		// [][][]
		{{0,1},{0,2},{1,1}},
		{{0,1},{0,2},{-1,1}},
		{{1,0},{2,0},{1,-1}},
		{{1,0},{2,0},{1,1}},
	};
	static int[][] map;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		
		int max = 0;
		for(int b=0;b<19;b++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int sx = i;
					int sy = j;
					int sum = map[sx][sy];
					boolean flag = true;
					for(int f = 0;f<3;f++) {
						int nx = sx + block[b][f][0];
						int ny = sy + block[b][f][1];
						if(nx <0 || ny < 0 || nx >= n || ny >= m) {
							flag = false;
							break;				
						}
						sum += map[nx][ny];
					}
					if(flag == false) continue;
					if(sum > max) max = sum;
				}
			}		
		}
		System.out.println(max);
		
		
	}
}