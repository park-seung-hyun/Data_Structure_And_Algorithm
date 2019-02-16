// 2910번 (복습)
// 빈도 정렬 
// 해쉬 맵 (HashMap) 사용 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Re_BJ2910 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int c = stdIn.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = stdIn.nextInt();
		}
		solve(ar);	
	}
	static void solve(int[] ar) {
		
		HashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		
		for(int i=0;i<ar.length;i++) {
			if(hm.containsKey(ar[i])) {
				hm.replace(ar[i],hm.get(ar[i])+1);
			}else {
				hm.put(ar[i], 1);
			}
		}

		ArrayList<Integer> a = new ArrayList<Integer>(hm.keySet());
		Collections.sort(a, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return Integer.compare(hm.get(b), hm.get(a));
			}
		});
		for(int i=0;i<a.size();i++) {
			for(int j = 0;j<hm.get(a.get(i));j++) {
				System.out.printf("%d ",a.get(i));
			}
		}	
	}
}
