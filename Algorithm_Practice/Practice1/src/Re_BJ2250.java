// 2250번 (복습)
// 트리의 높이와 넓이 
// 이진 트리 (Binary Tree)
// 중위 순회 (In-order Traversal)

import java.util.ArrayList;
import java.util.Scanner;
public class Re_BJ2250 {
	static Node[] nodeAr;
	static ArrayList<Integer>[] depth;
	static int checkParent[];
	static int cnt = 1;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n =stdIn.nextInt();
		nodeAr = new Node[n+1];
		depth = (ArrayList<Integer>[])new ArrayList[n+1];
		checkParent = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			depth[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<n;i++) {
			int a = stdIn.nextInt();
	
			int b = stdIn.nextInt();
			if(b != -1) {
				checkParent[b]++;
			}
			int c = stdIn.nextInt();
			if(c != -1) {
				checkParent[c]++;
			}
			
			nodeAr[a] = new Node(a,b,c);
		}	
		for(int i=1;i<=n;i++) {
			if(checkParent[i] == 0) {
				solve(i,1);	
				break;
			}
		}
		int max = -1;
		int maxDepth = -1;
		for(int i=1;i<depth.length;i++) {
			if(depth[i].isEmpty())
				break;
			if(depth[i].get(depth[i].size()-1)-depth[i].get(0)+1 > max) {
				max = depth[i].get(depth[i].size()-1)-depth[i].get(0)+1;
				maxDepth = i;
			}
		}
		System.out.printf("%d %d",maxDepth, max);
	}
	static void solve(int n, int d) {

		if(n == -1) {
			return;
		}
		
		solve(nodeAr[n].left,d+1);
		depth[d].add(cnt);
		cnt++;
		solve(nodeAr[n].right,d+1);
		
	}
}
class Node{
	int n;
	int left;
	int right;
	Node(int n, int l, int r){
		this.n = n;
		this.left = l;
		this.right = r;
	}
}