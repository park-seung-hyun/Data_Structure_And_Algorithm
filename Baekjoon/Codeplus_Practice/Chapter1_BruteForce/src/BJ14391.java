import java.util.ArrayList;
import java.util.Scanner;

public class BJ14391 {
	static int[][] map;
	static int[][] visited;
	static int ans = 0;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int r = 0;
	static int c = 0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		r = stdIn.nextInt();
		c = stdIn.nextInt();
		map = new int[r][c];
		visited = new int[r][c];
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		
	}
	static void go(int x, int y, int sum) {
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			while(nx >= 0 && ny>=0 && nx < r && ny < c) {
				
				if(visited[nx][ny] != 0) {
					break;
				}
				visited[nx][ny] = 1;
				temp.add(nx *c+ny);
				al.add(map[nx][ny]);
				go(nx,ny,sum + getSum(al));
				
				nx += dx[i];
				ny += dy[i];
			}
			for(int t: temp) {
				int vx = t/c;
				int vy = t%c;
				visited[vx][vy] = 0;
			}
		}
		
	}
	static int getSum(ArrayList<Integer> al) {
		int sum = 0;
		
		return sum;
	}
}
