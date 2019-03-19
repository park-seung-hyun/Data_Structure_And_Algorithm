// 1007번 (복습)
// 벡터 매칭
// 벡터의 성질 이용 
// 결국 n개 중 n/2를 골라서 다 더하고, 나머지는 다 빼면 됨.
// solve -> 순열 -> 시간초과 
// solve2 -> dfs(완전탐색) -> 시간초과
// solve3 -> dfs(절반만 탐색) -> 성공
// solve4 -> 조합(Combination) -> 성공 

import java.util.Arrays;
import java.util.Scanner;
public class Re_BJ1007 {
	static Dot[] d;
	
	static double min;
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			min =  Double.MAX_VALUE;
			int n = stdIn.nextInt();
			d = new Dot[n];
			visited = new int[n];
			for(int j=0;j<n;j++) {
				int x = stdIn.nextInt();
				int y = stdIn.nextInt();
				d[j] = new Dot(x,y);
			}
			solve4(n);
		}
	}
	static void solve4(int n) {
		int[] ar = new int[n];
		combination(ar, 0,n,n/2,0);
		System.out.println(min);
	}
	static int combinationCount(int n, int r) {
		if(n == r || r==0) return 1;
		else return combinationCount(n-1,r) + combinationCount(n-1,r-1);
	}
	static void combination(int[] arr, int index, int n, int r, int target) { 
		if (r == 0) print(arr, index,n);
		else if (target == n) return; 
		else { 
			arr[index] = target; 
			combination(arr, index + 1, n, r - 1, target + 1); 
			combination(arr, index, n, r, target + 1); 
		} 
	}
	static void print(int[] arr, int length,int n) { 
		int[] check = new int[n];
		for(int i=0;i<length;i++) {
			check[arr[i]] = 1;
		}
		double x = 0;
		double y = 0;
		for(int i=0;i<n;i++) {
			if(check[i] == 1) {
				x+=d[i].x;
				y+=d[i].y;
			}else {
				x-=d[i].x;
				y-=d[i].y;
			}
		}
		double sum = Math.sqrt(x*x + y*y);
		if(min > sum)
			min = sum;
	}
	static void solve3(int n) {
		dfs2(n,0,0);
		System.out.println(min);
	}
	static void dfs2(int n,int cnt, int index) {
		if(cnt == n/2) {
			double x = 0;
			double y = 0;
			for(int k=0;k<n;k++) {
				if(visited[k] == 1) {
					x+=d[k].x;
					y+=d[k].y;
				}else {
					x-=d[k].x;
					y-=d[k].y;
				}
			}
			double sum = Math.sqrt(x*x + y*y);
			if(min > sum)
				min = sum;
			return;
		}
		if(index == n) return;
		
		dfs2(n,cnt, index+1);
		visited[index] = 1;
		dfs2(n,cnt+1, index+1);
		visited[index] = 0;
	}
	static void solve2(int n) {
		
		visited[0] = 1;
		dfs(0, 0, 0,0);
		
		System.out.println(min);
	}
	static void dfs(int n, int total, double sumX, double sumY) {
		if(total == visited.length-1) {
			double sum = Math.pow(sumX, 2);
			sum += Math.pow(sumY, 2);
			sum = Math.sqrt(sum);
			if(min > sum)
				min = sum;
			
			return;
		}
		for(int i=0;i<visited.length;i++) {
			if(visited[i] == 0) {
				if(total%2 == 0) {
					int x = d[n].x;
					int y = d[n].y;
					int x2 = d[i].x;
					int y2 = d[i].y;
					visited[i] = 1;
					dfs(i, total+1, sumX + x2-x, sumY + y2-y);
					visited[i] = 0;
				}else {
					visited[i] = 1;
					dfs(i, total+1, sumX, sumY);
					visited[i] = 0;
				}
			}
		}
	}
	static void solve(int n) {
		int[] permu = new int[n];
		for(int i=0;i<n;i++) {
			permu[i] = i;
		}
		double min = 1000000000;
		
		do {
			double newMin = getMin(permu);
			if(newMin < min)
				min = newMin;
			
		}while(next_Permutation(permu) && permu[0] == 0);
		System.out.println(min);
	}
	static double getMin(int[] ar) {
		long sumX = 0;
		long sumY = 0;
		for(int i=0;i<ar.length;i+=2) {
			long x = d[ar[i]].x;
			long y = d[ar[i]].y;
			long x2 = d[ar[i+1]].x;
			long y2 = d[ar[i+1]].y;
			sumX += x2-x;
			sumY += y2-y;
		}
		double sum = Math.pow(sumX, 2);
		sum += Math.pow(sumY, 2);
		sum = Math.sqrt(sum);
		return sum;
	}
	static boolean next_Permutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1]>=ar[i]) i-=1;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1]>=ar[j]) j-=1;
		swap(ar, i-1, j);
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
}
class Dot{
	int x;
	int y;
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
