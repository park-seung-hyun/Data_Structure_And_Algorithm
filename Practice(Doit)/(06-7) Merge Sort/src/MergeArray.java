// MergeArray
// pg243
// 병합 정렬의 병합 과정  

import java.util.Arrays;

public class MergeArray {
	static void merge(int[] a,int na, int[] b, int nb, int[] c, int nc) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while(pa<na && pb<nb) { // a, b 배열의 인덱스가 둘다 끝에 다다르지 않았을 경우 
			c[pc++] = (a[pa] <= b[pb] ? a[pa++] : b[pb++]); // 후위 연산자를 통해 대입 후 증가 
		}
		while(pa<na) { // a 배열 남은 요소 처리 
			c[pc++] = a[pa++];
		}
		while(pb<nb) { // b 배열 남은 요소 처리 
			c[pc++] = b[pb++];
		}
	}
	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
		int[] a = {2,4,6,8,11,13};
		int[] b = {1,2,3,4,9,16,21};
		int[] c = new int[13];
		System.out.println("두 배열의 병합 Merge");
		merge(a,a.length,b,b.length,c,c.length);
		System.out.println(Arrays.toString(c));
	}
}
