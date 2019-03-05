// 1806번 (복습)
// 부분합 
// Sliding Window 
// 종료 조건 까다로움...

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ1806 {
	static long[] ar;
	static int n;
	static int s;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner (System.in);
		n = stdIn.nextInt();
		s = stdIn.nextInt();
		ar = new long[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve2();
	}
	static void solve2() {
		
		long sum = 0;
		int min = n+1;
		int i=0;
		int l = 0;
		int r = 0;
		
		while(!(l==n && r == n)) { // l, r 둘 다 n에 도달했을 경우 
			
			if(getSum(l,r)>=s) { // 합이 s 이상인지 구분 (이상일 경우)
				if(min > r-l+1) { // 최소 길이 비교 
					min = r-l+1;
				}	
				if(l<r) {
					l++;
				}else { // 현재 길이가 1인데 s 이상일 경우 
					break;
				}
				
			}else { // 이하일 경우 
				if(r+1<n)
					r++;
				else
					break;
			}
			
		}
		if(min > n) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
	}
	static int getSum(int l, int r) {
		int sum = 0;
		for(int i=l;i<=r;i++) {
			sum += ar[i];
		}
		return sum;
	}
	static void solve() {
		
		long sum = 0;
		int min = n+1;
		int i=0;
		Queue<Long> q = new LinkedList<Long>();
		
		while(i<=n) {
			
			if(sum>=s) {
				if(min > q.size()) {
					min = q.size();
				}		
				long r = q.remove();
				sum-=r;
				
			}else{
				if(i!=n) {
					q.add(ar[i]);
					sum+=ar[i];
					i++;
				}else {
					break;
				}
			}
		}
		
		if(min > n) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
		
	}
	
}
