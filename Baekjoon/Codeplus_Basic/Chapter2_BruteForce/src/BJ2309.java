// 2309번
// 일곱 난쟁이
// 브루트 포스 
// O(N^2)

import java.util.Arrays;
import java.util.Scanner;
public class BJ2309 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int[] ar = new int[9];
		int sum = 0;
		
		for(int i=0;i<9;i++) {
			ar[i] = stdIn.nextInt();
			sum += ar[i];
		}
		solve(ar, sum);
		
	}
	static void solve(int[] ar, int s) {
		int a = 0;
		int b = 0;
		// 9명 중 2명을 고르는 모든 경우의 수 
		// j = i+1 (i=j일 경우 고려하지 않도록)
		for(int i=0;i<9;i++) {
			for(int j = i+1;j<9;j++) {
				int sum = s - ar[i] - ar[j];
				if(sum == 100) {
					a = ar[i];
					b = ar[j];
					break;
				}				
			}
		}
		
		Arrays.sort(ar);
		
		for(int i=0;i<9;i++){
			if(ar[i]==a||ar[i]==b)
				continue;
			System.out.println(ar[i]);
		}
	}
}
