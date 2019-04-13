// 15650번
// N과 M (2)
// 재귀 호출 

//import java.util.Scanner;
//public class BJ15650 {
//	static int[] ans = new int[10];
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
////		solve(0,0,n,m);
//		solve2(1,0,n,m);
//	}
//	static void solve(int index,int start, int n, int m) {
//		if(index == m) {
//			for(int i=0;i<m;i++) {
//				System.out.printf("%d ",ans[i]);
//			}
//			System.out.println();
//			return;
//		}
//		// start 추가 
//		// start는 전에 어떤 수 였는지를 저장  
//		// start+1부터 시작하기 때문에 check 배열이 필요없음.
//		// 또 자동으로 오름차순이 됨. 
//		for(int i=start+1;i<=n;i++) {
//			ans[index] = i;
//			solve(index+1, i,n,m);
//		}
//	}
//	static void solve2(int index, int selected, int n, int m) {
//		// selected는 정답을 채우는 인덱스 
//		if(selected == m) { // 정답인 경우 (1)
//			for(int i=0;i<m;i++) {
//				System.out.printf("%d ",ans[i]);
//			}
//			System.out.println();
//			return;
//		}
//		if(index>n) { // 불가능한 경우 (2)
//			return;
//		}
//		// 다음 경우 호출 (3)
//		ans[selected] = index;
//		solve2(index +1, selected +1, n, m);
//		solve2(index +1, selected, n, m);
//		
//	}
//}

import java.util.Scanner;
public class BJ15650{
	static int n = 0;
	static int m = 0;
	static int[] ar;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		ar = new int[m];
//		go(0,1);
		go2(0,0);
	}
	static void go(int id,int num) {
		if(id == m) {
			for(int i: ar) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			return;
		}
		if(num > n) return;
		
		ar[id] = num;
		go(id+1, num+1);
		go(id, num+1);
	}
	static void go2(int id, int num) {
		if(id == m) {
			for(int i: ar) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			return;
		}
		if(num > n)return;
		for(int i=num+1; i<=n; i++) {
			ar[id] = i;
			go2(id+1, i);
		}
	}
}