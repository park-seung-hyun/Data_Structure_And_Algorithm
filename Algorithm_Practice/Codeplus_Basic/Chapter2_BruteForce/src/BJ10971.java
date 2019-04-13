// 10971번
// 외판원 순회2 
// 순열 

import java.util.Scanner;
public class BJ10971 {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[][] ar = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				ar[i][j] = stdIn.nextInt();
			}
		}
		solve(ar, n);
	}
	static void solve(int[][] w, int n) {
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = i+1;
		}
		int min = 1000000000;
		while(true) {
			
			// 첫 시작 경로를 고정해도됨. 
			// 1->3->4->2->1
			// 2->1->3->4->2
			// 위 두 경로는 같기 떄문에 시작점을 하나의 도시로 고정해도 같은 정답이 나옴. 
			// O(N*N!) -> O(N!)
			if(ar[0] != 1) break;
			
			int sum = 0;
			boolean flag = true;
			for(int i=0;i<n-1;i++) {
				if(w[ar[i]][ar[i+1]] != 0) {
					sum += w[ar[i]][ar[i+1]];
				}else {
					flag = false;
					break;
				}
			}
			if(flag == true && w[ar[n-1]][ar[0]] != 0) {
				sum += w[ar[n-1]][ar[0]];
				if(sum<min)
					min = sum;
			}
			if(nextPermutation(ar)==false)
				break;
		}
		System.out.println(min);
	}
	static boolean nextPermutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1]>=ar[i]) i-=1;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1]>=ar[j])j-=1;
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
