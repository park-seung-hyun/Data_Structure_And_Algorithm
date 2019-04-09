// 14395번
// 4연산   
// BFS 

//import java.util.HashMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//public class BJ14395 {
//	static final int MAX = 1000000000;
//	static final int MIN = 0;
//	static HashMap<Long, String> visited = new HashMap<Long, String>();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int s = stdIn.nextInt();
//		int t = stdIn.nextInt();
//		if(s==t) {
//			System.out.println(0);
//			return;
//		}
//		solve(s,t);
//	}
//	static void solve(int s, int t) {
//		Queue<Long> q= new LinkedList<Long>();
//		q.add((long)s);
//		visited.put((long)s, "");
//		while(!q.isEmpty()) {
//			long h = q.remove();
//			if(h == t) {
//				System.out.println(visited.get(h));
//				return;
//			}
//			if(h*h <= MAX && !visited.containsKey(h*h)) {
//				q.add(h*h);
//				visited.put(h*h,visited.get(h)+"*");
//			}
//			if(h+h <= MAX && !visited.containsKey(h+h)) {
//				q.add(h+h);
//				visited.put(h+h,visited.get(h)+"+");
//			}
//			if(h-h >= MIN && !visited.containsKey(h-h)) {
//				q.add(h-h);
//				visited.put(h-h,visited.get(h)+"-");
//			}
//			if(h != 0 && !visited.containsKey(h/h)) {
//				q.add(h/h);
//				visited.put(h/h,visited.get(h)+"/");
//			}
//
//		}
//		System.out.println(-1);
//	}
//}


public class BJ14395{
	static HashMap<Long, String> hm = new HashMap<Long, String>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		long s = stdIn.nextInt();
		long t = stdIn.nextInt();
		if(s == t) {
			System.out.println(0);
			return;
		}
		Queue<Long> q= new LinkedList<Long>();
		q.add(s);
		hm.put(s,"");
		while(!q.isEmpty()) {
			long h = q.remove();
			String op = hm.get(h);
			if(h == t) {
				System.out.println(op);
				return;
			}
			if(!hm.containsKey(h*h)) {
				q.add(h*h);
				hm.put(h*h, op+"*");
			}
			if(!hm.containsKey(h+h)) {
				q.add(h+h);
				hm.put(h+h, op+"+");
			}
			if(!hm.containsKey(h-h)) {
				q.add(h-h);
				hm.put(h-h, op+"-");
			}
			if(h!=0 && !hm.containsKey(h/h)) {
				q.add(h/h);
				hm.put(h/h, op+"/");
			}
		}
		System.out.println(-1);
	}
}