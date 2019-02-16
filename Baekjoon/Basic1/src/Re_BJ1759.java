// 1759번 (복습)
// 암호 만들기
// 브루트 포스 
// solve -> 순열 
// solve2 -> 재귀 함수 

import java.util.Arrays;
import java.util.Scanner;

public class Re_BJ1759 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int l =stdIn.nextInt();
		int c = stdIn.nextInt();
		char[] alp = new char[c];
		for(int i=0;i<c;i++) {
			alp[i] = stdIn.next().charAt(0);
		}
//		solve(alp,l,c);
		
		Arrays.sort(alp);
		solve2(0,"",c,l,alp);
	}
	static void solve2(int index, String ans, int c, int l, char[] alp) {
		if(ans.length() == l) {
			if(check2(ans)==true) {
				System.out.println(ans);
			}
			return;
		}
		if(index==c) {
			return;
		}
		solve2(index+1, ans + alp[index], c,l,alp);
		solve2(index+1, ans , c,l,alp);
	}
	static boolean check2(String s) {
		int j =0;
		int m = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
				m++;
			else
				j++;
		}
		if(j>=2 && m>=1)
			return true;
		else
			return false;
	}
	static void solve(char[] alp, int l, int c) {
		int[] ar = new int[c];
		for(int i=0;i<c;i++) {
			if(i<l)
				ar[i] = 0;
			else
				ar[i] = 1;
		}
		Arrays.sort(alp);
		while(true) {
			if(check(ar,alp) == true) {
				for(int i=0;i<c;i++) {
					if(ar[i]==0)
						System.out.printf("%c",alp[i]);
				}
				System.out.println();	
			}
			
			if(nextPermutation(ar) == false) {
				break;
			}
		}
	}
	static boolean check(int[] ar, char[] alp) {
		int j = 0;
		int m = 0;
		for(int i=0;i<ar.length;i++) {
			if(ar[i]==0){
				int a = alp[i];
				if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u')
					m++;
				else
					j++;
			}
		}
		
		if(j>=2 && m>=1)
			return true;
		else 
			return false;
	}
	static boolean nextPermutation(int[] ar) {
		int n = ar.length;
		int i= n-1;
		while(i>0 && ar[i-1]>=ar[i]) i-=1;
		if(i == 0) return false;
		int j = n-1;
		while(ar[i-1]>=ar[j]) j-=1;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar, i, j);
			i++;
			j--;
		}
		
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int t = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = t;
	}
}
