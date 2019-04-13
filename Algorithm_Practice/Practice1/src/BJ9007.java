// 9007번 
// 카누 선수 
// 이분 탐색 (Binary Search) 사용

import java.util.Arrays;
import java.util.Scanner;
public class BJ9007 {
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int[][][] ar = new int[t][4][];
		int[] ka = new int[t];
		for(int i=0;i<t;i++) {
			int k = stdIn.nextInt();
			ka[i] = k;
			int n = stdIn.nextInt();
			
			for(int j=0;j<4;j++) {
				ar[i][j] = new int[n];
				for(int m=0;m<n;m++) {
					ar[i][j][m] = stdIn.nextInt();
				}
			}
		}
		for(int i=0;i<t;i++) {
			selectStudent(ar[i],ar[i][0].length,ka[i]);
		}
	}
	// selectStudent 
	// 각각 클래스에서 학생을 뽑았을때 최적의 몸무개 합 
	static void selectStudent(int[][] ar, int n, int k) {
		int[] ar1 = new int[n*n];
		int[] ar2 = new int[n*n];
		int m=0;
		// 4개의 배열(클래스)을 이분탐색 할 수 없으니 
		// 일단 두개의 배열로 간추
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ar1[m] = ar[0][i] + ar[1][j];
				ar2[m] = ar[2][i] + ar[3][j];
				m++;
			}
		}
		// 이분 탐색을 위해 정렬 
		Arrays.sort(ar1);
		
		// 초기화 
		int closest = 2000000000;
		int result = 2000000000;
		
		// Arr2 의 각각의 값에 대해 
		// Arr1 이분 탐색 진행 
		for(int i=0;i<ar2.length;i++) {
			
			int left =0;
			int right = ar1.length-1;
			int mid=0;
			int curk = k-ar2[i]; // arr2는 고정값이므로 빼줌. 
			
			// 이분 탐색 진행 
			// 종료 조건 고민하기.. 
			// l,r 을 옮길 때 mid 로 옮길지 작거나 크게 옮길 지에 따라 다른 듯 
			// 또 mid, l 를 구하냐에 따라 다른 듯 
			while(left-1<right) {
				mid = (left+right)/2;
				
				if(curk - ar1[mid] > 0) {
					left = mid + 1;
				}
				else if(curk - ar1[mid] < 0) {
					right = mid - 1;
				}
				else{
					result = ar1[mid] + ar2[i];
					i = ar2.length;
					break;
				}	
				
				// 절대값을 따지며 최적의 몸무개 구함. 
				if(closest >= Math.abs(curk - ar1[mid])) {
					if(closest > Math.abs(curk - ar1[mid])) {
						result = ar1[mid] + ar2[i];
					}else {
						if(result > ar1[mid] + ar2[i])
							result = ar1[mid] + ar2[i];
					}
					closest = Math.abs(curk - ar1[mid]);
				}
			}
		
		}
		System.out.println(result);
	}
}
