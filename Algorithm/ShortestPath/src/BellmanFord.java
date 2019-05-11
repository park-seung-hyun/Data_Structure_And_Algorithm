// Floyd Warshall 알고리즘 
// Shortest Path 
// 한 정점에서 다른 모든 정점으로의 최단 경로 
// 음수 간선 가능 
// 음수 사이클 존재 여부 확인 가능 
// 백준 11657번 

import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
	static Edge[] edges ;
	static int[] distance;
	static final int Inf = 1000000;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		edges = new Edge[m];
		distance = new int[n+1];
		Arrays.fill(distance, Inf);
		for(int i=0;i<m;i++) {
			int s = stdIn.nextInt();
			int d = stdIn.nextInt();
			int w = stdIn.nextInt();
			edges[i] = new Edge(s,d,w);
		}
		distance[1] = 0;
		
		if(bellmanFord(n,m)) {
			for(int i=2;i<=n;i++) {
				System.out.println( distance[i] == Inf ? -1 : distance[i]);
			}
		}else {
			System.out.println(-1);
		}
		
	}
	static boolean bellmanFord(int n, int m) {
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m;j++) {
				if(distance[edges[j].d] > distance[edges[j].s] + edges[j].w) {
					distance[edges[j].d] = distance[edges[j].s] + edges[j].w;
				}
			}
		}
		for(int j=0;j<m;j++) {
			if(distance[edges[j].d] > distance[edges[j].s] + edges[j].w) {
				return false;
			}
		}
		return true;
	}
}
class Edge{
	int s;
	int d;
	int w;
	Edge(int s, int d, int w){
		this.s = s;
		this.d = d;
		this.w = w;
	}
}