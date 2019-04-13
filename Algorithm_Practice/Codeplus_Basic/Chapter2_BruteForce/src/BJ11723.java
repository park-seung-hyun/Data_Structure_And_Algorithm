// 11723번
// 집합 
// 비트 마스크 

import java.util.Scanner;
public class BJ11723 {
	static int ans = 0;
	static StringBuilder sb = new StringBuilder(); // System.out.println(); 시간 초과 문제 해결 
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		while(stdIn.hasNext()) {
			String q = stdIn.next();
			int n=0;
			if(!q.equals("empty") &&!q.equals("all"))
				n = stdIn.nextInt();			
			solve(q, n-1);
		}
		System.out.println(sb);
		
	}
	static void solve(String q, int n) {
		if(q.equals("add")) {
			ans = ans | (1<<n);
		}else if(q.equals("check")) {
			if((ans&(1<<n))==0)
				sb.append("0\n"); // System.out.println(); 시간 초과 문제 해결 
			else
				sb.append("1\n");
		}
		else if(q.equals("remove")) {
			ans = ans & ~(1<<n);
		}
		else if(q.equals("toggle")) {
			ans = ans ^ (1<<n);
		}
		else if(q.equals("all")) {
			ans = (1<<20)-1;
		}else {
			ans = 0;
		}
	}
}
//public class BJ11723{
//	static int S = 0;
//	static StringBuilder sb = new StringBuilder();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			
//			String order = stdIn.next();
//			int num = 0;
//			if(stdIn.hasNextInt())
//				num = stdIn.nextInt();
//			solve(order, num-1);
//		}
//		System.out.println(sb);
//	}
//	static void solve(String o, int n) {
//		if(o.equals("add")) {
//			S = S | (1<<n);
//		}else if(o.equals("check")) {
//			if((S & (1<<n)) == 0) {
//				sb.append("0\n");
//			}else{
//				sb.append("1\n");
//			}
//		}else if(o.equals("remove")) {
//			S = S & ~(1<<n);
//		}else if(o.equals("toggle")) {
//			S = S ^ (1<<n);
//		}else if(o.equals("all")) {
//			 S = (1<<20) - 1;
//		}else {
//			S = 0;
//		}
//
//	}
//}