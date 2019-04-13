// 삼성 기출 
// 5373번
// 큐빙 
// 시뮬레이션 
// 역대급 노가다..
// 배열일 경우 temp 생성할 때 clone 까먹지 말기.

import java.util.Scanner;
public class BJ5373 {
	static Cube cube;
	static char[] color = {'w','y','g','b','r','o'};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int t = stdIn.nextInt();
		char[][][] fs = new char[6][3][3];

		for(int i=0;i<t;i++) {
			for(int j=0;j<6;j++) {
				for(int k=0;k<3;k++) {
					for(int k2=0;k2<3;k2++) {
						fs[j][k][k2] = color[j];
					}
				}
			}
			cube= new Cube(fs[0],fs[1],fs[2],fs[3],fs[4],fs[5]);
			int n = stdIn.nextInt();
			for(int j=0;j<n;j++) {
				String temp = stdIn.next();
				simulate(temp);
			}
			print();
			// 출력 
		}
	}
	static void print() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.printf("%c", cube.u[i][j]);
			}
			System.out.println();
		}
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.printf("%c", cube.f[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.printf("%c", cube.b[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.printf("%c", cube.l[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.printf("%c", cube.r[i][j]);
//			}
//			System.out.println();
//		}
	}
	static void simulate(String s) {
		char face = s.charAt(0);
		char dir = s.charAt(1);
		if(face == 'F' || face == 'B') {
			if(face == 'F') { // F
				if(dir == '+') {
					char[] temp = cube.u[2].clone();
					for(int i=0;i<3;i++) {
						cube.u[2][i] = cube.l[0][i];
					}
					for(int i=0;i<3;i++) {
						 cube.l[0][i] = cube.d[0][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.d[0][2-i] = cube.r[2][i];
					}
					for(int i=0;i<3;i++) {
						cube.r[2][i] = temp[i];
					}
					char t = cube.f[0][0];
					cube.f[0][0] = cube.f[2][0];
					cube.f[2][0] = cube.f[2][2];
					cube.f[2][2] = cube.f[0][2];
					cube.f[0][2] = t;
					t = cube.f[0][1];
					cube.f[0][1] = cube.f[1][0];
					cube.f[1][0] = cube.f[2][1];
					cube.f[2][1] = cube.f[1][2];
					cube.f[1][2] = t;
				}else {
					
					char[] temp = cube.u[2].clone();
					for(int i=0;i<3;i++) {
						cube.u[2][i] = cube.r[2][i];
					}
					for(int i=0;i<3;i++) {
						cube.r[2][i] = cube.d[0][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.d[0][2-i] = cube.l[0][i];
					}
					for(int i=0;i<3;i++) {
						cube.l[0][i] = temp[i];
					}
					
					char t = cube.f[0][0];
					cube.f[0][0] = cube.f[0][2];
					cube.f[0][2] = cube.f[2][2];
					cube.f[2][2] = cube.f[2][0];
					cube.f[2][0] = t;
					t = cube.f[0][1];
					cube.f[0][1] = cube.f[1][2];
					cube.f[1][2] = cube.f[2][1];
					cube.f[2][1] = cube.f[1][0];
					cube.f[1][0] = t;
				}
				
				
			}else { // B
				if(dir == '+') {
					char[] temp = cube.u[0].clone();
					for(int i=0;i<3;i++) {
						cube.u[0][i] = cube.r[0][i];
					}
					for(int i=0;i<3;i++) {
						cube.r[0][i] = cube.d[2][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.d[2][2-i] = cube.l[2][i];
					}
					for(int i=0;i<3;i++) {
						cube.l[2][i] = temp[i];
					}
					char t = cube.b[0][0];
					cube.b[0][0] = cube.b[2][0];
					cube.b[2][0] = cube.b[2][2];
					cube.b[2][2] = cube.b[0][2];
					cube.b[0][2] = t;
					t = cube.b[0][1];
					cube.b[0][1] = cube.b[1][0];
					cube.b[1][0] = cube.b[2][1];
					cube.b[2][1] = cube.b[1][2];
					cube.b[1][2] = t;
				}else {
					char[] temp = cube.u[0].clone();
					for(int i=0;i<3;i++) {
						cube.u[0][i] = cube.l[2][i];
					}
					for(int i=0;i<3;i++) {
						cube.l[2][i] = cube.d[2][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.d[2][2-i] = cube.r[0][i];
					}
					for(int i=0;i<3;i++) {
						cube.r[0][i] = temp[i];
					}
					char t = cube.b[0][0];
					cube.b[0][0] = cube.b[0][2];
					cube.b[0][2] = cube.b[2][2];
					cube.b[2][2] = cube.b[2][0];
					cube.b[2][0] = t;
					t = cube.b[0][1];
					cube.b[0][1] = cube.b[1][2];
					cube.b[1][2] = cube.b[2][1];
					cube.b[2][1] = cube.b[1][0];
					cube.b[1][0] = t;
				}
			}
		}else if(face == 'L' || face == 'R'){
			if(face == 'L') { // L
				if(dir == '+') {
					char temp;
					for(int i=0;i<3;i++) {
						temp = cube.u[i][0];
						cube.u[i][0] = cube.b[i][0];
						cube.b[i][0] = cube.d[i][0];
						cube.d[i][0] = cube.f[i][0];
						cube.f[i][0] = temp;
					}
					char t = cube.l[0][0];
					cube.l[0][0] = cube.l[0][2];
					cube.l[0][2] = cube.l[2][2];
					cube.l[2][2] = cube.l[2][0];
					cube.l[2][0] = t;
					t = cube.l[0][1];
					cube.l[0][1] = cube.l[1][2];
					cube.l[1][2] = cube.l[2][1];
					cube.l[2][1] = cube.l[1][0];
					cube.l[1][0] = t;
				}else {
					char temp;
					for(int i=0;i<3;i++) {
						temp = cube.u[i][0];
						cube.u[i][0] = cube.f[i][0];
						cube.f[i][0] = cube.d[i][0];
						cube.d[i][0] = cube.b[i][0];
						cube.b[i][0] = temp;
					}
					char t = cube.l[0][0];
					cube.l[0][0] = cube.l[2][0];
					cube.l[2][0] = cube.l[2][2];
					cube.l[2][2] = cube.l[0][2];
					cube.l[0][2] = t;
					t = cube.l[0][1];
					cube.l[0][1] = cube.l[1][0];
					cube.l[1][0] = cube.l[2][1];
					cube.l[2][1] = cube.l[1][2];
					cube.l[1][2] = t;
				}
			}else { // R
				if(dir == '+') {
					char temp;
					for(int i=0;i<3;i++) {
						temp = cube.u[i][2];
						cube.u[i][2] = cube.f[i][2];
						cube.f[i][2] = cube.d[i][2];
						cube.d[i][2] = cube.b[i][2];
						cube.b[i][2] = temp;
					}
					char t = cube.r[0][0];
					cube.r[0][0] = cube.r[2][0];
					cube.r[2][0] = cube.r[2][2];
					cube.r[2][2] = cube.r[0][2];
					cube.r[0][2] = t;
					t = cube.r[0][1];
					cube.r[0][1] = cube.r[1][0];
					cube.r[1][0] = cube.r[2][1];
					cube.r[2][1] = cube.r[1][2];
					cube.r[1][2] = t;
				}else {
					char temp;
					for(int i=0;i<3;i++) {
						temp = cube.u[i][2];
						cube.u[i][2] = cube.b[i][2];
						cube.b[i][2] = cube.d[i][2];
						cube.d[i][2] = cube.f[i][2];
						cube.f[i][2] = temp;
					}
					char t = cube.r[0][0];
					cube.r[0][0] = cube.r[0][2];
					cube.r[0][2] = cube.r[2][2];
					cube.r[2][2] = cube.r[2][0];
					cube.r[2][0] = t;
					t = cube.r[0][1];
					cube.r[0][1] = cube.r[1][2];
					cube.r[1][2] = cube.r[2][1];
					cube.r[2][1] = cube.r[1][0];
					cube.r[1][0] = t;
				}
			}
		}else {
			if(face == 'U') { // U
				if(dir == '+') {
					char[] temp = cube.f[0].clone();
					for(int i=0;i<3;i++) {
						cube.f[0][i] = cube.r[2-i][0];
					}
					for(int i=0;i<3;i++) {
						cube.r[2-i][0] = cube.b[2][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.b[2][2-i] = cube.l[2-i][2];
					}
					for(int i=0;i<3;i++) {
						cube.l[2-i][2] = temp[i];
					}
					char t = cube.u[0][0];
					cube.u[0][0] = cube.u[2][0];
					cube.u[2][0] = cube.u[2][2];
					cube.u[2][2] = cube.u[0][2];
					cube.u[0][2] = t;
					t = cube.u[0][1];
					cube.u[0][1] = cube.u[1][0];
					cube.u[1][0] = cube.u[2][1];
					cube.u[2][1] = cube.u[1][2];
					cube.u[1][2] = t;
				}else {
					char[] temp = cube.f[0].clone();
					for(int i=0;i<3;i++) {
						cube.f[0][i] = cube.l[2-i][2];
					}
					for(int i=0;i<3;i++) {
						cube.l[2-i][2] = cube.b[2][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.b[2][2-i] = cube.r[2-i][0];
					}
					for(int i=0;i<3;i++) {
						cube.r[2-i][0] = temp[i];
					}
					char t = cube.u[0][0];
					cube.u[0][0] = cube.u[0][2];
					cube.u[0][2] = cube.u[2][2];
					cube.u[2][2] = cube.u[2][0];
					cube.u[2][0] = t;
					t = cube.u[0][1];
					cube.u[0][1] = cube.u[1][2];
					cube.u[1][2] = cube.u[2][1];
					cube.u[2][1] = cube.u[1][0];
					cube.u[1][0] = t;
				}
			}else { // D
				if(dir == '+') {
					char[] temp = cube.f[2].clone();
					for(int i=0;i<3;i++) {
						cube.f[2][i] = cube.l[2-i][0];
					}
					for(int i=0;i<3;i++) {
						cube.l[2-i][0] = cube.b[0][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.b[0][2-i]= cube.r[2-i][2];
					}
					for(int i=0;i<3;i++) {
						cube.r[2-i][2] = temp[i];
					}
					char t = cube.d[0][0];
					cube.d[0][0] = cube.d[2][0];
					cube.d[2][0] = cube.d[2][2];
					cube.d[2][2] = cube.d[0][2];
					cube.d[0][2] = t;
					t = cube.d[0][1];
					cube.d[0][1] = cube.d[1][0];
					cube.d[1][0] = cube.d[2][1];
					cube.d[2][1] = cube.d[1][2];
					cube.d[1][2] = t;
				}else {
					char[] temp = cube.f[2].clone();
					for(int i=0;i<3;i++) {
						cube.f[2][i] = cube.r[2-i][2];
					}
					for(int i=0;i<3;i++) {
						cube.r[2-i][2] = cube.b[0][2-i];
					}
					for(int i=0;i<3;i++) {
						cube.b[0][2-i]= cube.l[2-i][0];
					}
					for(int i=0;i<3;i++) {
						cube.l[2-i][0] = temp[i];
					}
					char t = cube.d[0][0];
					cube.d[0][0] = cube.d[0][2];
					cube.d[0][2] = cube.d[2][2];
					cube.d[2][2] = cube.d[2][0];
					cube.d[2][0] = t;
					t = cube.d[0][1];
					cube.d[0][1] = cube.d[1][2];
					cube.d[1][2] = cube.d[2][1];
					cube.d[2][1] = cube.d[1][0];
					cube.d[1][0] = t;
				}
			}
		}
	}
}
class Cube{
	char[][] u;
	char[][] d;
	char[][] l;
	char[][] r;
	char[][] f;
	char[][] b;
	Cube(char[][] u,char[][] d,char[][] l,char[][] r,char[][] f, char[][] b){
		this.u = u;
		this.d = d;
		this.l = l;
		this.r = r;
		this.f = f;
		this.b = b;
	}
}
