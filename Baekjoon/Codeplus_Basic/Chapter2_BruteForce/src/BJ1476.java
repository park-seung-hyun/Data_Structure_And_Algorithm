// 1476번
// 날짜 계산 
// 브루트 포스

import java.util.Scanner;
public class BJ1476 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int E = stdIn.nextInt();
		int S = stdIn.nextInt();
		int M = stdIn.nextInt();
		solve(E,S,M);
	}
	static void solve(int e, int s, int m) {
		int year = 0;
		while(true) {
			
			int x = year%15;
			int y = year%28;
			int z = year%19;
			
			if(x==e-1 && y==s-1 && z==m-1)
				break;
			
			year++;
		}
		System.out.println(year+1);
	}
	static void solve2(int e, int s, int m) {
		int i=1;
		int j=1;
		int k=1;
		int year = 1;
		while(true) {
			if(i>15)
				i = 1;
			if(j>28)
				j = 1;
			if(k>19)
				k = 1;
			
			if(i==e&&j==s&&k==m)
				break;
			
			year++;
			
			i++;
			j++;
			k++;	
		}
		System.out.println(year);
	}
}
