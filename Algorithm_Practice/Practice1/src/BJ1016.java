// 1016번 
// 제곱ㄴㄴ수  
// 에라토스테네스의 체 (Eratosthenes) 응용 

// https://deque.tistory.com/76

import java.util.Scanner;
public class BJ1016 {
	static int sum=0;
	static boolean[] check = new boolean[1000001];

	public static void main(String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		long min = stdIn.nextLong();
		long max = stdIn.nextLong();
	
		getSquareNNN(min, max);
		
	}
	// getSquareNNN
	// 제곱ㄴㄴ수를 구하는 함수 
	// 에라토스테네스의 체를 응용 
	static void getSquareNNN(long min, long max) {

		for(long i=2;i*i<=max;i++) {
			long start = min/(i*i);
			if(start*i*i != min) start++;
			for(long j= start;i*i*j<=max;j++) {	// i=2 -> 2^2*1 , 2^2*2, 2^2*3... 모두 제곱수 2^2에 나눠짐.
				check[(int) (i*i*j - min)] = true;
			}
		}
		for(int i=0;i<= max-min;i++) {
			if(check[i]==false)
				sum++;
		}
		System.out.println(sum);
		
	}
}
