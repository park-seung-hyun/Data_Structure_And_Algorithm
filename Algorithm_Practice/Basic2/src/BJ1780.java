// 1780번 
// 종이의 개수 
// 분할 정복 (Divide and Conquer) 
// 커다란 문제를 작은 문제로 나누어 해결  

// http://qlyh8.tistory.com/100 
// http://janghw.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Divide-and-Conquer-%EB%B6%84%ED%95%A0%EC%A0%95%EB%B3%B5 

import java.util.Scanner;
// 1. 메모리를 엄청 차지하는 멍청한 코드
//public class BJ1780 {
//	static int[] result = new int[3];
//	public static void main (String args[]) {
//		// 입출력 
//		Scanner stdIn = new Scanner(System.in);
//		int N = stdIn.nextInt();
//		int[][] na = new int[N][N];
//		
//		for(int i=0;i<na.length;i++) {
//			for(int j=0;j<na[0].length;j++) {
//				na[i][j] = stdIn.nextInt();
//			}
//		}
//		isSame(na);
//		System.out.printf("%d %d %d", result[0], result[1], result[2]);
//	}
//	// isSame 
//	// 종이가 모두 같은 숫자인지 확인 
//	static void isSame(int[][] p) {
//		
//		int s = p[0][0];
//		boolean flag = false;
//		for(int i=0;i<p.length;i++) {
//			for(int j=0;j<p[0].length;j++) {
//				if(s != p[i][j]) { // 종이 내부 숫자가 같지 않을 경우 분할 
//					cut(p); // 분할 
//					flag = true;
//					break;
//				}
//			}
//			if(flag==true)
//				break;
//		}
//		if(flag == false) { // 종이 내부 숫자가 모두 같을 경우 
//			switch(s) {
//				case -1 :
//					result[0]++;
//					break;
//				case 0:
//					result[1]++;
//					break;
//				case 1:
//					result[2]++;
//					break;
//			}
//		}
//	}
//	// cut 
//	// 종이를 9 분할 
//	static void cut(int[][] p) {
//
//		int len = p.length/3;
//		int[][] newp = new int[len][len];
//		int[][] newp2 = new int[len][len];
//		int[][] newp3 = new int[len][len];
//		
//		int c=0;
//		for(int i=0;i<p.length;i++) {
//				
//				for(int j=0;j<len;j++) {
//					newp[i-c*len][j]=p[i][j];
//				}
//				for(int k=len;k<len*2;k++) {
//					newp2[i-c*len][k-len]=p[i][k];
//				}
//				for(int l=len*2;l<len*3;l++) {
//					newp3[i-c*len][l-len*2]=p[i][l];
//				}
//				
//				if((i+1)%len == 0)	{
//					// 분할한 9개의 종이를 다시 확인 
//					isSame(newp); 
//					isSame(newp2);
//					isSame(newp3);
//					c++;
//				}	
//		}
//	}
//	// pr 
//	// 종이 (배열) 출력용 함수 
//	static void pr(int[][] p) {
//		for(int i=0;i<p.length;i++) {
//			for(int j=0;j<p[0].length;j++) {
//					System.out.printf("%d ",p[i][j]);
//			}
//			System.out.println();
//		}
//	}
//}

// 2. 1번 코드 보완 
// 전체 배열 하나를 두고 인덱싱을 통해 각각의 종이 접근 
public class BJ1780 {
	static int[] result = new int[3]; // -1, 0, 1 
	static int[][] paper; // 해당 배열을 통해 모든 종이에 대해 접근 
	public static void main(String args[]) {
		// 입출력 
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
	// check 
	// 해당 종이가 모두 같은 숫자인지 확인 
	// 크기, 시작x, 시작y를 통해 하나의 배열로 접근 
	static boolean check(int size, int startX, int startY) {
		int n = paper[startX][startY];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(n != paper[startX+i][startY+j]) // 종이 내부 숫자가 틀릴 경우 
					return false;
			}
		}
		// 종이 내부 숫자가 모두 맞을 경우 
		result[n+1]++;
		return true;
	}
	// divide
	// 종이를 9 분할하는 함수 
	// 크기, 시작x, 시작y를 통해 하나의 배열로 접근 
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
