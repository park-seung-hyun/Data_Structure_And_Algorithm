// 2290번
// LCD Test
// 시뮬레이션 

import java.util.Scanner;
public class BJ2290 {
	static int[][] N = {
			{1,2,0,2,1},
			{0,1,0,1,0},
			{1,1,1,-1,1},
			{1,1,1,1,1},
			{0,2,1,1,0},
			{1,-1,1,1,1},
			{1,-1,1,2,1},
			{1,1,0,1,0},
			{1,2,1,2,1},
			{1,2,1,1,1}
	};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int s = stdIn.nextInt();
		int n = stdIn.nextInt();
		solve(s,n);
	}
	static void solve(int s, int n) {
		String num = Integer.toString(n);
		for(int i=0;i<5;i++) {
			String temp = "";
			for(char c: num.toCharArray()) {
				if(i%2 ==0) { // -----
					if(N[c-'0'][i] == 0) {
						temp += " ";
						for(int j=0;j<s;j++) {
							temp += " ";
						}
						temp += " ";
					}else {
						temp += " ";
						for(int j=0;j<s;j++) {
							temp += "-";
						}
						temp += " ";
					}
				}else { // ||
					if(N[c-'0'][i] == 1) {
						for(int j=0;j<s;j++) {
							temp += " ";
						}
						temp += " |";
						
					}else if(N[c-'0'][i] == -1){
						temp += "| ";
						for(int j=0;j<s;j++) {
							temp += " ";
						}
					}else {
						temp += "|";
						for(int j=0;j<s;j++) {
							temp += " ";
						}
						temp += "|";
					}
				}
				temp += " ";
			}
			if(i%2 == 0) {
				System.out.println(temp);
			}else {
				for(int j=0;j<s;j++) {
					System.out.println(temp);
				}
			}
		
		}
	}
}
