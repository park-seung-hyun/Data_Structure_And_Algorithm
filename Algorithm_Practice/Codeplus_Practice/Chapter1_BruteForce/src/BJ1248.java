import java.util.Arrays;
import java.util.Scanner;

public class BJ1248 {
	static int[][] bu;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		bu = new int[n][n];
		for(int i=0;i<n;i++) Arrays.fill(bu[i], -2);
		String s = stdIn.nextLine();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				char c = s.charAt(cnt++);
				if(c == '+') {
					bu[i][j] = 1;
				}else if(c == '-') {
					bu[i][j] = -1;
				}else {
					bu[i][j] = 0;
				}
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", bu[i][j]);
//			}
//			System.out.println();
//		}
		solve(n);
	}
	static void solve(int n) {
		int[] ans = new int[n];
		Arrays.fill(ans, -100);
		if(bu[0][0] == -1) {
			for(int i=-10;i<0;i++) {
				ans[0] = i;
				go(1,i,n, ans);
				ans[0] = -100;
			}
		}else if(bu[0][0] == 1) {
			for(int i=1;i<=10;i++) {
				ans[0] = i;
				go(1,i,n, ans);
				ans[0] = -100;
			}
		}else {
			ans[0] = 0;
			go(1,0,n, ans);
			ans[0] = -100;
		}
		
	}
	static void go(int id, int sum, int n, int[] ans) {
		if(id == n*n) {
			for(int i: ans) {
				System.out.printf("%d ",i);
			}
			System.exit(1);
		}
		while(bu[id/n][id%n] == -2) id++;
		int x = id/n;
		int y = id%n;
		int nextBu = bu[x][y];
		
		if(nextBu == -1) {
			if(x == y) {
				if(ans[y] < 0) { //음수 
					go(id+1, ans[y], n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			if(ans[y] != -100) {
				if(sum + ans[y] < 0) {
					go(id+1, sum+ans[y], n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			for(int i =-10 ;i<=10;i++) {
				if(i+sum < 0) {
					ans[y] = i;
					go(id+1, sum+i, n, ans);
					ans[y] = -100;
				}
			}
		}else if(nextBu == 1) {
			if(x == y) {
				if(ans[y] > 0) {
					go(id+1, ans[y], n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			if(ans[y] != -100) {
				if(sum + ans[y] > 0) {
					go(id+1, sum+ans[y], n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			for(int i = -10 ;i<=10;i++) {
				if(i+sum > 0) {
					ans[y] = i;
					go(id+1, sum+i, n, ans);
					ans[y] = -100;
				}
			}
		}else {
			if(x == y) {
				if(ans[y] == 0) {
					go(id+1,0, n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			if(ans[y] != -100 ) {
				if(sum + ans[y] == 0) {
					go(id+1, sum+ans[y], n, ans);
				}
				System.out.println("BACK ");
				return;
			}
			int i = -1 * sum;
			ans[y] = i;
			go(id+1, 0, n, ans);
			ans[y] = -100;
		}
	}
}
