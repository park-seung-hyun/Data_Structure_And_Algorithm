import java.util.Scanner;

// ReverseArray 
// pg60 
// 정수형 배열 (역순)   
public class ReverseArray {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: "); 
		int N = stdIn.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = stdIn.nextInt();
		}
		reverse(arr);
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	static void reverse(int[] ar) {
		// 배열 본체의 참조값을 전달 받음. 
		for(int i=0 ;i<ar.length/2;i++) {
			swap(ar, i, ar.length-i-1);
		}
	}
	// 자주 사용되는 기능은 독립적인 메서드로 만듬. 
	static void swap(int[] ar, int id1, int  id2) {
		// 배열 본체의 참조값을 전달 받음. 
		// swap 내의 ar는 결국 main의 arr 배열 본체를 참조함. 
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
}
