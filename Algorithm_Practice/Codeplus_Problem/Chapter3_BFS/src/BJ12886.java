// 12886번
// 돌 그룹  
// BFS
// 돌에서 돌로 옮기는거 공통 변수 사용하여 반복문 돌리기. 노가다 ㄴㄴ 
// 근데 그랬더니 .. 시간이랑 메모리 늘어났네..? 

//import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//public class BJ12886 {
//	static boolean[][] visited;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int a = stdIn.nextInt();
//		int b = stdIn.nextInt();
//		int c = stdIn.nextInt();
//		int sum = a+b+c;
//		visited = new boolean[sum+1][sum+1];
//		solve(a,b,c);
//		if(sum%3 == 0) {
//			int id = sum/3;
//			System.out.println(visited[id][id] == true ? 1: 0);
//		}else {
//			System.out.println(0);
//		}
//
//	
//	}
//	static void solve(int a,int b,int c) {
//		int sum = a+b+c;
//		Queue<Stone> q = new LinkedList<Stone>();
//		q.add(new Stone(a,b));
//		visited[a][b] = true;
//		while(!q.isEmpty()) {
//			Stone h = q.remove();
//			int s1 = h.a;
//			int s2 = h.b;
//			int s3 = sum - s1 -s2;
//			
//			if(s1>s2) {
//				if(visited[s1-s2][s2+s2] == false) {
//					q.add(new Stone(s1-s2, s2+s2));
//					visited[s1-s2][s2+s2] = true;
//				}
//			}else if(s2>s1){
//				if(visited[s1+s1][s2-s1] == false) {
//					q.add(new Stone(s1+s1, s2-s1));
//					visited[s1+s1][s2-s1] = true;
//				}
//			}
//			
//			if(s2>s3) {
//				int temp2 = s2-s3;
//				int temp3 = s3+s3;
// 				int temp1 = sum - temp2 -temp3;
//				if(visited[temp1][temp2] == false) {
//					q.add(new Stone(temp1, temp2));
//					visited[temp1][temp2] = true;
//				}
//				
//			}else if(s3>s2) {
//				int temp2 = s2+s2;
//				int temp3 = s3-s2;
// 				int temp1 = sum - temp2 -temp3;
//				if(visited[temp1][temp2] == false) {
//					q.add(new Stone(temp1, temp2));
//					visited[temp1][temp2] = true;
//				}
//			}
//			
//			if(s1>s3) {
//				int temp1 = s1-s3;
//				int temp3 = s3+s3;
// 				int temp2 = sum - temp1 -temp3;
//				if(visited[temp1][temp2] == false) {
//					q.add(new Stone(temp1, temp2));
//					visited[temp1][temp2] = true;
//				}
//			}else if(s3>s1){
//				int temp1 = s1+s1;
//				int temp3 = s3-s1;
// 				int temp2 = sum - temp1 -temp3;
//				if(visited[temp1][temp2] == false) {
//					q.add(new Stone(temp1, temp2));
//					visited[temp1][temp2] = true;
//				}
//			}
//			
//		}
//		
//		
//	}
//	static void change(int a, int b, int c) {
//		
//	}
//}
//class Stone{
//	int a;
//	int b;
//	Stone(int a, int b){
//		this.a = a;
//		this.b = b;
//	}
//}
//public class BJ12886{
//	static int[][] visited;
//	static int[] dx = {0,0,1,1,2,2};
//	static int[] dy = {1,2,0,2,0,1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int a = stdIn.nextInt();
//		int b = stdIn.nextInt();
//		int c = stdIn.nextInt();
//		int sum = a+b+c;
//		if(sum%3 != 0) {
//			System.out.println(0);
//			return;
//		}
//			
//		visited = new int[sum+1][sum+1];
//		Queue<Stone> q = new LinkedList<Stone>();
//		q.add(new Stone(a,b));
//		visited[a][b] = 1;
//		while(!q.isEmpty()) {
//			Stone h = q.remove();
//			if(h.a == sum/3 && h.b == sum/3) {
//				System.out.println(1);
//				return;
//			}
//			for(int i=0;i<6;i++) {
//				int[] next = {h.a,h.b,sum-h.a-h.b};
//				if(next[dx[i]] == next[dy[i]]) continue;
//				if(next[dx[i]] > next[dy[i]]) {
//					int temp = next[dy[i]];
//					next[dy[i]] += temp;
//					next[dx[i]] -= temp;
//				}else {
//					int temp = next[dx[i]];
//					next[dx[i]] += temp;
//					next[dy[i]] -= temp;
//				}
//				if(visited[next[0]][next[1]] == 0) {
//					visited[next[0]][next[1]] = 1;
//					q.add(new Stone(next[0], next[1]));
//				}
//			}
//		}
//		System.out.println(0);
//	}
//}

public class BJ12886{
	static int[][] visited = new int[1500][1500];
	static int[] dx = {0,0,1,1,2,2};
	static int[] dy = {1,2,0,2,0,1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		int c = stdIn.nextInt();
		int sum = a+b+c;
		if(sum%3 != 0) {
			System.out.println(0);
			return;
		}
		dfs(a,b,sum);
		if(visited[sum/3][sum/3] == 1) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	static void dfs(int a, int b, int sum) {
		
		visited[a][b] = 1;
//		System.out.println(a + " " + b + " " + (sum-a-b));
		for(int i=0;i<6;i++) {
			int[] next = {a,b,sum-a-b};
			if(next[dx[i]] == next[dy[i]]) continue;
			
			if(next[dx[i]] > next[dy[i]]) {
				next[dx[i]] -= next[dy[i]];		
				next[dy[i]] = 2*next[dy[i]];	
			}else {
				next[dy[i]] -= next[dx[i]];	
				next[dx[i]] = 2*next[dx[i]];
			}
			if(visited[next[0]][next[1]] == 0) {
				dfs(next[0],next[1],sum);
			}
		}
		
	}
}