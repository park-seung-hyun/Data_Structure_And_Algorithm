// 6588번 
// 골드바흐의 추측 
// 소수(Prime) 검정을 위해 
// 에라토스테네스의 체 (Eratosthenes) 사용 

// http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220938630812&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BJ6588 {
	// 입력 범위 크기의 배열 생성 
	// 소수일 경우 true
	// 소수가 아닐 경우 false 
	static final int size = 1000000;
	static boolean[] isNotPrime = new boolean[size];
	public static void main (String args[]) {
		// 입출력
		Scanner stdIn = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<Integer>();
		while(true) {
			int i = stdIn.nextInt();
			if(i != 0)
				input.add(i);
			else
				break;
		}
		int[] inputArr = new int[input.size()];
		for(int i=0;i<inputArr.length;i++)
			inputArr[i] = input.get(i);
		
		// 에라토스테네스 
		eratosthenes();
		getNumbers(inputArr);
		
	}
	// eratosthenes 
	// 에라토스테네스의 체 
	// 사전의 입력 범위에 대해 소수 여부를 미리 계산 
	static void eratosthenes() {
		for(int i=2 ; i*i<size ; i++) {
			if(!(isNotPrime[i])) {
				for(int j=i*i;j<size;j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		isNotPrime[1]=true;
	}
	// getNumbers 
	// 정답 계산 
	static void getNumbers(int[] arr) {

		for(int i=0;i<arr.length;i++) {
			// 0일 경우 종료 
			if(arr[i]==0) {
				break;
			}
			// 해당 숫자를 쪼갬 
			for(int j=3;j<=(arr[i]/2);j=j+2) {
				int n1 = j;
				int n2 = arr[i]-j;
				
				// 소수 여부 판단 
				if(!(isNotPrime[n1]||isNotPrime[n2])) {
					System.out.printf("%d = %d + %d \n", arr[i],n1,n2);
					break;
				}
				
				// 정답이 없을 경우 
				if(j+2>arr[i]/2)
					System.out.print("Goldbach's conjecture is wrong.");	
			}
			
		}
	}
}
