import java.util.Scanner;

// CardConvRev  
// pg67
// 문자형 배열 (기수변환)    
public class CardConvRev {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("10진수->r진수 변환");
		int N; // 바꾸고자하는 10진수 
		int r; // 바꾸고자하는 기수 
		char[] cno = new char[32]; // 바뀐 숫자 
		int dno; // cno의 마지막 자리 인덱스 
		int retry;
		do {
			do {
				System.out.print("바꾸고자하는 10진수 (음이 아닌): ");
				N = stdIn.nextInt();
			}while(N<0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? ");
				r = stdIn.nextInt();
			}while(r<2||r>36);
			
			dno = cardConvR(N, r, cno);
			
			System.out.print(r +"진수로..." );
			// digits++ 는 후위 연산자 이므로 시작을 dno-1 
			for(int i=dno-1;i>=0;i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("한번더? Yes -> 1, No -> 0");
			retry = stdIn.nextInt();
		}while(retry == 1);
	}
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			// x -> 바꾸고자하는 10진수 
			// r -> 바꾸고자하는 기수 
			d[digits++] = dchar.charAt(x%r);
			x/=r;
		}while(x!=0);
		return digits;
	}
}
