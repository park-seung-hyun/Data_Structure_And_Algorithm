// 1966번 (복습)
// 프린터 큐 
// 자료구조에서 배운 큐의 성질 이용 (링버퍼, front, rear)
// 링버퍼 처럼 rear가 n-1을 넘으면 0으로 바꿔줘야하는데
// 반복문 검사에서 문제.. 결국 배열을 크게 선언 
// 또 다른 방법으로 실제 큐(Queue) 사용 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Doc{
	int id;
	int priority;
	Doc(int i, int p){
		this.id = i;
		this.priority = p;
	}
}
public class Re_BJ1966 {
	static int[] ar;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			int m = stdIn.nextInt();
			ar = new int[n];
			for(int j=0;j<n;j++) {
				ar[j] = stdIn.nextInt();
			}
			solve2(n, m);
		}
	}
	// 실제 Queue 구현 
	// Doc 객체 사용 
	static void solve2(int n, int m) {
		Queue<Doc> q = new LinkedList<Doc>();
		for(int i=0;i<n;i++) {
			q.offer(new Doc(i,ar[i]));
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			if(isMax(q)) {
				Doc rm = q.remove();
				cnt++;
				if(rm.id == m) {
					System.out.println(cnt);
				}
			}
				
		}
	}
	static boolean isMax(Queue<Doc> q) {
		int max = q.peek().priority;
		for(int i=0;i<q.size();i++) {
			// 가장 중요한 것은 Queue의 모든 요소를 확인할 때 LinkedList로 형 변환
			// 충격 
			if(max<((LinkedList<Doc>)q).get(i).priority) {
				Doc rm = q.remove();
				q.offer(rm);
				return false;
			}
		}
		return true;
	}
	static void solve(int n, int m){
		int f = 0;
		int r = n-1;
		int max = 0;
		int cnt = 0;
		
		int[] q = new int[1000];
		for(int i=0;i<n;i++) {
			q[i] = i;
		}
		
		while(cnt<n) {
			max = ar[q[f]];
			boolean flag = true;
			for(int i=f+1;i<=r;i++) {
				if(max < ar[q[i]]) {
					r++;
					q[r] = q[f];
					f++;
					flag = false;
					break;
				}
			}
			if(flag == true) {
				cnt++;
				if(q[f] == m) {
					System.out.println(cnt);
					return;
				}
				f++;
			}	
		}
	}
}
