// 9095번 
// 1,2,3 더하기  
// DP

import java.util.Scanner;
public class BJ9095 {
	static int[] d =  new int[11];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		dp2();
		for(int i=0;i<t;i++){
			int n = stdIn.nextInt();
			System.out.println(d[n]);
		}
	}
	static void dp() {
		d[0] = 1;
		for(int i=1;i<11;i++) {	
			d[i] += d[i-1];
			if(i-2>=0)
				d[i] += d[i-2];
			if(i-3>=0)
				d[i] += d[i-3];
		}
	}
	// 더 깔끔하게 풀기 
	static void dp2() {
		d[0] = 1;
		for(int i=1;i<11;i++) {
			for(int j=1;j<=3;j++) {
				if(i-j >=0 ) d[i] += d[i-j];
			}
		}
	}
}	
