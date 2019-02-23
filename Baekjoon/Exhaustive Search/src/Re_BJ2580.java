// 2580번 (복습)
// 스도쿠
// DFS (Depth-First-Search)
// Back-Tracking -> 유망하지 않으면 하위 노드를 배제하고 부모 노드로 돌아감. 

// 해당 숫자가 각 행, 열, 사각형 내에 있는지 확인하는 방법 

import java.util.ArrayList;
import java.util.Scanner;
public class Re_BJ2580 {
	static int[][] map = new int[9][9];
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve();
	}
	static void solve() {
		ArrayList<Pair> al = new ArrayList<Pair>();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] ==0)
					al.add(new Pair(i,j));
			}
		}
		dfs(al, 0);
	}
	static void printMap() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
	}
	static void dfs(ArrayList<Pair> al, int id) {
		if(id == al.size()) {
			printMap();
			System.exit(0);
		}
		
		Pair p = al.get(id);
		int x = p.x;
		int y = p.y;
		
		for(int i=1;i<10;i++) {
			map[x][y] = i;
			if(rowCheck(x,y)&&colCheck(x,y)&&sqCheck(x,y)) {
				dfs(al,id+1);
			}
			map[x][y] = 0;
		}
	}
	static boolean rowCheck(int x, int y) {
		for(int i=0;i<9;i++) {
			if(i != y && map[x][y] == map[x][i])
				return false;
		}
		return true;
	}
	static boolean colCheck(int x, int y) {
		for(int i=0;i<9;i++) {
			if(i != x && map[x][y] == map[i][y])
				return false;
		}
		return true;
	}
	static boolean sqCheck(int x, int y) {
		int sx = x/3;
		int sy = y/3;
		for(int i=sx*3;i<(sx+1)*3;i++) {
			for(int j=sy*3;j<(sy+1)*3;j++) {
				if(!(i == x && j==y) && map[x][y] == map[i][j])
					return false;
			}
		}
		return true;
	}
}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
