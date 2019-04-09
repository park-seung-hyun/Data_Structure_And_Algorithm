
import java.util.Arrays;
import java.util.Scanner;
public class BJ1644 {
	
	static int[] prime;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		if(n == 1) {System.out.println(0);
			return;
		}
		arathos(n);
		solve(n);
	}
	static void solve(int n) {
		int len = 0;
		for(int i=0;i<n;i++) {
			if(prime[i] == 0) {
				len = i; 
				break;
			}
		}
		int count = 0;
		int i=0;
		int j=0;
		int sum = prime[i];
		int s = n;
		while(true) {
//			System.out.println(i + " " + j+ " "+sum);
			if(sum == s) {
				count++;
				if(i == len-1) break;
				
				sum -= prime[i];
				i++;
				if(i>j) j = i;
			}
			else if(sum > s) {
				if(i == len-1) break;
				sum -= prime[i];
				i++;
				if(i>j) j = i;
			}else {
				if(j == len-1) break;
				j++;
				sum += prime[j];
			}
		}		
		System.out.println(count);
	}
	static void arathos(int n){
		int pp = 0;
		prime = new int[n+1];
		check = new boolean[n+1];
		for(int i=2;i<=n;i++) {
			if(check[i] == false) {
				prime[pp++] = i;
				for(int j=2*i;j<=n;j+=i) {
					check[j] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(prime));
	}
}
