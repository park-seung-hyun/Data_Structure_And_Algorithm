// Multi99Table 
// pg36  
// 이중 반복문을 통해 테이블을 만드는 알고리즘 
public class Multi99Table {
	public static void main (String args[]) {
		System.out.println("---곱셈표---");
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%3d", i*j);
				// printf를 통해 변수의 값 출력 
			}
			System.out.println();
		}
	}
}
