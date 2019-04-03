import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12886 {
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		int c = stdIn.nextInt();
		int sum = a+b+c;
		visited = new boolean[sum+1][sum+1];
		solve(a,b,c);
		if(sum%3 == 0) {
			int id = sum/3;
			System.out.println(visited[id][id] == true ? 1: 0);
		}else {
			System.out.println(0);
		}

	
	}
	static void solve(int a,int b,int c) {
		int sum = a+b+c;
		Queue<Stone> q = new LinkedList<Stone>();
		q.add(new Stone(a,b));
		visited[a][b] = true;
		while(!q.isEmpty()) {
			Stone h = q.remove();
			int s1 = h.a;
			int s2 = h.b;
			int s3 = sum - s1 -s2;
			
			if(s1>s2) {
				if(visited[s1-s2][s2+s2] == false) {
					q.add(new Stone(s1-s2, s2+s2));
					visited[s1-s2][s2+s2] = true;
				}
			}else if(s2>s1){
				if(visited[s1+s1][s2-s1] == false) {
					q.add(new Stone(s1+s1, s2-s1));
					visited[s1+s1][s2-s1] = true;
				}
			}
			
			if(s2>s3) {
				int temp2 = s2-s3;
				int temp3 = s3+s3;
 				int temp1 = sum - temp2 -temp3;
				if(visited[temp1][temp2] == false) {
					q.add(new Stone(temp1, temp2));
					visited[temp1][temp2] = true;
				}
				
			}else if(s3>s2) {
				int temp2 = s2+s2;
				int temp3 = s3-s2;
 				int temp1 = sum - temp2 -temp3;
				if(visited[temp1][temp2] == false) {
					q.add(new Stone(temp1, temp2));
					visited[temp1][temp2] = true;
				}
			}
			
			if(s1>s3) {
				int temp1 = s1-s3;
				int temp3 = s3+s3;
 				int temp2 = sum - temp1 -temp3;
				if(visited[temp1][temp2] == false) {
					q.add(new Stone(temp1, temp2));
					visited[temp1][temp2] = true;
				}
			}else if(s3>s1){
				int temp1 = s1+s1;
				int temp3 = s3-s1;
 				int temp2 = sum - temp1 -temp3;
				if(visited[temp1][temp2] == false) {
					q.add(new Stone(temp1, temp2));
					visited[temp1][temp2] = true;
				}
			}
			
		}
		
		
	}
	static void change(int a, int b, int c) {
		
	}
}
class Stone{
	int a;
	int b;
	Stone(int a, int b){
		this.a = a;
		this.b = b;
	}
}
