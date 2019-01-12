import java.util.Scanner;

// DayOfYear
// pg82
// 다차원 배열 (경과 일수) 
public class DayOfYear {
	static int [][] mdays = {{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}};
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		System.out.println("경과 일수를 구합니다. ");
		do {
			System.out.print("y: ");
			int y = stdIn.nextInt();
			System.out.print("m: ");
			int m = stdIn.nextInt();
			System.out.print("d: ");
			int d = stdIn.nextInt();
			
			System.out.printf("그 해의 %d번째 일입니다. ", dayOfYear(y,m,d));
			System.out.print("한번더?: Yes -> 1, No -> 0");
			retry = stdIn.nextInt();
			
		}while(retry == 1);
	}
	static int isLeap(int y) { // 윤년인가? 
		return (y%4==0 && y%100!=0 || y%400==0) ?1:0;
	}
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		for(int i=1;i<m;i++) {
			days += mdays[isLeap(y)][i-1];
		}
		return days;
	}
}
