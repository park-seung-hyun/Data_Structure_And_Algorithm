import java.util.Scanner;

public class BJ11058 {
	static long[] d;
	static long[] b;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		d = new long[t+1];
		b = new long[t+1];
		solve(t);
	}
	static void solve(int n) {
		for(int i=1;i<=n;i++) {
			long max = d[i-1] + 1; // 1
			
			if(max <= d[i-1] + b[i-1]) {  // 4
				max = d[i-1] + b[i-1];
			}
			
			b[i] = b[i-1];
			
			if(i-3 >=0 && max <= d[i-3]*2) { // 234
				
				if(max == d[i-3]*2 && d[i-3] > b[i])
					b[i] = d[i-3];
				
				max = d[i-3]*2;
			}
			
			d[i] = max;
		}
	
//		for(int i=0;i<=n;i++) 
//				System.out.printf("%d ", d[i]);
//		System.out.println();
//		for(int i=0;i<=n;i++) 
//				System.out.printf("%d ", b[i]);
		
		System.out.println(d[n]);
	}
}
