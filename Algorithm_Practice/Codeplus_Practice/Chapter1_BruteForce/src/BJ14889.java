// 14889번 
// 스타트와 링크    
// 브루트 포스
// 순열, 조합으로 구현 

import java.util.Arrays;
import java.util.Scanner;
//public class BJ14889 {
//	static int[] team;
//	static int[][] stat;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		team = new int[n];
//		stat = new int[n][n];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				stat[i][j] = stdIn.nextInt();
//			}
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		int[] perm = new int[n];
//		for(int i=0;i<n/2;i++) perm[i] = 1;
//		
//		int dif = Integer.MAX_VALUE;
//		do {
//			int temp = getDif(perm, n);
//			if(dif > temp) dif = temp;
//			
//		}while(next_Permutation(perm));
//		System.out.println(dif);
//	}
//	static int getDif(int[] perm, int n) {
//		int score1 = 0;
//		int score2 = 0;
//		int[] team1 = new int[n/2];
//		int[] team2 = new int[n/2];
//		int id1 = 0;
//		int id2 = 0;
//		for(int i=0;i<n;i++) {
//			if(perm[i] == 0) {
//				team1[id1++] = i;
//			}else {
//				team2[id2++] = i;
//			}
//		}
//		for(int i : team1) {
//			for(int j : team1) {
//				if(i==j)continue;
//				score1 += stat[i][j];
//			}
//		}
//		for(int i : team2) {
//			for(int j : team2) {
//				if(i==j)continue;
//				score2 += stat[i][j];
//			}
//		}
//		return Math.abs(score1 - score2);
//	}
//	static boolean next_Permutation(int[] ar) {
//		int n = ar.length;
//		int i= n-1;
//		while(i>0 && ar[i-1] <= ar[i]) i--;
//		if(i==0) return false;
//		int j =n-1;
//		while(ar[i-1] <= ar[j]) j--;
//		swap(ar, i-1, j);
//		j = n-1;
//		while(i<j) {
//			swap(ar, i, j);
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

public class BJ14889 {
	static int[] team;
	static int[][] stat;
	static int dif;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		team = new int[n];
		stat = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				stat[i][j] = stdIn.nextInt();
			}
		}
		solve(n);
	}
	static void solve(int n) {
		int[] ar = new int[n];
		Arrays.fill(ar, -1);
		Combination(ar,0,n,n/2,0);
		System.out.println(ans);
	}
	static void print(int[] arr, int index) {
		int[] perm = new int[arr.length];
		for(int i : arr) {
			if(i == -1) break;
			perm[i] = 1;
		}
		int temp = getDif(perm, perm.length);
		if(temp < ans) ans = temp;
	}
	static void Combination(int[] arr, int index, int n, int r,int target) {
		if(r==0) print(arr, index);
		else if(target == n) return;
		else {
			// n 뽑음 
			arr[index] = target;
			Combination(arr, index+1, n,r-1,target+1);
			// n 안뽑음 
			Combination(arr, index,n,r,target+1);
		}
	}
	static int getDif(int[] perm, int n) {
		
		int score1 = 0;
		int score2 = 0;
		int[] team1 = new int[n/2];
		int[] team2 = new int[n/2];
		int id1 = 0;
		int id2 = 0;
		for(int i=0;i<n;i++) {
			if(perm[i] == 0) {
				team1[id1++] = i;
			}else {
				team2[id2++] = i;
			}
		}
		for(int i : team1) {
			for(int j : team1) {
				if(i==j)continue;
				score1 += stat[i][j];
			}
		}
		for(int i : team2) {
			for(int j : team2) {
				if(i==j)continue;
				score2 += stat[i][j];
			}
		}
		return Math.abs(score1 - score2);
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}
