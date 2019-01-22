// 2910번  
// 빈도 정렬 
// 해쉬 맵 (HashMap) 사용 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class BJ2910 {
	public static void main (String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int C = stdIn.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = stdIn.nextInt();
		}
		
		HashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		
		for(int i=0;i< arr.length;i++) {
			if(hm.containsKey(arr[i]))
				hm.replace(arr[i], hm.get(arr[i])+1);
			else
				hm.put(arr[i], 1);
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>(hm.keySet());
		
		Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
            		return Integer.compare(hm.get(b), hm.get(a));
            }
        });
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<hm.get(a.get(i));j++)
				System.out.print(a.get(i) + " ");
		}
	}
}
