// 1966번 
// 프린터 큐 
// 자료구조에서 배운 큐의 성질 이용 (링버퍼, front, rear)

import java.util.Scanner;
public class BJ1966 {
	public static void main (String[] arg) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			int m = stdIn.nextInt();
			int[] pr = new int[n];
			for(int j=0;j<n;j++) {
				pr[j] = stdIn.nextInt();
			}
			qPrinter(pr,n,m);
		}
	}
	// qPrinter
	// 자료구조에서 배운 큐의 성질을 이용 
	// 링버퍼를 사용하여 front, rear 인덱싱을 통해 큐 구현 
	static void qPrinter(int[] pr, int n, int m) { // n -> 문서 개수 , m -> 문서 위치 
		int[] q = new int[1000]; // 링 버퍼 (중요도 저장)
		int[] q_index = new int[1000]; // 링 버퍼 (인덱스 저장)
		
		for(int i=0;i<n;i++) {
			q[i] = pr[i];
			q_index[i] = i;
		}
		
		int front = 0; // 제일 처음 요소 
		int rear = n-1; // 제일 마지막 요소 
		int count = 0;
		
		// 모든 문서 출력할 때까지 반복 
		while(count<n) {
			int current = q[front];
			int current_index = q_index[front];
			
			boolean flag = true;
			// front보다 큰 문서 유무 확인 
			for(int i= front+1; i<= rear; i++) {
				if(current < q[i]) {
					flag = false;
					break;
				}	
			}
			
			if(flag == true) {
				count++;
				front ++;
				// 출력하려는 문서가 원하는 문서일 경우 
				if (current_index == m) {
					System.out.println(count);
					break;
				}
				
			}else {
				// front 문서보다 중요도가 큰 문서가 존재할 경우 
				front++;
				q[++rear] = current;
				q_index[rear] = current_index;
			}
			
		}
	}
}
