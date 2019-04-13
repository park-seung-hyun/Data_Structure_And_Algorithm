// 1992번 
// 쿼드트리 
// 분할 정복 (Divide and Conquer) 
// 커다란 문제를 작은 문제로 나누어 해결 
// 1780번과 동일 
// 괄호 위치 선정 

import java.util.Scanner;
public class BJ1992 {
	static int[][] video;
	public static void main (String args[]) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		video = new int[N][N];
		for(int i=0;i<N;i++) {
			String line = stdIn.next();
			for(int j=0;j<N;j++) {
				video[i][j] = line.charAt(j) - '0';
			}
		}
		divide(N,0,0);
	}
	// check 
	// 해당 영상이 모두 같은 숫자인지 확인 
	// 크기, 시작x, 시작y를 통해 하나의 배열로 접근 
	static int check(int size, int startX, int startY) {
		int n = video[startX][startY];
		for(int i=0;i< size;i++) {
			for(int j=0;j<size;j++) {
				if(n!=video[startX+i][startY+j])
					return -1;
			}
		}
		return n;
	}
	// divide
	// 영상을 4 분할하는 함수 
	// 크기, 시작x, 시작y를 통해 하나의 배열로 접근 
	static void divide(int size, int startX, int startY) {
		int n = check(size, startX, startY);
		if(n != -1) {
			System.out.print(n);
			return;
		}
		// Divide가 한번 호출되면 괄호 () 생성 
		System.out.print('(');
		for(int i = 0;i<2;i++) {
			for(int j=0;j<2;j++) {

				divide(size/2, startX + (i*size/2), startY + (j*size/2));
			}
		}
		// Divide가 한번 호출되면 괄호 () 생성 
		System.out.print(')');
			
	}
	static void pr(int[][] p) {
	for(int i=0;i<p.length;i++) {
		for(int j=0;j<p[0].length;j++) {
				System.out.printf("%d ",p[i][j]);
		}
		System.out.println();
	}
}
}
