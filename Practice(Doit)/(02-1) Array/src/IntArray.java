// IntArray
// pg44
// 정수형 배열 
public class IntArray {
	public static void main(String args[]) {
		// a -> 정수형 배열
		// new 연산자를 통해 배열 본체를 참조하는 곳을 생성 
		// 그 후 참조하는 곳을 a에 대입 
		int[] a = new int[5];
		a[1] = 12;
		a[2] = 51;
		a[3] = a[1]*2;
		for(int i=0;i<a.length;i++)
			System.out.println("a["+i+"] = "+ a[i]);
	}
}
