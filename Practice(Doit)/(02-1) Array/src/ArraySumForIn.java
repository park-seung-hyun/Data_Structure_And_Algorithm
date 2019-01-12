// ArraySumForIn
// pg87
// 확장 For문 
public class ArraySumForIn {
	public static void main (String args[]) {
		double[] a = {1.0,2.0,3.0,4.0};
		double sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i];
		}
		System.out.printf("sum: %f", sum);
		System.out.println();
		sum = 0;
		for(double i: a) { // 확장 For문 -> 인덱스 필요없을때 자주 사용 
			sum += i;
		}
		System.out.printf("sum: %f", sum);
	}
}
