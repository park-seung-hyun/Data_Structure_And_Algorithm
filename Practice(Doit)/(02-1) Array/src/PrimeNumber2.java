// PrimeNumber2 
// pg75
// 소수의 나열 (개선1) 
public class PrimeNumber2 {
	public static void main(String args[]) {
		int counter = 0;
		
		int ptr = 0;
		int[] prime = new int[500];
		
		prime[ptr++] = 2; // 2는 미리 저장 
		
		for(int n=3;n<=1000;n=n+2) { // 3~1000까지 홀수 숫자 중 소수인 숫자를 찾음.  
			int i;
			// n보다 작은 소수들로만 반복 
			for(i=1;i<ptr;i++) { // 현재 prime 개수만큼만 반복 (어차피 홀수만 하므로 index가 0인 2는 확인 필요 없음. )
				counter++;
				if(n%prime[i]==0) // 나누어떨어지면 탈출 
					break;
			}
			if(ptr==i) // 소수일 경우 
				prime[ptr++] = n;
		}
		for(int i=0;i<ptr;i++) {
			System.out.println(prime[i]);
		}
		System.out.println("나눗셈 횟수: "+ counter);
	}
}
