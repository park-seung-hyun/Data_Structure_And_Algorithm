// PrimeNumber1 
// pg72
// 소수의 나열   
public class PrimeNumber1 {
	public static void main(String args[]) {
		int counter = 0;
		
		for(int n=2;n<=1000;n++) { // 2~1000까지 숫자 중 소수인 숫자를 찾음. 
			int i;
			for(i=2;i<n;i++) { // 2~n-1까지 나누어떨어지는 숫자가 있는지 찾음. 
				counter++;
				if(n%i==0) // 나누어떨어지면 탈출 
					break;
			}
			if(n==i) // 소수일 경우 
				System.out.println(n);
		}
		
		System.out.println("나눗셈 횟수: "+ counter);
	}
}
