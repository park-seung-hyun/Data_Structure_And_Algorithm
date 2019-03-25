// EightQueen 
// pg194
// 8퀸 
// 기존에는 8Rock 문제
// 같은 대각선에 없도록 규칙 추가 

public class EightQueen {
	// 퀸의 배치
	// i번째 열에 pos[i] 행
	static int[] pos = new int[8]; 
	static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 배치했는지 체크 
	static boolean[] flag_b = new boolean[15]; // 오른쪽 상향 대각선 방향으로 퀸을 배치했는지 체크 /
	static boolean[] flag_c = new boolean[15]; // 오른쪽 하향 대각선 방향으로 퀸을 배치했는지 체크 \
	
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
			if(flag_a[j]==false&& // 해당 j행에 퀸이 배치되었나 확인 
					flag_b[i+j]==false&& // / 대각선에 퀸이 배치되었나 확인 
						flag_c[i-j+7]==false) { // \ 대각선에 퀸이 배치되었나 확인  
				pos[i] = j;
				if(i==7)
					print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] =  true;
					set(i+1); // 끝나면 퀸이 j행에서 제거됨. 
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] =  false;
				}
					
			}
		}
	}
	public static void main(String[] args) {
		set(0);
		System.out.println(count);
	}
}
