import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class BJ1062 {
//	static String[] word;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner (System.in);
//		int n = stdIn.nextInt();
//		int k = stdIn.nextInt();
//		stdIn.nextLine();
//		word = new String[n];
//		for(int i=0;i<n;i++) {
//			word[i] = stdIn.nextLine();
//		}
//		solve(n,k);
//	}
//
//	static void solve(int n, int k) {
//		
//		if(k <= 5) {
//			System.out.println(0);
//			return;
//		}
//		int[] perm = new int[26];
//		for(int i=0;i<k;i++) {
//			perm[i] = 1;
//		}
////		System.out.println(Arrays.toString(perm));
//		int ans = 0;
//		int cnt = 0;
//		do {
////			System.out.println(Arrays.toString(perm));
//			cnt = isReadable(perm);
//			if(cnt > ans) ans = cnt;
//		}while(next_Permutation(perm));
//		
//		System.out.println(ans);
//	}
//	static int isReadable(int[] perm) {
//		int cnt = 0;
//		boolean flag = true;
//		for(String s: word) {
//			flag = true;
//			for(char c: s.toCharArray()) {
//				if(perm[c-'a'] == 0) {
//					flag = false;
//					break;
//				}
//			}
//			if(flag == true) cnt ++;
//		}
//		return cnt;
//	}
//	static boolean next_Permutation(int[] ar) {
//		int n = ar.length;
//		int i= n-1;
//		while(i>0 && ar[i-1] <= ar[i]) i--;
//		if(i==0) return false;
//		int j = n-1;
//		while(ar[i-1] <= ar[j]) j--;
//		swap(ar, i-1, j);
//		j = n-1;
//		while(i<j) {
//			swap(ar, i,j);
//			i++;
//			j--;
//		}
//		return true;
//	}
//	static void swap(int[] ar, int id1, int id2) {
//		int temp = ar[id1];
//		ar[id1] = ar[id2];
//		ar[id2] = temp;
//	}
//}
//

public class BJ1062{
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static String[] word;
	static String alpha = "antic";
	static int ans = 0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		word = new String[n];
		int k= stdIn.nextInt();
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			word[i] = stdIn.nextLine();
		}
		solve(n,k);
	}
	static void solve(int n, int k) {
		if(k < 5) {
			System.out.println(0);
			return ; 
		}
		for(char c : alpha.toCharArray()) {
			al.add(c-'a');
		}
		go(0,k-5);
		System.out.println(ans);
	}
	static void go(int id, int cnt) {
		
		if(cnt == 0) {
			int count = 0;
			for(String s: word) {
				String temp = s.substring(4,s.length()-4);
				count ++;
				for(char c : temp.toCharArray()) {
					if(!al.contains(c-'a')) {
						count--;
						break;
					}
				}
			}
			if(ans < count) ans = count;
			return;
		}
		if(id == 27) {
			return;
		}
		if(al.contains(id)) {
			go(id+1, cnt);
			return;
		}
		al.add(id);
		go(id+1, cnt-1);
		al.remove((Integer)id);
		go(id+1, cnt);
	}
}