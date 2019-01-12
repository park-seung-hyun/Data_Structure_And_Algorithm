// Int2DArray
// pg80
// 다차원 배열 
public class Int2DArray {
	public static void main (String args[]) {
		int[][] x = new int[2][4];
		
		x[0][1] = 37;
		x[1][3] = 18;
		
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x[0].length;j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
}
