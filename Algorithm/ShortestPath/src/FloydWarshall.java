// Floyd Warshall 알고리즘 
// Shortest Path 
// 모든 정점에서 다른 모든 정점으로의 최단 경로 
// 백준 11404번 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class FloydWarshall {
	static int[][] map;
	static int[][] d;
	static final int INF = 10000000;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int v = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new int[v+1][v+1];
		for(int i=1;i<=v;i++)Arrays.fill(map[i], INF);
		for(int i=0;i<m;i++) {
			int start = stdIn.nextInt();
			int end = stdIn.nextInt();
			int weight = stdIn.nextInt();
			// 알고리즘은 간단하지만 
			// 초기화 설정 잘해줘야됨.. 
			if(map[start][end] == INF || (map[start][end] != INF && map[start][end] > weight))
				map[start][end] = weight;
		}
		floydWarshall(v, m);
	}
	static void floydWarshall(int v, int m) {
		
		// 비교적 간단 
		for(int k=1;k<=v;k++) {
			for(int i=1;i<=v;i++) {
				for(int j=1;j<=v;j++) {
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		for(int i=1;i<=v;i++) {
			for(int j=1;j<=v;j++) {
				if(i == j || map[i][j] == INF) System.out.printf("%d ", 0);
				else System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
		
	}
}
