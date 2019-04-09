import java.util.Scanner;

public class BJ1806 {
	static int[] num;
	public static void main(String[] args) {
		Scanner stdIn =new Scanner(System.in);
		int n = stdIn.nextInt();
		int s = stdIn.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++)num[i]=stdIn.nextInt();
		solve(n,s);
	}
	static void solve(int n, int s) {
		int i = 0;
		int j = 0;
		int sum = num[i];
		int minLen = Integer.MAX_VALUE;
		while(true) {
			if(sum >= s) {
				if(minLen > (j-i+1)) minLen = j-i+1;
				sum -= num[i];
				if(i == n-1) break;
				i++;
				if(j<i) j = i;
			}
			if(sum < s) {
				if(j == n-1) break;
				j++;
				sum += num[j];
			}
		}
		System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
	}
}
