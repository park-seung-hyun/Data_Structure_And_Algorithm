// SortCalendar 
// pg252 
// Merge Sort 
// 표준 라이브러리로 제공되는 Arrays.sort 사용 

import java.util.Arrays;
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

public class SortCalendar {
	public static void main (String[] args) {
		GregorianCalendar[] x = {
				new GregorianCalendar(2017,NOVEMBER,1),
				new GregorianCalendar(1963,OCTOBER,18),
				new GregorianCalendar(1985,APRIL,5)
		};
		
		// Sort 
		Arrays.sort(x); // 자연 정렬 
		
		for(int i=0;i<x.length;i++) {
			System.out.printf("%d / %d / %d \n", x[i].get(YEAR), x[i].get(MONTH)+1, x[i].get(DATE));
		}
	}
}
