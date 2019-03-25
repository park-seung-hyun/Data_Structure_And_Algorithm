import java.util.Scanner;

// TriangleLB 
// pg38 
// 이중 반복문을 통해 직각 이등변 삼각형을 만드는 알고리즘 
public class TriangleLB {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		do {
			System.out.println("변의 길이를 입력해주세요.");
			n = stdIn.nextInt();
		}while(n<=0);
		
		genTriangleLB(n);
	
	}
	static void genTriangleLB(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}
}
