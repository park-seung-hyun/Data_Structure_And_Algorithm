// 6603번
// 로또
// 순열 
// k개 중 몇 6개를 고르는 문제 
// 고르는 수가 고정이므로 순열로 풀 수 있음. 
// solve -> 순열 
// solve2 -> 재귀 호출 

import java.util.ArrayList;
import java.util.Scanner;
public class BJ6603 {
	static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main (String[] arg) {
		Scanner stdIn = new Scanner(System.in);
		while(true) {
			int k = stdIn.nextInt();
			if(k==0)
				break;
			int[] ar = new int[k];
			for(int i=0;i<k;i++) {
				ar[i] = stdIn.nextInt();
			}
//			solve(k, ar);
//			System.out.println();
			
			solve2(0,0,ar);
			System.out.println();
		}
	}
	static void solve2(int cnt, int i , int[] ar ) {
		if(cnt == 6) { // 정답인 경우 (1)
			for(int v : al) {
				System.out.printf("%d ", v);
			}
			System.out.println();
			return;
		}
		if(ar.length <= i) { // 불가능한 경우 (2)
			return;
		}
		
		// 다음 경우 호출 (3)
		al.add(ar[i]);
		solve2(cnt+1, i+1, ar);
		al.remove(cnt);
		solve2(cnt, i+1, ar);
	}
	static void solve(int k, int[] ar){
		int[] check = new int[k];
		
		for(int i=0;i<k;i++) {
			if(i<6)
				check[i] = 1;
			else
				check[i] = 0;
		}
		while(true) {
			
			for(int i=0;i<k;i++) {
				if(check[i] == 1)
					System.out.printf("%d ", ar[i]);
			}
			System.out.println();
			
			if(previousPermutation(check) == false)
				break;
		}
	}
	static boolean previousPermutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1]<=ar[i]) i-=1;
		if(i<=0) return false;
		int j = n-1;
		while(ar[i-1]<=ar[j])j-=1;
		swap(ar, i-1, j);
		j = n-1;
		while(j>i) {
			swap(ar, i,j);
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
