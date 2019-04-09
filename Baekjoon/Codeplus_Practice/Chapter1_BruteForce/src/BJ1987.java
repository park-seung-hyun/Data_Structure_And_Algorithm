import java.util.Scanner;

public class BJ1987 {
	static char[][] map;
	static int ans = 0;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	static int[] visited = new int[27];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		map = new char[r][c];
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s= stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		visited[map[0][0] - 'A'] = 1;
		go(0,0,r,c, 1);
		System.out.println(ans);
	}
	static void go(int x, int y, int r, int c, int sum) {
		if(sum > ans) ans = sum;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny >=0 && nx< r && ny < c) {
				if(visited[map[nx][ny] - 'A'] == 0) {
					visited[map[nx][ny] - 'A'] = 1;
					go(nx,ny,r,c, sum+1);
					visited[map[nx][ny] - 'A'] = 0;
				}
			}
		}
	}
}

