// BMmatch 
// pg305  
// 문자열 검색 (Boyer Moore) 

import java.util.Scanner;

public class BMmatch {
	static int bmMatch(String txt, String pat) {
		int pt = 0; // text 커서 
		int pp = 0; // pattern 커서 
		int txtLen = txt.length(); // text 문자 개수 
		int patLen = pat.length(); // pattern 문자 개수 
		int[] skip = new int[Character.MAX_VALUE+1]; // 건너띄기 표 
		
		// 표 만들기 
		for(pt=0;pt <= Character.MAX_VALUE; pt++) {
			skip[pt] = patLen;
		}
		for(pt=0;pt <patLen-1; pt++) {
			skip[pat.charAt(pt)] = patLen - pt -1;
		}
		
		// 검색 
		while(pt<txtLen) {
			pp = patLen -1; 
			while(txt.charAt(pt) == pat.charAt(pp)) {
				if(pp == 0) { 
					return pt; // 검색 성공 
				}
				pp--;
				pt--;
			}
			pt+=(skip[txt.charAt(pt)]>patLen-pp) ? skip[txt.charAt(pt)] : patLen - pp;
		}
		
		return -1; // 검색 실패 
	}
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("텍스트: ");
		String s1 = stdIn.next();
		System.out.print("패턴: ");
		String s2 = stdIn.next();
		
		int idx = bmMatch(s1,s2);
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
