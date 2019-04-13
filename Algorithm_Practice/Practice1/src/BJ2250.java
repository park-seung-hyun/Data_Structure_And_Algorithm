// 2250번  
// 트리의 높이와 넓이 
// 이진 트리 (Binary Tree)
// 중위 순회 (In-order Traversal)

// 이진 트리 (Binary Tree) 설명 잘되어 있는 블로그 
// https://songeunjung92.tistory.com/27?category=155475
// https://wooooooak.github.io/algorithm/2018/12/05/%EB%B0%B1%EC%A4%802250%EB%AC%B8%EC%A0%9C/

import java.util.Arrays;
import java.util.Scanner;
public class BJ2250 {
	static int x = 1;
	static int y = 1;
	static int[] levelMin;
	static int[] levelMax;
	
	// Node Class
	static class Node {
		Node left; // 해당 노드의 왼쪽 자식 노드 
		Node right; // 해당 노드의 오른쪽 자식 노드 
		private int data; // 해당 노드의 값 
		
		// 생성자 
		public Node(int data, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
		public int getData() {
			return this.data;
		}
	}
	// BinaryTree Class 
	static class BinaryTree {
		Node root;
		// 생성자 
		public BinaryTree() {
			this.root = null;
		}
		// makeBT 
		// 노드를 생성하여 자식 관계를 성립한다. 
		public Node makeBT(Node l, int data, Node r) {
			Node root = new Node(data, l, r);
			return root;
		}
		// inOrder 
		// 중위 순회 
		// L -> D -> R 순으로 순회한다. 
		public void inOrder(Node root) {
			// 해당 노드가 null이 아닐때 (Leaf Node가 아닐때)
			if(root!=null) {
				
				y++; // level ++
				inOrder(root.left); // L 순회 
				y--; // level -- 
				
				// 각 인덱스 (level)마다 최솟값, 최대값을 구함. 
				if(levelMin[y] > x)
					levelMin[y] = x;
				if(levelMax[y] < x)
					levelMax[y] = x;
				
				// x축 증가 
				x++;
				
				y++; // level ++
				inOrder(root.right); // R 순회 
				y--; // level -- 
			}
		}
		
	}
	public static void main (String[]args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt(); // 노드 수 
		int[][] ar = new int[n][3]; // 입력값 임시 저장 
		
		BinaryTree bt = new BinaryTree(); // Binary Tree 객체 생성 
		Node[] na = new Node[n+1]; // 노드 임시 저장 
		levelMin = new int[n+1]; // 각 인덱스(level)별 최솟값 
		levelMax = new int[n+1]; // 각 인덱스(level)별 최댓값 
		Arrays.fill(levelMin, 10001);
		
		for(int i=0;i<n;i++) {
			ar[i][0] = stdIn.nextInt();
			ar[i][1] = stdIn.nextInt();
			ar[i][2] = stdIn.nextInt();

		}
		// Root 노드 탐색용 배열 
		int[] checkRoot = new int[n];
		
		// Binary Tree 객체에 노드 생성 
		for(int i=n-1;i>=0;i--) {
			int nd = ar[i][0];
			int nl = ar[i][1];
			int nr = ar[i][2];
			// 왼쪽, 오른쪽 자식 노드에 한번이라도 호출되면 Root 노드 X 
			if(nl != -1)
				checkRoot[nl-1] = 1;
			if(nr != -1)
				checkRoot[nr-1] = 1;
			// 노드 생성 
			na[nd] = bt.makeBT(nl!=-1 ? na[nl] : null, nd, nr!=-1 ? na[nr] : null);
		}
		// Root 노드 탐색 후 중위 순회 
		for(int i=0;i<checkRoot.length;i++) {
			if(checkRoot[i] == 0)
				bt.inOrder(na[i+1]);
		}

		// 최대 넓이 값과 해당 level 구함. 
		int max = 1;
		int maxId = 1;
		for(int i=0;i<n;i++) {
			if(max < levelMax[i]-levelMin[i] + 1) {
				max = levelMax[i]-levelMin[i] + 1;
				maxId = i;
				
			}
		}
		System.out.printf("%d %d", maxId, max);
	}
}
