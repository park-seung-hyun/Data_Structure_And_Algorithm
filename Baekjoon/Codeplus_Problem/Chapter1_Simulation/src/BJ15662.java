// 15662번
// 톱니바퀴2
// 시뮬레이션
// 톱니바퀴랑 똑같은 문제 

//import java.util.Scanner;
//public class BJ15662 {
//	static T[] ts;
//	static int[][] order;
//	static int[] visited;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int cnt = stdIn.nextInt();
//		ts = new T[cnt];
//		visited = new int[cnt];
//		stdIn.nextLine();
//		for(int i=0;i<cnt;i++) {
//			int[] ar = new int[8];
//			String s = stdIn.nextLine();
//			for(int j=0;j<8;j++) {
//				ar[j] = s.charAt(j)-'0';
//			}
//			ts[i] = new T(i, ar);
//		}
//		int o = stdIn.nextInt();
//		order = new int[o][2];
//		for(int i=0;i<o;i++) {
//			int a = stdIn.nextInt() -1;
//			int b = stdIn.nextInt();
//			order[i][0] = a;
//			order[i][1] = b;
//		}
//		solve(o, cnt);
//	}
//	static void solve(int o, int cnt) {
//		for(int i=0;i<o;i++) {
//			visited = new int[cnt];
//			int id = order[i][0];
//			int dir = order[i][1];
//			control(id, dir, cnt);
//		}
//		score(cnt);
//	}
//	static void score(int cnt) {
//		int sum = 0;
//		for(int i=0;i<cnt;i++) {
//			if(ts[i].numbers[0] == 1) sum ++;
//		}
//		System.out.println(sum);
//	}
//	static void control(int id, int dir, int cnt) {
//		
//		visited[id] = 1;
//		
//		if(id-1 >=0 && visited[id-1] == 0) {
//			if(ts[id].numbers[6] != ts[id-1].numbers[2])
//				control(id-1,dir*-1, cnt);
//		}
//		if(id+1<cnt &&  visited[id+1] == 0) {
//			if(ts[id].numbers[2] != ts[id+1].numbers[6])
//				control(id+1,dir*-1, cnt);
//		}
//		
//		// dir
//		// -1 반시계 
//		// 1 시계 
//		if(dir == 1) {
//			int temp = ts[id].numbers[7];
//			for(int i=7;i>=1;i--) {
//				ts[id].numbers[i] = ts[id].numbers[i-1];
//			}
//			ts[id].numbers[0] = temp;
//		}else {
//			int temp = ts[id].numbers[0];
//			for(int i=0;i<7;i++) {
//				ts[id].numbers[i] = ts[id].numbers[i+1];
//			}
//			ts[id].numbers[7] = temp;			
//		}
//		
//	}
//}
//class T{
//	int id;
//	int[] numbers;
//	T(int id, int[] numbers){
//		this.id = id;
//		this.numbers = numbers;
//	}
//}

import java.util.Scanner;
public class BJ15662{
	static Wheel[] wheels;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		wheels = new Wheel[n];
		visited = new boolean[n];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			int[] num = new int[8];
			for(int j=0;j<8;j++) {
				num[j] = s.charAt(j)-'0';
			}
			wheels[i]  = new Wheel(num);
		}
		int k = stdIn.nextInt();
		
		for(int i=0;i<k;i++) {
			visited = new boolean[n];
			int num = stdIn.nextInt();
			int dir = stdIn.nextInt(); // 1 시계, -1 반시계 
			
//			num -= 1;
//			int[] dirs = new int[4];
//			dirs[num] = dir;
//			for(int l = num - 1;l>=0;l--) {
//				if(wheels[l].num[2] != wheels[l+1].num[6]) {
//					dirs[l] = dirs[l+1] * -1;
//				}else {
//					break;
//				}
//			}
//			for(int r = num + 1;r<4;r++){
//				if(wheels[r].num[6] != wheels[r-1].num[2]) {
//					dirs[r] = dirs[r-1] * -1;
//				}else {
//					break;
//				}
//			}
//			for(int m=0;m<4;m++) {
//				simulate2(m , dirs[m]);
//			}
			
			
			simulate(num-1, dir, n);
		}
		System.out.println(getScore(n));
	}
	static int getScore(int n) {
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += wheels[i].num[0];
		}
		return sum;
	}
	static void simulate2(int num, int dir) {
		if(dir == 0) return;
		if(dir == 1) { // 시계 
			int temp = wheels[num].num[7];
			for(int i=6;i>=0;i--) {
				wheels[num].num[i+1] = wheels[num].num[i];
			}
			wheels[num].num[0] = temp;
			
		}else { // 반시계 
			int temp = wheels[num].num[0];
			for(int i=0;i<7;i++) {
				wheels[num].num[i] = wheels[num].num[i+1];
			}
			wheels[num].num[7] = temp;
		}
		
	}
	static void simulate(int num, int dir, int n) {
		visited[num] = true;
		
		if(num-1>=0 && visited[num-1] == false && wheels[num-1].num[2] != wheels[num].num[6]) {
			simulate(num-1, dir * -1, n);
		}
		if(num+1<n  && visited[num+1] == false && wheels[num+1].num[6] != wheels[num].num[2]) {
			simulate(num+1, dir * -1, n);
		}

		if(dir == 1) { // 시계 
			int temp = wheels[num].num[7];
			for(int i=6;i>=0;i--) {
				wheels[num].num[i+1] = wheels[num].num[i];
			}
			wheels[num].num[0] = temp;
			
		}else { // 반시계 
			int temp = wheels[num].num[0];
			for(int i=0;i<7;i++) {
				wheels[num].num[i] = wheels[num].num[i+1];
			}
			wheels[num].num[7] = temp;
		}
		
	}
}
//class Wheel{
//	int[] num;
//	Wheel(int[] num){
//		// 인덱스 0 번이 12시 
//		this.num = num;
//	}
//}