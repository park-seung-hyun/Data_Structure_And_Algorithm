// Dijkstra 알고리즘 
// Shortest Path 
// 한 정점에서 다른 모든 정점으로의 최단 경로 
// 백준 1753번 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Dijkstra {
	static ArrayList<Node> al[]; 
	static boolean[] visited;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int v = stdIn.nextInt();
		int e = stdIn.nextInt();
		int s = stdIn.nextInt();
		visited = new boolean[v+1];
		distance = new int[v+1];
		al = (ArrayList<Node>[])new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			al[i] = new ArrayList<Node>();
		}
		for(int i=0;i<e;i++) {
			int start = stdIn.nextInt();
			int end = stdIn.nextInt();
			int weight = stdIn.nextInt();
			al[start].add(new Node(end , weight));
		}
		dijkstra(s);
	}
	static void dijkstra(int s) {
		// 가중치가 낮은 정점부터 remove하기 위해 우선순위 큐 사용 
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(distance, INF); // 모든 거리 무한대로 초기화 
		distance[s] = 0; // 시작 정점 거리는 0으로 초기화 
		pq.add(new Node(s,0)); // 시작 정점 
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			int node = cur.node;
			if(visited[node] == true) continue;
			visited[node] = true;
			for(Node e : al[node]) { // 해당 정점과 연결된 모든 정점 확인 
				if(visited[e.node] == false) { // 방문한적 없다면 거리 초기화 
					distance[e.node] = Math.min(distance[node] + e.weight, distance[e.node]);
					pq.add(new Node(e.node, distance[e.node])); // 인접한 모든 정점 우선순위 큐에 삽입 
				}
			}
		}
		for(int i =1;i<distance.length; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}
class Node implements Comparable<Node>{
	int node;
	int weight;
	Node(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
	public int compareTo(Node o) {
		return this.weight < o.weight ? -1: 1;
	}
}
