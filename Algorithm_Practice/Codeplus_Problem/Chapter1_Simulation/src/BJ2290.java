// 2290번
// LCD Test
// 시뮬레이션 

//import java.util.Scanner;
//public class BJ2290 {
//	static int[][] N = {
//			{1,2,0,2,1},
//			{0,1,0,1,0},
//			{1,1,1,-1,1},
//			{1,1,1,1,1},
//			{0,2,1,1,0},
//			{1,-1,1,1,1},
//			{1,-1,1,2,1},
//			{1,1,0,1,0},
//			{1,2,1,2,1},
//			{1,2,1,1,1}
//	};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int s = stdIn.nextInt();
//		int n = stdIn.nextInt();
//		solve(s,n);
//	}
//	static void solve(int s, int n) {
//		String num = Integer.toString(n);
//		for(int i=0;i<5;i++) {
//			String temp = "";
//			for(char c: num.toCharArray()) {
//				if(i%2 ==0) { // -----
//					if(N[c-'0'][i] == 0) {
//						temp += " ";
//						for(int j=0;j<s;j++) {
//							temp += " ";
//						}
//						temp += " ";
//					}else {
//						temp += " ";
//						for(int j=0;j<s;j++) {
//							temp += "-";
//						}
//						temp += " ";
//					}
//				}else { // ||
//					if(N[c-'0'][i] == 1) {
//						for(int j=0;j<s;j++) {
//							temp += " ";
//						}
//						temp += " |";
//						
//					}else if(N[c-'0'][i] == -1){
//						temp += "| ";
//						for(int j=0;j<s;j++) {
//							temp += " ";
//						}
//					}else {
//						temp += "|";
//						for(int j=0;j<s;j++) {
//							temp += " ";
//						}
//						temp += "|";
//					}
//				}
//				temp += " ";
//			}
//			if(i%2 == 0) {
//				System.out.println(temp);
//			}else {
//				for(int j=0;j<s;j++) {
//					System.out.println(temp);
//				}
//			}
//		
//		}
//	}
//}


import java.util.Scanner;
public class BJ2290{
	static int[][] Digit = {
			{0,3,-1,9,6},
			{-1,2,-1,5,-1},
			{0,2,3,4,6},
			{0,2,3,5,6},
			{-1,3,3,5,-1},
			{0,1,3,5,6},
			{0,1,3,9,6},
			{0,2,-1,5,-1},
			{0,3,3,9,6},
			{0,3,3,5,6}
	};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		String num = stdIn.next();
		
		for(int i=0;i<5;i++) {
			String temp = "";
			for(int j=0;j<num.length();j++) {
				int number = num.charAt(j) - '0';
				if(i%2 == 0) {
					if(Digit[number][i] == -1) {
						for(int k=0;k<n+2;k++)
							System.out.printf(" ");
					}else {
						System.out.printf(" ");
						for(int k=0;k<n;k++)
							System.out.printf("-");
						System.out.printf(" ");
					}
					System.out.printf(" ");
				}else {
					if(Digit[number][i]%3 == 0) {
						temp += "|";
						for(int k2=0;k2<n;k2++)
							temp +=" ";
						temp +="|";
					}else {
						if(Digit[number][i]%3 == 1) {
							temp +="|";
							for(int k2=0;k2<n+1;k2++)
								temp +=" ";
						}else {
							for(int k2=0;k2<n+1;k2++)
								temp +=" ";
							temp +="|";
						}
					}
					temp += " ";
				}
			}
			if(i%2 != 0) {
				for(int k=0;k<n;k++) {
					System.out.println(temp);
				}
			}else {
				System.out.println();
			}
		}
	}
}