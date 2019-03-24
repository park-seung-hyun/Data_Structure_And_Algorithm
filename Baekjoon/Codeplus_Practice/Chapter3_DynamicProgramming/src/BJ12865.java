import java.util.Scanner;

public class BJ12865 {
	static int[][] item;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k= stdIn.nextInt();
		item = new int[n+1][2];
		d = new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			item[i][0] = a;
			item[i][1] = b;
		}
		solve(n,k);
	}
	static void solve(int n, int k) {
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				int max = d[i-1][j];
				
				if(j-item[i][0] >=0 && max < d[i-1][j-item[i][0]] + item[i][1])
					max = d[i-1][j-item[i][0]] + item[i][1];
			
				d[i][j]  = max;
				
			}
		}
		
		
		
		
		System.out.println(d[n][k]);;
		
		
	}
}
