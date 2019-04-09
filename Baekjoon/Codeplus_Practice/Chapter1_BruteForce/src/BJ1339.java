// 1339번 
// 단어 수학   
// 브루트 포스

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class BJ1339{
	// 자료구조가 문제 .. 
	static HashSet<Character> s = new HashSet<Character>();
	static String[] word;
	static int[] alpha = new int[26];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		word = new String[n];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			word[i] = stdIn.nextLine();
			for(char c : word[i].toCharArray()) {
				s.add(c);
			}
		}
		// HashSet -> Character[]  이렇게 하면 중복 값 쉽게 없앨 수 있음.
		Character[] letters = s.toArray(new Character[s.size()]);
		int cnt = letters.length;
		
		int[] perm = new int[cnt];
		for(int i=0;i<cnt;i++) perm[i] = 9-i;
		Arrays.sort(perm);
		
		int max = 0;
		do {
			int temp = sum(perm,letters);
			if(temp > max) max = temp;
		}while(np(perm));
		System.out.println(max);
	}
	static int sum(int[] ar, Character[] letters) {
		int sum = 0;
		for(int i=0;i<letters.length;i++) {
			alpha[letters[i]-'A'] = ar[i];
		}
		for(String s: word) {
			// 숫자만드는 법 
			// String -> parseInt 오래걸리는 것 같음..
			// 무조건 now = now*10 + A 이런 식으로 구현하기 
			int now = 0;
			for(char c: s.toCharArray()) {
				int num = alpha[c-'A'];
				now = now * 10 + num;
			}
			sum += now;
		}
		return sum;
	}
	static boolean np (int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] >= ar[i])i--;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1] >= ar[j]) j--;
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
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}