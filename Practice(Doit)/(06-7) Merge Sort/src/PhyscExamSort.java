// PhyscExamSort 
// pg253
// Merge Sort 
// 표준 라이브러리로 제공되는 Arrays.sort 사용 
// 자연 정렬이 필요하지 않은 경우 Comparator 사용 

import java.util.Arrays;
import java.util.Comparator;

public class PhyscExamSort {
	
	// PhyscData의 대소 비교를 하기 떄문에 내부에 Comparator를 구현하는 클래스를 정의하고, 인스턴스 생성 
	static class PhyscData{
		String name;
		int height;
		double vision;
		PhyscData(String name,int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		// Comparator를 구현하는 클래스의 인스턴스 생성 -> 
		static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		// 클래스 정의 -> Comparator implement 
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {
				// 대소 비교를 정의  
				return (d1.height>d2.height) ? 1 : (d1.height<d2.height) ? -1 : 0;
			}
		}
	}
	public static void main(String[] args) {
		PhyscData[] x = {
				new PhyscData("박승현1",177,1.0),
				new PhyscData("박승현2",190,0.3),
				new PhyscData("박승현3",178,0.2)
		};
		Arrays.sort(x, PhyscData.HEIGHT_ORDER);
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i].toString());
		}
	}
	
}
