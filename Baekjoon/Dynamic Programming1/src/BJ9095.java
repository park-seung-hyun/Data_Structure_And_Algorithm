// 9095번 
// 1, 2, 3 더하기 
// 동적 계획법 (Dynamic Programming) 

// https://baked-corn.tistory.com/117
	
import java.util.Scanner;
public class BJ9095 {
	// 해당 인덱스가 k일 경우 만들 수 있는 방법 수를 저장한 배열 
	static int[] memory;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		
		// 초기화 
		memory = new int[11];
		for(int i=0;i<memory.length;i++) { // 0~10
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
	// dp
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Top-Down 방식 
	static int dp(int k) {
		
		// 배열에 저장되어 있을 경우 바로 반환 
		if(memory[k]!=-1)
			return memory[k];
		
		// 없을 경우 방법의 수를 새로 연산 
		memory[k] = 0; // 시작을 0 
		
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
	// dp2
	// 동적 계획법 
	// 기존 배열에 저장되어 있는 값을 사용하여 계산 감소 
	// 나름 Bottom-Up 방식 
	static int dp2(int k) {
		
		// 초기화 
		memory[2] = 2;
		memory[3] = 4;
		
		if(memory[k] != -1) {
			return memory[k];
		}
		
		if(k>=4) {
			for(int i=4;i<=k;i++) {
				// 점화식 
				memory[i] = memory[i-3]+memory[i-2]+memory[i-1]; 
			}
		}
			
		return memory[k];
	}
}
