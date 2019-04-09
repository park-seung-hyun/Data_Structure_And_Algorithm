import java.util.Scanner;

public class BJ2003 {
	static int[] num;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) num[i] = stdIn.nextInt();
		solve(n,k);
	}
//	static void solve(int n, int k) {
//		go(1,num[0],n,k);
//		System.out.println(cnt);
//	}
//	static void go(int id, int sum, int n, int k) {
//		if(sum>k) return;
//		if(sum == k) {
//			cnt ++;
//			return;
//		}
//		if(id == n) return;
//		go(id+1, sum + num[id] , n,k);
//		go(id+1, num[id], n, k);
//	}
	static void solve(int n, int k) {
		int i = 0;
		int j = 0;
		int sum = num[i];
		while(true) {
			if(sum == k) {
				cnt++;
				sum -= num[i];
				i++;
			}
			else if(sum < k){
				if(j == n-1) break;
				j++;
				sum += num[j];
			}
			else if(sum > k) {
				if(i == n-1) break;
				sum -= num[i];
				i++;
			}
		}
		System.out.println(cnt);
	}
}
