// IntArrayInit
// pg47
// 정수형 배열 (초기화) 
public class IntArrayInit {
	public static void main (String args[]) {
		int[] a = {1,2,3,4,5};
		int[] b = new int[] {1,2,3,4,5};
		
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"] = "+ a[i]);
		}
		for(int i=0;i<a.length;i++) {
			System.out.println("b["+i+"] = "+ b[i]);
		}
	}
}
