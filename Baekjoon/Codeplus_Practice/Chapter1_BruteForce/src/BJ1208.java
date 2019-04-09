import java.util.Arrays;
import java.util.Scanner;

public class BJ1208 {
	static int[] num;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int s = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) num[i] = stdIn.nextInt();
		solve(n,s);
	}
	static void solve(int n, int s) {
		Arrays.sort(num);
		for(int i=0;i<n-1;i++) {
			int l = i;
			int r = i;
			int sum = num[i];
			while(true) {
				if(sum == s) {
					cnt ++;
					break;
				}
				else if(sum < s) {
					if(r == n-1) break;
					r++;
					sum += num[r];
				}else{
					break;
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	static void go(int id, int sum, int n, int s) {
		
		if(id == n) return;
		if(sum == s) {
			cnt++;
			return;
		}
		if(sum > s) return;
		go(id+1, sum+num[id], n,s);
		go(id+1, sum, n,s);
	}
}
