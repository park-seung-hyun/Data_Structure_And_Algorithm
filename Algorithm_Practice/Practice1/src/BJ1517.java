// 1517번  
// 버블 소트 
// Bubble Sort -> 시간 초과 O(n^2)  
// Merge Sort에서 Merge 과정에서 count 

// https://blog.encrypted.gg/m/315?category=730175
// https://his130.tistory.com/64
	
import java.util.Scanner;
public class BJ1517 {
	static int[] buff; // Merge Sort 작업용 배열 
	static long count = 0; // long type (n이 500000 까지 가능..)
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		int[] ar2 = ar.clone();
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}

		mergeSort(ar, n);		
		System.out.println(count);
	}	
	// bubbleSort 
	// 버블 정렬 
	// 시간 초과로 사용 불가 
	static void bubbleSort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1])
					swap(a, j, j+1);
			}
		}
	}
	// swap 
	// 두 요소 스왑 
	static void swap(int[] ar, int idx1, int idx2) {
		int temp = ar[idx1];
		ar[idx1] = ar[idx2];
		ar[idx2] = temp;
		count++;
	}
	
	// __mergeSort
	static void __mergeSort(int[] a, int left, int right) {
		if(left<right) {
			int center = (left+right)/2;
			int i;
			int j = 0;
			int k = 0;
			int m = left;
			
			__mergeSort(a,left,center);
			__mergeSort(a,center+1,right);
			
			// Merge 과정 
			for(i=left;i<=center;i++)
				buff[j++] = a[i]; // 왼쪽 배열 임시 저장 
			
			// 현재 i,j = center+1
			// 조건 (왼쪽 배열 다다름, 오른쪽 배열 다다름)
			while(k<j && i<= right) {
				int tmi = i;
				a[m++] = (buff[k] < a[i]) ? buff[k++] : a[i++];
				
				// 오른쪽 배열이 본 배열에 편입될 때 
				// 왼쪽 배열에 남아 있는 요소의 개수 
				if(tmi < i)
					count += j-k;
			}
			while(k<j) {
				a[m++] = buff[k++];
				
			}
				
		}
	}
	// mergeSort
	static void mergeSort(int[] a, int n) {
		buff = new int[n];
		__mergeSort(a, 0, n-1);
		buff = null;
	}
}
