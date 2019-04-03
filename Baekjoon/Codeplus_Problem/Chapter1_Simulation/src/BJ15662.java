// 15662번
// 톱니바퀴2
// 시뮬레이션
// 톱니바퀴랑 똑같은 문제 

import java.util.Scanner;
public class BJ15662 {
	static T[] ts;
	static int[][] order;
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int cnt = stdIn.nextInt();
		ts = new T[cnt];
		visited = new int[cnt];
		stdIn.nextLine();
		for(int i=0;i<cnt;i++) {
			int[] ar = new int[8];
			String s = stdIn.nextLine();
			for(int j=0;j<8;j++) {
				ar[j] = s.charAt(j)-'0';
			}
			ts[i] = new T(i, ar);
		}
		int o = stdIn.nextInt();
		order = new int[o][2];
		for(int i=0;i<o;i++) {
			int a = stdIn.nextInt() -1;
			int b = stdIn.nextInt();
			order[i][0] = a;
			order[i][1] = b;
		}
		solve(o, cnt);
	}
	static void solve(int o, int cnt) {
		for(int i=0;i<o;i++) {
			visited = new int[cnt];
			int id = order[i][0];
			int dir = order[i][1];
			control(id, dir, cnt);
		}
		score(cnt);
	}
	static void score(int cnt) {
		int sum = 0;
		for(int i=0;i<cnt;i++) {
			if(ts[i].numbers[0] == 1) sum ++;
		}
		System.out.println(sum);
	}
	static void control(int id, int dir, int cnt) {
		
		visited[id] = 1;
		
		if(id-1 >=0 && visited[id-1] == 0) {
			if(ts[id].numbers[6] != ts[id-1].numbers[2])
				control(id-1,dir*-1, cnt);
		}
		if(id+1<cnt &&  visited[id+1] == 0) {
			if(ts[id].numbers[2] != ts[id+1].numbers[6])
				control(id+1,dir*-1, cnt);
		}
		
		// dir
		// -1 반시계 
		// 1 시계 
		if(dir == 1) {
			int temp = ts[id].numbers[7];
			for(int i=7;i>=1;i--) {
				ts[id].numbers[i] = ts[id].numbers[i-1];
			}
			ts[id].numbers[0] = temp;
		}else {
			int temp = ts[id].numbers[0];
			for(int i=0;i<7;i++) {
				ts[id].numbers[i] = ts[id].numbers[i+1];
			}
			ts[id].numbers[7] = temp;			
		}
		
	}
}
//class T{
//	int id;
//	int[] numbers;
//	T(int id, int[] numbers){
//		this.id = id;
//		this.numbers = numbers;
//	}
//}