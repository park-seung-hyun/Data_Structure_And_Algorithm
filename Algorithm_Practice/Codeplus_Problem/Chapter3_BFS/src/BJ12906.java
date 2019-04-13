// 12906번
// 새로운 하노이 탑  
// BFS 

//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ12906 {
//	static HashMap<String,Integer> visited = new HashMap<String,Integer>();
//	public static void main(String[] args) {
//		Scanner stdIn =new Scanner(System.in);
//		String[] s = new String[3];
//		for(int i=0;i<3;i++) {
//			int n = stdIn.nextInt();
//			if(n == 0) { 
//				s[i] = "";
//				continue;
//			}
//			s[i] = stdIn.next();
//		}
//		TowerState t = new TowerState(s[0],s[1],s[2],0);
//		solve(t);
//	}
//	static void solve(TowerState t) {
//		Queue<TowerState> q = new LinkedList<TowerState>();
//		q.add(t);
//		visitWhere(t,q);
//		int[] dx = {0,0,1,1,2,2};
//		int[] dy = {1,2,2,0,0,1};
//		while(!q.isEmpty()) {
//			TowerState h = q.remove();
//			int time = h.t;
//			if(check(h)) {
//				System.out.println(time);
//				break;
//			}
//			for(int i=0;i<6;i++) {
//				String[] s = {h.A,h.B,h.C};
//				if(s[dx[i]] == "") continue;
//				
//				char c = s[dx[i]].charAt(s[dx[i]].length()-1);
//				s[dy[i]] += c;
//				
//				if(s[dx[i]].length() > 1) { // 1이상일 경우 ...
//					s[dx[i]] = s[dx[i]].substring(0, s[dx[i]].length()-1);
//				}else { // 1 일 경우 
//					s[dx[i]] = "";
//				}
//				visitWhere(new TowerState(s[0],s[1],s[2],time+1),q);
//			}
//			
//		
//		}
//		
//	}
//	static boolean check(TowerState t) {
//		String[] s = {t.A,t.B,t.C};
//		char[] c = {'A', 'B' , 'C'}; 
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<s[i].length();j++) {
//				if(s[i].charAt(j) != c[i]) return false;
//			}
//		}
//		return true;
//	}
//	static void visitWhere(TowerState t, Queue<TowerState> q) {
//		String[] s = {t.A,t.B,t.C};
//		int time = t.t;
//		String v = t.A +" " +t.B +" "+ t.C;
//		if(!visited.containsKey(v)) {
//			visited.put(v, 1);
//			q.add(new TowerState(s[0], s[1], s[2], time));
//		}
//	}
//}
//class TowerState{
//	String A;
//	String B;
//	String C;
//	int t;
//	TowerState(String A, String B, String C, int t){
//		this.A = A;
//		this.B = B;
//		this.C = C;
//		this.t= t;
//	}
//}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ12906{
	static int[] dx = {0,0,1,1,2,2};
	static int[] dy = {1,2,0,2,0,1};
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		String[] tower = new String[3];
		for(int i=0;i<3;i++) {
			int n = stdIn.nextInt();
			if(n==0) {
				tower[i] = "";
			}else {
				tower[i] = stdIn.next();
			}
		}
		Queue<String[]> q= new LinkedList<String[]>();
		q.add(tower);
		hm.put(sumString(tower), 0);
		while(!q.isEmpty()) {
			String[] h = q.remove();
			if(isAnswer(h)) {
				System.out.println(hm.get(sumString(h)));
				return;
			}
			for(int i=0;i<6;i++) {
				String[] next = {h[0], h[1], h[2]};
				if(next[dx[i]].length() == 0) continue;
				char c = next[dx[i]].charAt(next[dx[i]].length()-1);
				next[dy[i]] += c;
				next[dx[i]] = next[dx[i]].substring(0, next[dx[i]].length()-1);
				
				String temp = sumString(next);
				if(!hm.containsKey(temp)) {
					hm.put(temp, hm.get(sumString(h)) + 1);
					q.add(next);
				}
			}
		}
	}
	static boolean isAnswer(String[] ss) {
		for(int i=0;i<3;i++) {
			String s = ss[i];
			for(char c: s.toCharArray()) {
				if(c-'A' != i) return false;
			}
		}
		return true;
	}
	static String sumString(String[] ss) {
		return ss[0] + " " + ss[1] + " " + ss[2];
	}

}