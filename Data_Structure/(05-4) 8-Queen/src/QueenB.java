// QueenB 
// pg191
// 8퀸 
// Branching 
// 각 열에는 하나의 퀸 존재할 때 모든 조합 출력 
// 모든 조합 수 = 16777216
// 어려움..

public class QueenB {
	// 퀸의 배치
	// i번째 열에 pos[i] 행
	static int[] pos = new int[8]; 
	static int count = 0;
	static void print() {
		for(int i=0;i<8;i++) {
			System.out.printf("%d", pos[i]);
		}
		count++;
		System.out.println();
	}
	static void set(int i) {
		for(int j=0;j<8;j++) {
			pos[i] = j;
			if(i==7)
				print();
			else
				set(i+1);
		}
	}
	public static void main(String[] args) {
		set(0);
		System.out.println(count);
	}
}
