// 3568번
// iSharp
// 시뮬레이션 
// 문자열 놀이 

//import java.util.Scanner;
//import java.util.StringTokenizer;
//public class BJ3568 {
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		String s = stdIn.nextLine();
//		StringTokenizer st = new StringTokenizer(s);
//		String first = st.nextToken();
//		while(st.hasMoreTokens()) {
//			String next = st.nextToken();
//			String var = "";
//			int id = 0;
//			while(true) {
//				if((next.charAt(id) >= 'a' && next.charAt(id) <= 'z') || (next.charAt(id) >= 'A' && next.charAt(id) <= 'Z')) {
//					var += next.charAt(id);
//					id++;
//				}else {
//					break;
//				}
//			}
//			String temp = first;
//			for(int i=next.length()-2;i>=id;i--) {
//				char ctemp = next.charAt(i);
//				if(ctemp == ']') {
//					temp += '[';
//				}else if(ctemp == '[') {
//					temp += ']';
//				}else {
//					temp += ctemp;
//				}
//			}
//			System.out.println(temp + " " + var +";");
//		}
//		
//	}
//}

import java.util.Scanner;
import java.util.StringTokenizer;
public class BJ3568{
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		String s = stdIn.nextLine();
		StringTokenizer st = new StringTokenizer(s," ,;");
		String common = st.nextToken();
		while(st.hasMoreTokens()) {
			String next = st.nextToken();
			if(next.equals(",") || next.equals(";")) continue;
			
			int i = next.length()-1;
			for(;i>=0;i--) {
				if((next.charAt(i) >= 'a' && next.charAt(i) <='z')||(next.charAt(i) >= 'A' && next.charAt(i) <='Z' )) {
					break;
				}
			}
			String second = next.substring(0, i+1);
			String first = "";
			first += common;
			for(int j= next.length()-1 ;j >= i+1;j--) {
				if(next.charAt(j) == '[') {
					first += ']';
				}else if(next.charAt(j) == ']') {
					first += '[';
				}else {
					first += next.charAt(j);
				}
			}
			System.out.println(first +  " " + second+";");
		}
	}
}