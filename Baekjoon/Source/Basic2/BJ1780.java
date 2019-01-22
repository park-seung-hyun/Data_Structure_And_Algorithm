// 1780번 
// 종이의 개수 
// 분할 정복 (Divide and Conquer) 
// 커다란 문제를 작은 문제로 나누어 해결

import java.util.Scanner;

public class BJ1780 {
	static int[] result = new int[3];
	static int[][] paper;
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		paper = new int[N][N];
		
		for(int i=0;i<paper.length;i++) {
			for(int j=0;j<paper[0].length;j++) {
				paper[i][j] = stdIn.nextInt();
			}
		}
		divide(N, 0, 0);
		System.out.printf("%d %d %d", result[0], result[1], result[2]);
		
	}
	static boolean check(int size, int startX, int startY) {
		int n = paper[startX][startY];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(n != paper[startX+i][startY+j])
					return false;
			}
		}
		result[n+1]++;
		return true;
	}
	static void divide(int size, int startX, int startY) {
		if(check(size, startX, startY)) {
			return;
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				divide(size/3, startX +(i*size/3), startY +(j*size/3));
			}
		}
		
	}
}
