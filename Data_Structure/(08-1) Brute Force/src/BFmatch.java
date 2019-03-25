// BFmatch 
// pg292 
// 문자열 검색 (브루트 포스법)

import java.util.Scanner;

public class BFmatch {
	static int bfMatch(String txt, String pat) {
		int pt = 0; // text 커서 
		int pp = 0; // pattern 커서 
		
		// text를 모두 탐색 -> 없는 경우 
		// pattern을 모두 탐색 -> 찾은 경우 
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) { // 일치할 경우 
				pt++;
				pp++;
			}else {
				pt = pt - pp + 1; 
				pp = 0; // pattern은 초기화 
			}
		}
		// pattern 찾은 경우 
		// 텍스트의 위치를 반환 
		if(pp == pat.length())
			return pt - pp;
		// pattern 못 찾은 경우 
		return -1;
	}
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("텍스트: ");
		String s1 = stdIn.next();
		System.out.print("패턴: ");
		String s2 = stdIn.next();
		
		int idx = bfMatch(s1,s2);
		if(idx == -1)
			System.out.println("텍스트에 패턴이 없습니다. ");
		else {
			int len = 0;
			for(int i=0;i<idx;i++)
				len += s1.substring(i, i+1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx+1) + "번쨰 문자부터 일치합니다. ");
			System.out.println("텍스트: "+s1);
			System.out.printf(String.format("패턴: %%%ds\n",len), s2);
		}
	}
}
