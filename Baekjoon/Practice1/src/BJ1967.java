// 1967번  
// 트리의 지름 
// 트리 (Tree)
// dfs (Depth First Search)

// http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220961873786&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
// http://blog.sisobus.com/2013/10/backjoon-online-judge-no1967.html#.XE62n88zbyK

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1967 {
	static ArrayList<Node> tree[]; // 각 노드의 연결 관계 (양방향)
	static boolean[] visit; // 방문 여부 -> dfs 
	static int maxWeight; // 시작 노드로 부터 가장 멀리 있는 노드까지의 거리 
	static Node maxNode; // 시작 노드로 부터 가장 멀리 있는 노드 
	
	public static void main(String[] args) {
		// 입출려 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		tree = new ArrayList[n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++) {
			// ArrayList<Node>의 배열 생성 
			// tree의 각 요소가 ArrayList<Node> 
			tree[i] = new ArrayList<Node>();
		}
		for(int i=0;i<n-1;i++) {
			int p = stdIn.nextInt()-1;
			int c = stdIn.nextInt()-1;
			int w = stdIn.nextInt();
			
			// 노드의 연결 관계 생성 
			tree[p].add(new Node(c,w)); 
			tree[c].add(new Node(p,w));
		}
	
		// Root 노드로 부터 가장 멀리 있는 노드 탐색 
		for(Node root : tree[0]) { // Root 노드의 자식 노드 탐색 
			visit[0] = true;
			dfs(root, root.weight);
			visit[0] = false;
		}
		
		// 다시 dfs를 하기 위해 초기화 
		maxWeight = 0;
		// 위에서 나온 노드에서 가장 멀리 있는 노드 탐색 
		dfs(maxNode, 0);
		
		System.out.println(maxWeight);
		
	}
	// dfs
	// dfs (Depth First Search)
	// 가장 멀리 있는 노드 탐색 
	static void dfs(Node currentNode, int w) {
		visit[currentNode.id] = true;
		for(Node n : tree[currentNode.id]) {
			if(!visit[n.id]) {
				visit[n.id] = true;
				dfs(n, w + n.weight);
				visit[n.id] = false;
			}
		}
		if(w>maxWeight) {
			// 멀리있는 노드 갱신 
			maxWeight = w;
			maxNode = currentNode;
		}
		visit[currentNode.id] = false;
	}
	// Node Class
	static class Node {
		int id;
		int weight = 0;

		public Node (int nodeId, int nodeWeight){
			this.id = nodeId;
			this.weight = nodeWeight;
		}
	}

}
