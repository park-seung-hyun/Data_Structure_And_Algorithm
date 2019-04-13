import java.util.ArrayList;
import java.util.Scanner;

//public class BJ2580 {
//	static int[][] map = new int[9][9];
//	static ArrayList<Pos> blank = new ArrayList<Pos>();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++) {
//				map[i][j] = stdIn.nextInt();
//				if(map[i][j] == 0) {
//					blank.add(new Pos(i,j));
//				}
//			}
//		}
//		
//		int x = blank.get(0).x;
//		int y = blank.get(0).y;
//		for(int i=1;i<=9;i++) {
//			
//			if(impossible(x,y,i)) continue;
//			map[x][y] = i;
//			go(1);
//			map[x][y] = 0;
//			
//		}
//		
//	}
//	static boolean impossible(int x, int y, int num) {
//		int[] row = map[x];
//		int[] col = new int[9];
//		for(int i=0;i<9;i++) col[i] = map[i][y];
//		
//		for(int r : row) {
//			if(r == num) return true;
//		}
//		for(int c: col) {
//			if(c == num) return true;
//		}
//		
//		int sx = (x/3) *3;
//		int sy = (y/3) *3;
//		for(int i=sx;i<sx+3;i++) {
//			for(int j=sy;j<sy+3;j++) {
//				if(map[i][j] == num) return true;
//			}
//		}
//		return false;
//	}
//	static void printMap() {
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	static void go(int id) {
//		if(id == blank.size()) {
//			printMap();
//			System.exit(0);
//		}
//		int x = blank.get(id).x;
//		int y = blank.get(id).y;
//		for(int i=1;i<=9;i++) {
//			if(impossible(x,y,i)) continue;
//			
//			map[x][y] = i;
//			go(id+1);
//			map[x][y] = 0;
//		}
//	}
//}
//class Pos{
//	int x;
//	int y;
//	Pos(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}


public class BJ2580{
	static int[][] map = new int[9][9];
	static int[][] row = new int[9][10]; // i번째 row에 j가 잇나?
	static int[][] col = new int[9][10]; // i번째 col에 j가 잇나?
	static int[][] square = new int[9][10]; // i번째 square에 j가 잇나?
	
	static ArrayList<Pos> blank = new ArrayList<Pos>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j] = stdIn.nextInt();
				row[i][map[i][j]] = 1;
				col[j][map[i][j]] = 1;
				square[whichSquare(i,j)][map[i][j]] = 1;
				if(map[i][j] == 0) {
					blank.add(new Pos(i,j));
				}
			}
		}
		go(0);
	}
	static void go(int id) {
		
		if(id == blank.size()) {
			printMap();
			System.exit(0);
		}
		
		int x = blank.get(id).x;
		int y = blank.get(id).y;
		int s = whichSquare(x,y);
		
		for(int i=1;i<=9;i++) {
			if(row[x][i] == 0 &&col[y][i] == 0 && square[s][i] == 0 ) {
				row[x][i] = 1;
				col[y][i] = 1;
				square[s][i] = 1;
				map[x][y] = i;
				go(id+1);
				row[x][i] = 0;
				col[y][i] = 0;
				square[s][i] = 0;
				map[x][y] = 0;
			}
		}
	}
	static int whichSquare(int x, int y) {
		return (x/3) *3 + (y/3);
	}
	static void printMap() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
	}
}
class Pos{
	int x;
	int y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}
