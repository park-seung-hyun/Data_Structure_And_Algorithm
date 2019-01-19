// IntStackTester
// pg142 
// 스택 테스트 

import java.util.Scanner;
public class IntStackTester {
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : "+s.size() + "/"+ s.capacity());
			System.out.print("1: 푸시, 2: 팝, 3: 피크, 4: 덤프, 0: 종료 ");
			int menu = stdIn.nextInt();
			if(menu == 0)
				break;
			int x;
			switch(menu) {
				case 1: 
					System.out.print("데이터: ");
					x = stdIn.nextInt();
					try {
						s.push(x);
					}catch(IntStack.OverflowIntStackException e) {
						
					}
					break;
				case 2:
					try {
						x = s.pop();
						System.out.println("팝한 데이터: "+x);
					}catch(IntStack.EmptyIntStackException e) {
						
					}
					break;
				case 3:
					try {
						x = s.peek();
						System.out.println("피크 데이터: "+x);
					}catch(IntStack.EmptyIntStackException e) {
						
					}
					break;
				case 4:
					s.dump();
					break;
			}
		}
	}
}
