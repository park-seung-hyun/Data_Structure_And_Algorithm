// 2529번 
// 부등호  
// 브루트 포스

import java.util.Scanner;
//public class BJ2529 {
//	static char[] bu;
//	static int[] visited = new int[10];
//	static long Min = Long.MAX_VALUE;
//	static String MinStr ="";
//	static long Max = 0;
//	static String MaxStr ="";
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		bu = new char[n];
//		for(int i=0;i<n;i++) bu[i] = stdIn.next().charAt(0);
//		solve(n);
//	}
//	static void solve(int n) {
//		for(int i=0;i<10;i++) {
//			visited[i] = 1;
//			go(""+i,0,n);
//			visited[i] = 0;
//		}
//		System.out.println(MaxStr);
//		System.out.println(MinStr);
//	}
//	static void go(String s, int id, int n) {
//		if(id == n) {
//			long ns = Long.parseLong(s);
//			if(Min>ns) {
//				Min = ns;
//				MinStr = s;
//			}
//			if(Max<ns) {
//				Max = ns;
//				MaxStr = s;
//			}
//			return;
//		}
//		
//		for(int i=0;i<10;i++) {
//			if(visited[i] == 0) {
//				int lastInt = s.charAt(s.length()-1) - '0';
//				if(bu[id] == '<' && lastInt < i) {
//					visited[i] = 1;
//					go(s+i,id+1,n);
//					visited[i] = 0;
//				}else if(bu[id] == '>' && lastInt > i){
//					visited[i] = 1;
//					go(s+i,id+1,n);
//					visited[i] = 0;
//				}
//			}
//		}
//		
//	}
//}	


public class BJ2529{
	static char[] bu;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		bu = new char[n];
		for(int i=0;i<n;i++)bu[i] = stdIn.next().charAt(0);
		
		int[] ar = new int[n+1];
		for(int i=0;i<n+1;i++) ar[i] = 9-i;
		do {
			if(isPos(ar, n)) {
				print(ar);
				break;
			}
		}while(np(ar));
		for(int i=0;i<n+1;i++) ar[i] = i;
		do {
			if(isPos(ar, n)) {
				print(ar);
				break;
			}
		}while(np2(ar));
		
	}
	static void print(int[] ar) {
		String s = "";
		for(int i : ar) {
			s += i; 	
		}
		System.out.println(s);
	}
	static boolean isPos(int[] ar, int n) {
		
		for(int i=0;i<n;i++) {
			if(bu[i] == '<') { // <
				if(ar[i] >= ar[i+1]) return false;
			}else { // >
				if(ar[i] <= ar[i+1]) return false;
			}
		}
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i= n-1;
		while(i>0 && ar[i-1] <= ar[i])i--;
		if(i==0)return false;
		int j = n-1;
		while(ar[i-1] <= ar[j])j--;
		swap(ar, i-1,j);
		j = n-1;
		while(i<j) {
			swap(ar, i,j);
			i++;
			j--;
		}
		return true;
	}
	static boolean np2(int[] ar) {
		int n = ar.length;
		int i= n-1;
		while(i>0 && ar[i-1] >= ar[i])i--;
		if(i==0)return false;
		int j = n-1;
		while(ar[i-1] >= ar[j])j--;
		swap(ar, i-1,j);
		j = n-1;
		while(i<j) {
			swap(ar, i,j);
			i++;
			j--;
		}
		return true;
	}
}