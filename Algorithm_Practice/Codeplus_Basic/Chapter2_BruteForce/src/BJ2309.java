// 2309번
// 일곱 난쟁이
// 브루트 포스 
// O(N^2)

//import java.util.Arrays;
//import java.util.Scanner;
//public class BJ2309 {
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int[] ar = new int[9];
//		int sum = 0;
//		
//		for(int i=0;i<9;i++) {
//			ar[i] = stdIn.nextInt();
//			sum += ar[i];
//		}
//		solve(ar, sum);
//		
//	}
//	static void solve(int[] ar, int s) {
//		int a = 0;
//		int b = 0;
//		// 9명 중 2명을 고르는 모든 경우의 수 
//		// j = i+1 (i=j일 경우 고려하지 않도록)
//		for(int i=0;i<9;i++) {
//			for(int j = i+1;j<9;j++) {
//				int sum = s - ar[i] - ar[j];
//				if(sum == 100) {
//					a = ar[i];
//					b = ar[j];
//					break;
//				}				
//			}
//		}
//		
//		Arrays.sort(ar);
//		
//		for(int i=0;i<9;i++){
//			if(ar[i]==a||ar[i]==b)
//				continue;
//			System.out.println(ar[i]);
//		}
//	}
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class BJ2309{
	static int[] height = new int[9];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		for(int i=0;i<9;i++) {
			height[i] = stdIn.nextInt();
		}
		
		// 조합 
		int[] ar = new int[9];
		cb(ar, 0,9,7,0);
		
		// 순열 
//		int[] perm = new int[9];
//		perm[0] = 1;
//		perm[1] = 1;
//		do {
//			if(sum(perm) == 100) {
//				getAns(perm);
//				return;
//			}
//		}while(np(perm));
	}
	static void getAns(int[] ar) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			if(ar[i] == 0) ans.add(height[i]);
		}
		Collections.sort(ans);
		for(int a: ans) {
			System.out.println(a);
		}
	}
	static int sum (int[] ar) {
		int sum = 0;
		for(int i=0;i<ar.length;i++) {
			if(ar[i] == 0) sum += height[i];
		}
		return sum;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] <= ar[i]) i--;
		if(i == 0) return false;
		int j = n-1;
		while(ar[i-1] <= ar[j]) j--;
		swap(ar,i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar, i,j);
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
	static void cb(int[] ar, int index, int n, int r, int target) {
		if(r==0) {

			int sum = 0;
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int i=0;i<index;i++) {
				ans.add(height[ar[i]]);
				sum += height[ar[i]];
			}
			if(sum == 100) {
				
				Collections.sort(ans);
				for(int a: ans) {
					System.out.println(a);
				}
				System.exit(0);
			}
			
		}else if(target == n) return;
		else {
			ar[index] = target;
			cb(ar, index+1,n,r-1,target+1);
			cb(ar, index, n,r, target+1);
		}
	}
}
