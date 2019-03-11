// 9007번 (복습)
// 카누 선수 
// 이분 탐색 (Binary Search) 사용

import java.util.Arrays;
import java.util.Scanner;
public class Re_BJ9007 {
	static int[][] stu;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int k= stdIn.nextInt();
			int n = stdIn.nextInt();
			stu = new int[4][n];
			for(int m = 0;m<4;m++) {
				for(int j=0;j<n;j++) {
					stu[m][j] = stdIn.nextInt(); 
				}
			}
			solve(k, n);
		}
	}
	static void solve(int k, int n) {
		
		int[] ar = new int[n*n];
		int id = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ar[id++] = stu[0][i] +stu[1][j];
			}
		}
		int[] ar2 = new int[n*n];
		id = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ar2[id++] = stu[2][i] +stu[3][j];
			}
		}
		
		Arrays.sort(ar);
		int min = 2000000000;
		int close = 2000000000;
		for(int i=0;i<n*n;i++) {
			int s = k - ar2[i];
			
			int l = 0;
			int r = n*n-1;
			int mid = (l + r)/2;
			while(l<=r) {
				
				if(Math.abs(ar[mid] + ar2[i] - k) <= min) {
					if(min != Math.abs(ar[mid] + ar2[i] - k)) {
						min = Math.abs(ar[mid] + ar2[i] - k);
						close = ar[mid] + ar2[i];
					}else {
						if(ar[mid] + ar2[i] - k<0) {
							min = Math.abs(ar[mid] + ar2[i] - k);
							close = ar[mid] + ar2[i];
						}
						
						
					}
					
				}
				
				if(s - ar[mid] < 0) {
					r = mid - 1;
					mid = (l + r)/2;
				}else if(s- ar[mid] > 0) {
					l = mid + 1;
					mid = (l + r)/2;
				}else {
					break;
				}
			}
		
		}
		System.out.println(close);

	}
}
