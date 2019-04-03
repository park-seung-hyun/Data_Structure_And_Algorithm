import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14395 {
	static final int MAX = 1000000000;
	static final int MIN = 0;
	static HashMap<Long, String> visited = new HashMap<Long, String>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int s = stdIn.nextInt();
		int t = stdIn.nextInt();
		if(s==t) {
			System.out.println(0);
			return;
		}
		solve(s,t);
	}
	static void solve(int s, int t) {
		Queue<Long> q= new LinkedList<Long>();
		q.add((long)s);
		visited.put((long)s, "");
		while(!q.isEmpty()) {
			long h = q.remove();
//			System.out.println(h);
			if(h == t) {
				System.out.println(visited.get(h));
				return;
			}
			if(h*h <= MAX && !visited.containsKey(h*h)) {
				q.add(h*h);
				visited.put(h*h,visited.get(h)+"*");
			}
			if(h+h <= MAX && !visited.containsKey(h+h)) {
				q.add(h+h);
				visited.put(h+h,visited.get(h)+"+");
			}
			if(h-h >= MIN && !visited.containsKey(h-h)) {
				q.add(h-h);
				visited.put(h-h,visited.get(h)+"-");
			}
			if(h != 0 && !visited.containsKey(h/h)) {
				q.add(h/h);
				visited.put(h/h,visited.get(h)+"/");
			}

		}
		System.out.println(-1);
	}
}
