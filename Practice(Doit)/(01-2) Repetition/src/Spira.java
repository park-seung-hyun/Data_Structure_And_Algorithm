import java.util.Scanner;

// Spira
// pg40 
// 피라미드를 만드는 알고리즘 
public class Spira {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			System.out.println("층 높이를 입력해주세요.");
			n = stdIn.nextInt();
		}while(n<=0);
		
		spira(n);
	}
	static void spira(int n) {
		for(int i=1;i<=n;i++) {
			for(int m = 0;m<n-i;m++) {
				System.out.print(" ");
			}
			for(int j=0;j<(i-1)*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
