// PrimeNumber3 
// pg78 
// 소수의 나열 (개선2)  
public class PrimeNumber3 {
	public static void main(String args[]) {
		int counter = 0;
		
		int ptr = 0;
		int[] prime = new int[500];
		
		prime[ptr++] = 2; // 2는 미리 저장 
		prime[ptr++] = 3; // 3은 미리 저장 
		// 현재 ptr = 2 
		
		for(int n=5;n<=1000;n=n+2) { // 5~1000까지 홀수 숫자 중 소수인 숫자를 찾음.  
			boolean flag = false;
			// n보다 작은 소수들로만 반복 
			for(int i=1;prime[i]*prime[i]<=n;i++) { // n의 제곱근까지만 나눠보면됨. 그 이후로는 반복이므로 무의미 
				counter+=2;
				if(n%prime[i]==0) { // 나누어떨어지면 탈출 
					flag = true;
					break;
				}
			}
			if(flag == false) { // 소수일 경우 
				prime[ptr++] = n;
				counter++;
			}
		}
		for(int i=0;i<ptr;i++) {
			System.out.println(prime[i]);
		}
		System.out.println("나눗셈 횟수: "+ counter);
	}
}
