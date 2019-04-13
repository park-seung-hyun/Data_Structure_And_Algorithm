// 삼성 기출 
// 13458번
// 시험 감독  
// 나머지 
// 총감독관을 무조건 빼면 음수가 나올 수도 있음. 
// 테스트 케이스는 다 맞았음.. -> 반례 찾기..

import java.util.Scanner;
public class BJ13458 {
	static int[] room;
	static int b;
	static int c;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		room =new int[n];
		for(int i=0;i<n;i++) room[i] = stdIn.nextInt();
		b = stdIn.nextInt();
		c = stdIn.nextInt();
		
		long sum = 0;
		for(int i=0;i<n;i++) {
			sum += getSv(room[i]);
		}
		System.out.println(sum);
	}
	static long getSv(int r) {
		int remain = r-b;
		if(remain<0) return 1; 
		int bu = remain/c;
		if(remain % c != 0) bu++;
		return bu+1;
	}
}
