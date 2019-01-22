// 6588번 
// 골드바흐의 추측 
// 소수(Prime) 검정을 위해 
// 에라토스테네스의 체 (Eratosthenes) 사용 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BJ6588 {
	static final int size = 1000000;
	static boolean[] isNotPrime = new boolean[size];
	public static void main (String args[]) {
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
		
		eratosthenes();
		getNumbers(inputArr);
		
	}
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
	static void getNumbers(int[] arr) {

		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				break;
			}
			for(int j=3;j<=(arr[i]/2);j=j+2) {
				int n1 = j;
				int n2 = arr[i]-j;
				
				if(!(isNotPrime[n1]||isNotPrime[n2])) {
					System.out.printf("%d = %d + %d \n", arr[i],n1,n2);
					break;
				}
				
				if(j+2>arr[i]/2)
					System.out.print("Goldbach's conjecture is wrong.");	
			}
			
		}
	}
}
