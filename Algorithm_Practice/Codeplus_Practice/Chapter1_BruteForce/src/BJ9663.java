import java.util.Arrays;
import java.util.Scanner;

public class BJ9663 {
	static int ans = 0;
	static int[] state;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		state = new int[n];
		Arrays.fill(state, -1);
		for(int i=0;i<n;i++) {
			state[0] = i;
			go(1, state, n);
			state[0] = -1;
		}
		System.out.println(ans);
	}
	static void go(int id, int[] state, int n) {
		
		if(id == n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isPossible(state, id, i, n)) {
				state[id] = i;
				go(id+1,state,n);
				state[id] = -1;
			}
		}
	}
	
	// 이거 너무 오래 걸리는 듯 
	static boolean isPossible(int[] state, int x, int y, int n) {
		
		for(int i=0;i<x;i++) {
			int ox = i;
			int oy = state[i];
			if(ox == x || oy == y) return false;
			if(Math.abs(x-ox) == Math.abs(y-oy)) return false;
		}
		 return true;
	}
}
