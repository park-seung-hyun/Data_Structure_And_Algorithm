// IntQueueTester
// pg158
// 큐 테스트 

import java.util.Scanner;
public class IntQueueTester {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue q = new IntQueue(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : "+q.size() + "/"+ q.capacity());
			System.out.print("1: 인큐, 2: 디큐, 3: 피크, 4: 덤프, 0: 종료 ");
			int menu = stdIn.nextInt();
			if(menu == 0)
				break;
			int x;
			switch(menu) {
				case 1: 
					System.out.print("데이터: ");
					x = stdIn.nextInt();
					try {
						q.enque(x);
					}catch(IntQueue.OverflowIntQueueException e) {
						
					}
					break;
				case 2:
					try {
						x = q.deque();
						System.out.println("디큐한 데이터: "+x);
					}catch(IntQueue.EmptyIntQueueException e) {
						
					}
					break;
				case 3:
					try {
						x = q.peek();
						System.out.println("피크 데이터: "+x);
					}catch(IntQueue.EmptyIntQueueException e) {
						
					}
					break;
				case 4:
					q.dump();
					break;
			}
		}
	}
}
