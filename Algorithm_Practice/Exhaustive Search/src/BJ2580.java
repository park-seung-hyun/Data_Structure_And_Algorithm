// 2580번 
// 스도쿠
// DFS (Depth-First-Search)
// Back-Tracking -> 유망하지 않으면 하위 노드를 배제하고 부모 노드로 돌아감. 

// https://wjdgus2951.tistory.com/76
// https://idea-sketch.tistory.com/29
	
import java.util.Scanner;
public class BJ2580 {
	static int[][] sq;
	// 각 행,열, 3x3 사각형 안에 해당 숫자가 있는지 여부 
	static boolean[][] ckRow = new boolean[10][10];
	static boolean[][] ckColumn = new boolean[10][10];
	static boolean[][] ckSquare = new boolean[10][10];
	
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		sq = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sq[i][j] = stdIn.nextInt();
				ckRow[i][sq[i][j]] = true;
				ckColumn[j][sq[i][j]] = true;
				ckSquare[square(i,j)][sq[i][j]] = true;
			}
		}
		fill(0);		
	}
	// square
	// 해당 x,y가 몇 번째 3x3 사각형에 있는지 반환 
	static int square(int x, int y) {
		return (x/3)*3 + (y/3);
	}
	// fill
	// Depth-First-Search
	// Back-Tracking 
	static void fill(int curIndex) {
		
		if(curIndex == 81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.printf("%-2d", sq[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		// 들어오는 칸 순서로 9x9 사각형의 x, y 도출 
		int x = curIndex/9;
		int y = curIndex%9;
		
		// 해당 칸이 채워져있을 경우
		if(sq[x][y] != 0) {
			// 바로 다음 칸 fill 
			fill(curIndex+1);
		}
		// 해당 칸이 빈칸일 경우 
		else {
			// 1~9 숫자를 모두 시도 (DFS)
			// Back-Tracking 
			for(int i=1;i<=9;i++) {
				// 해당 숫자가 현재 위치의 행, 열, 사각형에 포함되지 않을 경우 (가능한 경우)
				if(ckRow[x][i] ==false && ckColumn[y][i] == false && ckSquare[square(x,y)][i] == false) {
					ckRow[x][i] = true;
					ckColumn[y][i] = true;
					ckSquare[square(x,y)][i] = true;
					sq[x][y] = i;
					
					fill(curIndex+1);
					
					// i가 아닐 경우 BackTracking 
					sq[x][y] = 0;
					ckRow[x][i] = false;
					ckColumn[y][i] = false;
					ckSquare[square(x,y)][i] = false;
					
				}
			}
		}		
	}

}
