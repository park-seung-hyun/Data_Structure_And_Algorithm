// 14888번
// 연산자 끼워넣기 
// 순열 
// 연산자의 수가 정해져있으므로 순열 가능 
// solve -> 순열 
// solve2 -> 재귀 호출 

import java.util.Scanner;
public class BJ14888 {
	static int max = -1000000001;
	static int min = 1000000001;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		int[] cnt = new int[4];
		for(int i=0;i<4;i++) {
			cnt[i] = stdIn.nextInt();
		}
//		solve(ar, cnt);
		
		solve2(ar,1,ar[0],cnt);
		System.out.println(max);
		System.out.println(min);
	}
	static void solve2(int[] ar, int i, int sum, int[] cnt) {
		
		if(i == ar.length) { // 정답인 경우 (1)
			if(max < sum)
				max = sum;
			if(min > sum)
				min = sum;
			return ;
		}
		// 다음 경우 호출 (3)
		if(cnt[0]>0) {
			cnt[0]--;
			solve2(ar, i+1, sum + ar[i], cnt);
			cnt[0]++;
		}
		if(cnt[1]>0) {
			cnt[1]--;
			solve2(ar, i+1, sum - ar[i], cnt);
			cnt[1]++;
		}
		if(cnt[2]>0) {
			cnt[2]--;
			solve2(ar, i+1, sum * ar[i], cnt);
			cnt[2]++;
		}
		if(cnt[3]>0) {
			cnt[3]--;
			solve2(ar, i+1, sum / ar[i], cnt);
			cnt[3]++;
		}
	}
	static void solve(int[] ar, int[] cnt) {
		int[] op = new int[ar.length-1];
		for(int i=0;i<op.length;i++) {
			for(int j =0;j<cnt.length;j++) {
				if(cnt[j]>0) {
					op[i] = j;
					cnt[j]--;
					break;
				}
			}
		}
		int max = -1000000001;
		int min = 1000000001;
		while(true) {
			int sum = ar[0];
			for(int i=0;i<op.length;i++) {
				if(op[i] == 0) { // +
					sum += ar[i+1];
				}else if(op[i] == 1) { // -
					sum -= ar[i+1];
				}else if(op[i] == 2) { // x
					sum *= ar[i+1];
				}else { // %
					sum /= ar[i+1];
				}
			}
			if(sum > max)
				max = sum;
			if(sum < min)
				min = sum;
			
			if(nextPermutation(op)==false)
				break;
		}
		System.out.println(max);
		System.out.println(min);
	}
	static boolean nextPermutation(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1]>=ar[i])i-=1;
		if(i<=0)return false;
		int j = n-1;
		while(ar[i-1]>=ar[j])j-=1;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar, i, j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] ar, int id1, int id2) {
		int t = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = t;
	}
}
