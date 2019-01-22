// 9095번 
// 1, 2, 3 더하기 
// 동적 계획법 (Dynamic Programming)
	
import java.util.Scanner;

public class BJ9095 {
	static int[] memory;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		
		memory = new int[11];
		for(int i=0;i<memory.length;i++) {
			memory[i] = -1;
		}
		memory[0] = 1;
		memory[1] = 1;
		
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();	
		}
		for(int i=0;i<n;i++) {
			System.out.println(dp2(ar[i]));
		}
		
	}
	static int dp(int k) {
		
		if(memory[k]!=-1)
			return memory[k];
		
		memory[k] = 0;
		
		for(int i=1;i<=3;i++) {
			
			if(k>=i) {
				if(memory[k-i]==-1) {
					dp(k-i);
				}
				memory[k] += memory[k-i];
			}				
				
		}
		return memory[k];
	}
	static int dp2(int k) {
		
		memory[2] = 2;
		memory[3] = 4;
		
		if(memory[k] != -1) {
			return memory[k];
		}
		
		if(k>=4) {
			for(int i=4;i<=k;i++) {
				memory[i] = memory[i-3]+memory[i-2]+memory[i-1]; 
			}
		}
			
		return memory[k];
	}
}
