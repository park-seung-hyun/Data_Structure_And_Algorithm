// PhysExamSearch
// pg128 
// 이진 검색 (Binary Search)
// 표준 라이브러리로 제공되는 Arrays.binarySearch 사용 
// 자연 정렬로 정렬되지 않은 배열에서 검색하기
// Comparator 사용 

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PhysExamSearch {
	
	// PhyscData의 대소 비교를 하기 떄문에 내부에 Comparator를 구현하는 클래스를 정의하고, 인스턴스 생성 
	static class PhyscData2 { 
		private String name;
		private int height;
		private double vision;
		
		public PhyscData2(String n, int h, double v) {
			this.name = n;
			this.height = h;
			this.vision = v;
		}
		public String toString() {
			return name+" "+height+" "+vision;
		}
		
		// Comparator를 구현하는 클래스의 인스턴스 생성 -> 
		public static final Comparator<PhyscData2> HEIGHT_ORDER  = new HeightOrderComparator();
		
		// 클래스 정의 -> Comparator implement 
		private static class HeightOrderComparator implements Comparator<PhyscData2>{
			// 대소 비교를 정의 
			public int compare(PhyscData2 d1, PhyscData2 d2) {
				return (d1.height>d2.height) ? 1 :
					   (d1.height<d2.height) ? -1 : 0;
			}
		}
	}
		
		
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData2[] x = {
				new PhyscData2("똥뚱",176,1.0),
				new PhyscData2("박승현",177,1.0),
				new PhyscData2("박승순",180,2.0),
				new PhyscData2("박승쑨",183,3.0),
		};
		System.out.print("몇센티를 찾나요?? ");
		int height = stdIn.nextInt();
		
		// 자연 정렬되지않은 배열이므로
		// 마지막 파라미터로 대소비교 방법을 구현한 클래스의 인스턴스인 HEIGHT_ORDER를 넣음. 
		int idx = Arrays.binarySearch(
				x, 
				new PhyscData2("",height,0.0), 
				PhyscData2.HEIGHT_ORDER);
		
		System.out.println(idx);
		if(idx < 0)
			System.out.println("검색 값이 없습니다.");
		else {
			System.out.println("x["+idx+"] 에 있습니다.");
			System.out.println("찾는 데이터: "+ x[idx]);
			}
	}
}
