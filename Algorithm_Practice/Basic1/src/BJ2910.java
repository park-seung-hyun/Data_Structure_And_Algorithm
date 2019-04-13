// 2910번  
// 빈도 정렬 
// 해쉬 맵 (HashMap) 사용 

// https://zoonvivor.tistory.com/132
// https://medium.com/@igniter.yoo/java-linkedhashmap-%EC%88%9C%EC%84%9C%EB%A5%BC-%EC%9C%A0%EC%A7%80%ED%95%98%EB%8A%94-%ED%95%B4%EC%8B%9C%EB%A7%B5-11a7846d8893
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class BJ2910 {
	public static void main (String args[]) {
		// 입출력
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int C = stdIn.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = stdIn.nextInt();
		}
		
		// HashMap 생성
		// LinkedHashMap은 들어온 순서를 유지 
		// 기존 HashMap은 keySet이 순서를 보장하지 않음.
		HashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		
		// 해당 숫자를 Key, 빈도수를 value로 지정 
		for(int i=0;i< arr.length;i++) {
			if(hm.containsKey(arr[i]))
				hm.replace(arr[i], hm.get(arr[i])+1);
			else
				hm.put(arr[i], 1);
		}
		
		// keySet을 보면 순서 유지된 것을 알 수 있음.
		// keySet을 통해 List 생성 
		ArrayList<Integer> a = new ArrayList<Integer>(hm.keySet());
		
		// Sort
		// 내림차순으로 변경 
		Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // list.get(b) 와 list.get(a)의 위치가 바뀌면 오름차순이 된다.
            		return Integer.compare(hm.get(b), hm.get(a));
            }
        });
		// 정렬된 리스트를 값의 빈도만큼 출력 
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<hm.get(a.get(i));j++)
				System.out.print(a.get(i) + " ");
		}
	}
}