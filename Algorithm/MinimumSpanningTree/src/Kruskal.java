// Kruskal 알고리즘 
// Minimum Spanning Tree (MST) 
// 최소 신장 트리를 구하기 위해 사용되는 알고리즘 
// 간선 기반 알고리즘 
// 백준 1197번 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Kruskal {
	static ArrayList<Edge> al = new ArrayList<Edge>();
	static int[] parent;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int v = stdIn.nextInt();
		int e = stdIn.nextInt();
		parent = new int[v+1];
		for(int i=1;i<=v;i++) {
			parent[i] = i;
		}
		for(int i=0;i<e;i++) {
			int start = stdIn.nextInt();
			int end = stdIn.nextInt();
			int weight = stdIn.nextInt();
			al.add(new Edge(start, end, weight));
		}
		kruskal(v, e);
	}
	static void kruskal(int v, int e) {
		Collections.sort(al); // 모든 가중치 정렬 
		int sum = 0;
		for(Edge edge : al) { // 낮은 가중치부터 간선 선택 
			// 사이클 여부 확인 -> Union-Find 알고리즘 
			if(!isSameParent(edge.node1, edge.node2)) {
				// 해당 간선이 사이클을 선택하지 않는다면 
				sum += edge.weight;
				union(edge.node1, edge.node2); // 해당 간선을 집합에 포함시킴. 
			}
		}
		System.out.println(sum);
	}
	// 간선의 양 끝 정점이 같은 집합에 있는지 여부 확인 -> 사이클 생성 여부 확인 
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return true;
		else return false;
	}
	// 해당 두 정점을 집합에 포함시킴 
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			parent[x] = y;
		}
	}
	// 해당 정점의 부모 정점 찾기 
	static int find(int x) {
		if(x == parent[x]) return x;
		else {
			return parent[x] = find(parent[x]);
		}
	}
}
class Edge implements Comparable<Edge>{
	int node1;
	int node2;
	int weight;
	Edge(int node1, int node2, int weight){
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o){
		return this.weight < o.weight ? -1 : 1;
	}
}
