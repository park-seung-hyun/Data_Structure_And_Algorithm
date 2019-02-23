// 1697번 
// 숨바꼭질 
// BFS
// BFS, DFS 언제 사용하는지 공부하기 
// 최소 비용 문제이므로 BFS 
// 조건으로 모든 가중치가 1로 같아야함. 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1697 {
	static int k;
	// check
	// 해당 위치를 몇 번의 방문으로 갈 수 있나 (최솟값) 저장 
	static int check[] = new int[100001];
	
	static int MIN = 2000000000;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		k = stdIn.nextInt();
		
		for(int i=0;i<=100000;i++) {
			check[i] = 2000000000;
		}
		
//		hideAndSeek(n, 0);
//		System.out.println(MIN);
		System.out.println(hideAndSeek2(n));
	}
	// hideAndSeek 
	// DFS 사용 
	// 시간 초과.. 
	// 스택으로 구현해보기 
	static void hideAndSeek(int n, int c) {
		
		if(check[n]<c) {
			return;
		}else {
			check[n] = c;
		}
		
		int moveLeft = n-1;
		int moveRight = n+1;
		int teleport = 2*n;
		
		if(n == k) {
			if (MIN>c)
				MIN = c;
			return;
			
		}else{
			c++;
			if(teleport<=100000)
				hideAndSeek(teleport, c);
			if(moveRight<=100000)
				hideAndSeek(moveRight, c);
			if(moveLeft>=0)
				hideAndSeek(moveLeft, c);
		}
							
	}
	// hideAndSeek2 
	// BFS 사용 
	static int hideAndSeek2(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		check[n] = 0;

		while(!q.isEmpty()) {
			int qp = q.peek();
			
			if(qp==k)	
				return check[qp];
			
			q.remove();
			
			int left = qp-1;
			int right = qp+1;
			int teleport = 2*qp;
			
			// 0 ~ 100000 범위 고려 
			// check 값을 보며 pruning 여부 확인 
			if(left>=0 && check[left] > check[qp] + 1 ) {
				check[left] = check[qp] + 1;
				q.add(left);
			}
			if(right <= 100000 && check[right] > check[qp] + 1) {
				check[right] = check[qp] + 1;
				q.add(right);
			}
			if(teleport <= 100000 && check[teleport] > check[qp] + 1) {
				check[teleport] = check[qp] + 1;
				q.add(teleport);
			}

		}
		return -1;
	}
}
