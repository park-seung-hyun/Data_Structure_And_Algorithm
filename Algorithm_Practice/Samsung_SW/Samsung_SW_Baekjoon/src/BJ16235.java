// 삼성 기출 
// 16235번
// 나무 제테크 
// ArrayList 사용할때 주의할 점!! 반복문 내에서 remove나 add할때 index 밀림, 땅김 현상있음.. 조심할 것..
// Collections.sort 할때 override 하는법 배우기 
// ArrayList 사용시 메모리 터짐..
// ArrayList[] 사용할 것 ..

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//public class BJ16235 {
//	static int[][] map;
//	static int[][] food;
//	static ArrayList<Integer>[] trees;
//	static ArrayList<Integer>[] deads;
//	static final int[] dx= {-1,0,1,0 ,1,1,-1,-1};
//	static final int[] dy= {0,1,0,-1 ,-1,1,-1,1};
//	public static void main(String[] args) {
//		Scanner stdIn =new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new int[n][n];
//		food = new int[n][n];
//		int m = stdIn.nextInt();
//		trees = (ArrayList<Integer>[]) new ArrayList[n*n];
//		deads = (ArrayList<Integer>[]) new ArrayList[n*n];
//		for(int i=0;i<n*n;i++) trees[i] = new ArrayList<Integer>();
//		for(int i=0;i<n*n;i++) deads[i] = new ArrayList<Integer>();
//		int k = stdIn.nextInt();
//		
//		// 매 겨울마다 양분 ..
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				food[i][j] = stdIn.nextInt();
//			}
//		}
//		// 초기 양분 
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				map[i][j] = 5;
//			}
//		}
//		for(int i=0;i<m;i++) {
//			int x = stdIn.nextInt()-1;
//			int y = stdIn.nextInt()-1;
//			int z = stdIn.nextInt();
//			trees[x*n+y].add(z);
//		}
//
//		
//		int cnt = 0;
//		while(cnt < k) {
//			// 봄..
//
//			
//			for(int i=0;i<n*n;i++) deads[i] = new ArrayList<Integer>();
//			for(int i=0;i<n*n;i++) {
//				Collections.sort(trees[i]);
//				for(int j=0;j<trees[i].size();j++) {
//					int age = trees[i].get(j);
//					if(map[i/n][i%n] >= age) {
//						map[i/n][i%n] -= age;
//						trees[i].set(j, age+1);
//					}else { // 죽음 
//						trees[i].remove(j--);
//						deads[i].add(age/2);
//					}
//				}
//			}
//
//			
//			// 여름..
//			for(int i=0;i<n*n;i++) {
//				for(int j=0;j<deads[i].size();j++) {
//					int energy = deads[i].get(j);
//					map[i/n][i%n] += energy;
//				}
//			}
//			
//			// 가을.. 
//			for(int i=0;i<n*n;i++) {
//				for(int j=0;j<trees[i].size();j++) {
//					int age = trees[i].get(j);
//					if(age%5 == 0) { // 0일땐? 
//						for(int l=0;l<8;l++) {
//							int nx = i/n + dx[l];
//							int ny = i%n + dy[l];
//							if(nx>=0 && ny>=0 && nx<n && ny<n) {
//								trees[nx*n+ny].add(1);
//							}
//						}
//					}
//				}
//			}
//			
//			// 겨울..
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					map[i][j] += food[i][j];
//				}
//			}
////			print2(n);
//			cnt++;
//		}
//		int sum = 0;
//		for(int i=0;i<n*n;i++) {
//			sum += trees[i].size();
//		}
//		System.out.println(sum);
//	}
//	static void print(int n) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void print2(int n) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", trees[i*n+j].size());
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//}
//class Tree{
//	int x;
//	int y;
//	int z;
//	Tree(int x, int y, int z){
//		this.x = x;
//		this.y = y;
//		this.z = z;
//	}
//}

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//public class BJ16235{
//	static int[][] map;
//	static int[][] food;
//	static int[] dx = {-1,0,1,0, 1,-1,-1,1};
//	static int[] dy = {0,1,0,-1, 1,-1,1,-1};
//	static ArrayList<Tree> trees = new ArrayList<Tree>();
//	static ArrayList<Tree> deads;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		int k = stdIn.nextInt();
//		food = new int[n][n];
//		map = new int[n][n];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				food[i][j] = stdIn.nextInt();
//				map[i][j] = 5;
//			}
//		}
//		for(int i=0;i<m;i++) {
//			int x = stdIn.nextInt()-1;
//			int y = stdIn.nextInt()-1;
//			int z = stdIn.nextInt();
//			trees.add(new Tree(x,y,z));
//		}
//		int cnt = 0;
//		while(cnt < k) {
//			// 봄 	
//			Collections.sort(trees);
//			deads = new ArrayList<Tree>();
//			for(int i=trees.size()-1;i>=0;i--) {
//				int x = trees.get(i).x;
//				int y = trees.get(i).y;
//				int z = trees.get(i).z;
//				if(map[x][y] >= z) {
//					map[x][y] -= z;
//					trees.set(i, new Tree(x,y,z+1));
//				}else {
//					deads.add(new Tree(x,y,z));
//					trees.remove(i);
//				}
//			}
//			
//			// 여름 
//			for(Tree d : deads) {
//				int x = d.x;
//				int y = d.y;
//				int z = d.z;
//				map[x][y] += (z/2);
//			}
//			
//			// 가을 
//			for(int i=0;i<trees.size();i++) {
//				int x = trees.get(i).x;
//				int y = trees.get(i).y;
//				int z = trees.get(i).z;
//				if(z%5==0) {
//					for(int j=0;j<8;j++) {
//						int nx = x + dx[j];
//						int ny = y + dy[j];
//						if(nx>=0 && ny>=0 && nx < n && ny < n) {
//							trees.add(new Tree(nx,ny,1));
//						}
//					}
//				}
//			}
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					map[i][j] += food[i][j];
//				}
//			}
//			cnt++;
//		}
//		System.out.println(trees.size());
//	}
//	static void print(int n) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//
//}
//class Tree implements Comparable<Tree>{
//	int x;
//	int y;
//	int z;
//	Tree(int x, int y, int z){
//		this.x = x;
//		this.y = y;
//		this.z = z;
//	}
//	public int compareTo(Tree o) {
//		return o.z > this.z ? 1:-1;
//	}
//}