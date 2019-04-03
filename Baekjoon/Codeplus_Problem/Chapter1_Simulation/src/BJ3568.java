// 3568번
// iSharp
// 시뮬레이션 
// 문자열 놀이 
import java.util.Scanner;
import java.util.StringTokenizer;
public class BJ3568 {
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		String s = stdIn.nextLine();
		StringTokenizer st = new StringTokenizer(s);
		String first = st.nextToken();
		while(st.hasMoreTokens()) {
			String next = st.nextToken();
			String var = "";
			int id = 0;
			while(true) {
				if((next.charAt(id) >= 'a' && next.charAt(id) <= 'z') || (next.charAt(id) >= 'A' && next.charAt(id) <= 'Z')) {
					var += next.charAt(id);
					id++;
				}else {
					break;
				}
			}
			String temp = first;
			for(int i=next.length()-2;i>=id;i--) {
				char ctemp = next.charAt(i);
				if(ctemp == ']') {
					temp += '[';
				}else if(ctemp == '[') {
					temp += ']';
				}else {
					temp += ctemp;
				}
			}
			System.out.println(temp + " " + var +";");
		}
		
	}
}
