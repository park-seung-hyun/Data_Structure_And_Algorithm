// IntArrayInit
// pg48
// 정수형 배열 (복제)  
public class CloneArray {
	public static void main (String args[]) {
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();
		
		b[3] = 0;
		
		// a는 변하지 않음. 
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"] = "+ a[i]);
		}
		// b만 변경되는 것을 알 수 있음.
		for(int i=0;i<a.length;i++) {
			System.out.println("b["+i+"] = "+ b[i]);
		}
	}
}
