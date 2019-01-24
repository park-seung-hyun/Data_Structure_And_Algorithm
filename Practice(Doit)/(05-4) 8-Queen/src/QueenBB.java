// QueenB 
// pg192
// 8퀸 
// Branching and Bounding
// 각 열에는 하나의 퀸 존재할 때 모든 조합 출력 
// + 각 행에는 하나의 퀸 존재 

public class QueenBB {
	// 퀸의 배치
	// i번째 열에 pos[i] 행
	static int[] pos = new int[8]; 
	// 각 행에 퀸을 배치했는지 체크 
	static boolean[] flag = new boolean[8]; 
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
			if(flag[j]==false) { // 해당 j 행에 퀸이 배치되었나 확인 
				pos[i] = j;
				if(i==7)
					print();
				else {
					flag[j] = true;
					set(i+1); // 끝나면 퀸이 j행에서 제거됨. 
					flag[j] = false;
				}
					
			}
		}
	}
	public static void main(String[] args) {
		set(0);
		System.out.println(count);
	}
}
