// PhysicalExamination
// pg92 
// 클래스 형 배열 
import java.util.Scanner;

public class PhysicalExamination {
	static final int VMAX = 21;
	static class PhyscData{
		String name;
		int height;
		double vision;
		PhyscData(String n, int h, double v){ // 생성자 
			this.name =n;
			this.height = h;
			this.vision = v;
		}
	}
	static double aveHeight(PhyscData[] dat) {
		double sum =0;
		for(int i=0;i<dat.length;i++) {
			sum += dat[i].height;
		}
		return sum/dat.length;
	}
	static void distVision(PhyscData[] dat, int[] dist) {
		int i=0;
		dist[i] = 0;
		for(i=0;i<dat.length;i++) {
			if(dat[i].vision>=0.0 && dat[i].vision<VMAX/10.0)
				dist[(int)(dat[i].vision*10)]++;
		}
	}
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = {
				new PhyscData("박승현",177,0.9),
				new PhyscData("박현승",178,0.3),
				new PhyscData("승박현",176,0.2),
				new PhyscData("승현박",174,0.1)
		};
		int[] vdist = new int[VMAX];
		
		System.out.println("- 신체검사 리스트 -");
		System.out.println("  이름, 키 , 시력 ");
		System.out.println("---------------");
		for(int i=0;i<x.length;i++) {
			System.out.printf("%-8s%3d%5.1f\n",x[i].name,x[i].height,x[i].vision);
		}
		System.out.printf("평균 키 %5.1f cm\n", aveHeight(x));
		distVision(x, vdist);
		System.out.println("시력 분포 ");
		for(int i=0;i< VMAX;i++) {
			System.out.printf("%3.1f~ %2d\n", i /10.0, vdist[i]);
		}
	}
}
