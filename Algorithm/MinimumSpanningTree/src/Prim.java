// Prim 알고리즘 
// Minimum Spanning Tree (MST) 
// 최소 신장 트리를 구하기 위해 사용되는 알고리즘 
// 정점 기반 알고리즘 
// 백준 1197번 
// http://blog.naver.com/PostView.nhn?blogId=ssarang8649&logNo=220992988177
	
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class Prim {
	static ArrayList<Node>[] al;
	static boolean[] visited;
	public static void main(String[] args) {	
		Scanner stdIn= new Scanner(System.in);
		int v = stdIn.nextInt();
		int e = stdIn.nextInt();
		visited = new boolean[v+1];
		al = (ArrayList<Node>[])new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			al[i]= new ArrayList<Node>();
		}
		// 노드 저장 
		for(int i=0;i<e;i++) {
			int start = stdIn.nextInt();
			int end = stdIn.nextInt();
			int weight = stdIn.nextInt();
			al[start].add(new Node(end, weight));
			al[end].add(new Node(start, weight));
		}
		prim(v,e);
	}
	static void prim(int v, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Queue<Integer> d = new LinkedList<Integer>();
		ArrayList<Node> tempList;
		Node tempNode;
		d.add(1); // 시작 노드 
		int sum = 0;
		
		while(!d.isEmpty()) {
			int cur = d.remove();
			visited[cur] = true; // 해당 노드 방문 
			tempList = al[cur];
			for(Node o : tempList) { // 해당 노드와 연결된 모든 노드 
				if(!visited[o.node]) {
					pq.add(o); // 모든 end 노드를 pq에 삽입 (현재 노드 집합과 연결된 모든 노드가 pq에 담김)
				}
			}
			
			while(!pq.isEmpty()) { // pq에 있는 모든 노드 중 우선순위(가중치)가 가장 낮은 노드 부터  
				tempNode = pq.remove();
				if(!visited[tempNode.node]) { // 방문한적 없을 경우
					sum += tempNode.weight;
					d.add(tempNode.node); // 다음 노드로 삽입 
					break;
				}
			}
		}
		System.out.println(sum);
		
	}
}
class Node implements Comparable<Node>{
	int node;
	int weight;
	Node(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node e) {
		return this.weight < e.weight ? -1 : 1;
	}
}
