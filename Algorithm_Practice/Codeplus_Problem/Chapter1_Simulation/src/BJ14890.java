// 14890번
// 경사로 
// 시뮬레이션

//import java.util.Scanner;
//public class BJ14890 {
//	static int[][] map;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new int[n][n];
//		int l = stdIn.nextInt();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				map[i][j] = stdIn.nextInt();
//			}
//		}
//		solve(n,l);
//	}
//	static void solve(int n, int l) {
//		int sum = 0;
//		for(int i=0;i<n;i++) {
//			if(check(map[i],n,l,i)) sum++;
//		}
//		for(int i=0;i<n;i++) {
//			int[] ar = new int[n];
//			for(int j=0;j<n;j++) {
//				ar[j] = map[j][i];
//			}
//			if(check(ar,n,l,i)) sum++;
//		}
//		System.out.println(sum);
//		
//	}
//	static boolean check(int[] ar, int n, int l, int which) {
//		int[] visited = new int[n]; // 경사로를 놓았는지 아닌지에 대한 배열 필요 
//		for(int i=0;i<n-1;i++) {
//			if(ar[i] == ar[i+1]) continue;
//			int temp = ar[i]-ar[i+1];
//			if(Math.abs(temp) != 1) return false;
//			
//			if(temp == 1) {
//				for(int j=0;j<l;j++) {
//					if(i+1+j >= n || (ar[i]-ar[i+1+j]) != temp) return false;
//					if(visited[i+1+j] == 1) return false;
//					visited[i+1+j] = 1;
//				}
//				i = i+l-1;
//			}else if(temp == -1) {
//				for(int j=0;j<l;j++) {
//					if(i-j < 0 || (ar[i-j]-ar[i+1]) != temp) return false;
//					if(visited[i-j] == 1) return false;
//					visited[i-j] =1;
//				}
//			}else {
//				return false;
//			}
//		}
//		return true;
//	}
//}

import java.util.Arrays;
import java.util.Scanner;
public class BJ14890{
	static int[][] map;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new int[n][n];
		int l = stdIn.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		int cnt = 0;
		for(int i=0;i<n;i++) {
			if(isRoad(map[i], l)) {
				cnt++;
			}
		}
		
		for(int i=0;i<n;i++) {
			int[] newline = new int[n];
			for(int j=0;j<n;j++) {
				newline[j] = map[j][i];
			}
			if(isRoad(newline, l)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	static boolean isRoad(int[] line, int l) {
		int[] visited = new int[line.length];
		int cnt = 1;
		for(int i=0;i<line.length-1;i++) {
			if(Math.abs(line[i] - line[i+1]) > 1) return false;
			
			if(line[i] == line[i+1]) {
				cnt ++;
			}
			if(line[i] + 1 == line[i+1]) {
				if(cnt >= l) {
					for(int j = 0;j<l;j++) {
						visited[i-j] = 1;
					}
					cnt = 1;
				}else {
					return false;
				}
			}
		}
		cnt = 1;
		for(int i=line.length-1;i>0;i--) {
			if(Math.abs(line[i] - line[i-1]) > 1) return false;
			
			if(line[i] == line[i-1]) {
				cnt ++;
			}
			if(line[i] + 1 == line[i-1]) {
				if(cnt >= l) {
					for(int j = 0;j<l;j++) {
						if(visited[i+j] != 0) 
							return false;
						visited[i+j] = 1;
					}
					cnt = 1;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}