import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ2817 {

	public static void main (String[] args) throws NumberFormatException, IOException {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		int n = stdIn.nextInt();
		
//		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//		int t = Integer.parseInt(br.readLine());
//		int n = Integer.parseInt(br.readLine());
		
		
		if(n != 0) {
			
			int[] ss1 = new int[n];
			String[] sn1 = new String[n];
			
			for(int i=0 ; i<n ; i++) {
				sn1[i] = stdIn.next();
				ss1[i] = stdIn.nextInt();
//				StringTokenizer st = new StringTokenizer( br.readLine());
//				sn1[i] = Integer.parseInt(st.nextToken());
//				ss1[i] = Integer.parseInt(st.nextToken());
			}
//			
			underFiveFilter(t, ss1);
			double[][] chips = divide(n, ss1);
			sort(chips, sn1);
		}
		
	}
	static void sort(double[][] ch, String[] sn) {
		int[] score = new int[sn.length];
		int[] id = new int[sn.length];
//		
		Map<String,Integer> hashMap = new HashMap<String,Integer>();
		for(int i=0;i<sn.length;i++) {
			hashMap.put(sn[i], i);
		}
		
		for(int i=0;i<14;i++) {
			double max = 0;
			int maxId = -1;
			
			for(int j=0;j<sn.length;j++) {
				if(ch[j][id[j]]>max) {
					max = ch[j][id[j]];
					maxId = j;
				}
			}
			if(maxId != -1) {
				id[maxId]++;
				score[maxId]++;	
			}
			
		}

		SortedSet<String> keys = new TreeSet<>(hashMap.keySet());
		for (String key : keys) { 
		   int value = hashMap.get(key);
		   if(ch[value][0] != -1) {
			   System.out.print(key+ " ");
			   System.out.println(score[value]);
		   }
		}
	}
	static void underFiveFilter(int t, int[] ss) {
		double f = t*0.05;
		for(int i=0;i<ss.length;i++) {
			if(ss[i]< f) {
				ss[i] = -1;
			}
		}
	}
	static double[][] divide(int n , int[] ss){
		double[][] chip = new double[n][14];
		for(int i=0;i<n;i++) {
			for(int j=1;j<=14;j++) {
				if(ss[i]!=-1)
					chip[i][j-1] = ss[i]/j;
				else
					chip[i][j-1] = -1;
//				System.out.printf("%3f ",chip[i][j-1]);
			}
//			System.out.println();
		}
		return chip;
	}
}
