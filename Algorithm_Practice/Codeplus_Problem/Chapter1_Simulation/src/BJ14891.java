// 14891번
// 톱니바퀴 
// 시뮬레이션
// 본인 풀이 -> 모든 톱니에 대해 재귀적으로 구함. 
// 백준 풀이 -> 배열을 생성하여 각 톱니바퀴마다 회전 여부를 저장. 

//import java.util.Scanner;
//public class BJ14891 {
//	static T[] ts = new T[4];
//	static int[][] order;
//	static int[] visited = new int[4];
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		for(int i=0;i<4;i++) {
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
//		solve(o);
//	}
//	static void solve(int o) {
//		for(int i=0;i<o;i++) {
//			visited = new int[4];
//			int id = order[i][0];
//			int dir = order[i][1];
//			control2(id, dir);
//		}
//		score();
//	}
//	static void score() {
//		int sum = 0;
//		for(int i=0;i<4;i++) {
//			sum += ts[i].numbers[0] * Math.pow(2, i);
//		}
//		System.out.println(sum);
//	}
//	static void control2(int id, int dir) {
//		
//		int[] dirAr = new int[4];
//		dirAr[id] = dir;
//		// 미리 회전 여부를 저장하는 방법 
//		for(int i = id-1;i>=0;i--) {
//			if(ts[i].numbers[2] != ts[i+1].numbers[6]) {
//				dirAr[i] = dirAr[i+1] * -1;
//			}else {
//				break;
//			}
//		}
//		for(int i = id+1;i<4;i++) {
//			if(ts[i-1].numbers[2] != ts[i].numbers[6]) {
//				dirAr[i] = dirAr[i-1] * -1;
//			}else {
//				break;
//			}
//		}
//		for(int j=0;j<4;j++) {
//			
//			if(dirAr[j] == 1) {
//				int temp = ts[j].numbers[7];
//				for(int i=7;i>=1;i--) {
//					ts[j].numbers[i] = ts[j].numbers[i-1];
//				}
//				ts[j].numbers[0] = temp;
//			}else if(dirAr[j] == -1) {
//				int temp = ts[j].numbers[0];
//				for(int i=0;i<7;i++) {
//					ts[j].numbers[i] = ts[j].numbers[i+1];
//				}
//				ts[j].numbers[7] = temp;			
//			}
//
//		}
//		
//	}
//	static void control(int id, int dir) {
//			
//		// 현재 톱니바퀴로 부터 좌우로 퍼져나가는 식 
//		
//		// 밑에 돌리는 과정부터 하면 배열 값이 바뀌므로
//		// 회전 전에 값으로 회전 여부를 판단하기 위해 미리 재귀함수로 보냄. 
//		visited[id] = 1;
//		if(id-1 >=0 && visited[id-1] == 0) {
//			if(ts[id].numbers[6] != ts[id-1].numbers[2])
//				control(id-1,dir*-1);
//		}
//		if(id+1<4 &&  visited[id+1] == 0) {
//			if(ts[id].numbers[2] != ts[id+1].numbers[6])
//				control(id+1,dir*-1);
//		}
//		
//		// dir
//		// -1 반시계 
//		// 1 시계 
//		
//		// 회전 
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
public class BJ14891{
	static Wheel[] wheels = new Wheel[4];
	static boolean[] visited = new boolean[4];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		for(int i=0;i<4;i++) {
			String s = stdIn.nextLine();
			int[] num = new int[8];
			for(int j=0;j<8;j++) {
				num[j] = s.charAt(j)-'0';
			}
			wheels[i]  = new Wheel(num);
		}
		int k = stdIn.nextInt();
		
		for(int i=0;i<k;i++) {
			visited = new boolean[4];
			int num = stdIn.nextInt();
			int dir = stdIn.nextInt(); // 1 시계, -1 반시계 
			
			num -= 1;
			int[] dirs = new int[4];
			dirs[num] = dir;
			for(int l = num - 1;l>=0;l--) {
				if(wheels[l].num[2] != wheels[l+1].num[6]) {
					dirs[l] = dirs[l+1] * -1;
				}else {
					break;
				}
			}
			for(int r = num + 1;r<4;r++){
				if(wheels[r].num[6] != wheels[r-1].num[2]) {
					dirs[r] = dirs[r-1] * -1;
				}else {
					break;
				}
			}
			for(int m=0;m<4;m++) {
				simulate2(m , dirs[m]);
			}
			
			
//			simulate(num-1, dir);
		}
		System.out.println(getScore());
	}
	static int getScore() {
		int sum = 0;
		for(int i=0;i<4;i++) {
			sum += wheels[i].num[0] * Math.pow(2, i);
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
	static void simulate(int num, int dir) {
		visited[num] = true;
		
		if(num-1>=0 && visited[num-1] == false && wheels[num-1].num[2] != wheels[num].num[6]) {
			simulate(num-1, dir * -1);
		}
		if(num+1<4  && visited[num+1] == false && wheels[num+1].num[6] != wheels[num].num[2]) {
			simulate(num+1, dir * -1);
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
class Wheel{
	int[] num;
	Wheel(int[] num){
		// 인덱스 0 번이 12시 
		this.num = num;
	}
}