// 15663번
// N과 M (9)
// 재귀 호출 
// cnt 만드는 법 다시 보기. 

//import java.util.Arrays;
//import java.util.Scanner;
//public class BJ15663 {
//	static int[] cnt = new int[10];
//	static int[] ans = new int[10];
//	static int[] num = new int[10];
//	public static void main (String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		int[] ar = new int[n];
//		for(int i=0;i<n;i++) {
//			ar[i] = stdIn.nextInt();
//		}
//		Arrays.sort(ar);
//		
//		int k = 0;
//        int x = ar[0];
//        int c = 1;
//        for (int i=1; i<n; i++) {
//            if (x == ar[i]) {
//                c += 1;
//            } else {
//            		num[k] = x;
//                cnt[k] = c;
//                k += 1;
//                x = ar[i];
//                c = 1;
//            }
//        }
//        num[k] = x;
//        cnt[k] = c;
//		solve(0,n,m,ar);
//	}
//	static void solve(int index, int n, int m, int[] ar) {
//		if(index == m) {
//			for(int i=0;i<m;i++) {
//				System.out.printf("%d ",num[ans[i]]);
//			}
//			System.out.println();
//			return;
//		}
//		for(int i=0;i<n;i++) {
//			if(cnt[i]>0) {
//				cnt[i]-=1;
//				ans[index] = i;
//				solve(index+1, n, m, ar);
//				cnt[i]+=1;
//			}
//		}
//	}
//}

import java.util.Arrays;
import java.util.Scanner;
public class BJ15663{
	static int n;
	static int m;
	static int[] num;
	static int[] ar;
	static int[] cnt;
	static int[] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		num = new int[n];
		cnt = new int[10];
		visited = new int[n];
		for(int i=0;i<n;i++) num[i] = stdIn.nextInt();
		ar = new int[m];
		Arrays.sort(num);
		for(int i=0;i<n;i++) {
			cnt[num[i]]++;
		}
		
		go(0);
	}
	static void go(int id) {
		if(id == m) {
			for(int i : ar) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]==1) continue;
			if(cnt[num[i]]>0) {
				cnt[num[i]]--;
				visited[i]=1;
				System.out.println(Arrays.toString(cnt));
				ar[id] = num[i];
				go(id+1);
				visited[i]=0;
				cnt[num[i]]++;
			}
		}
	}
}