
public class Heap {
	static int[] array = new int[100];
	static int count = 0;
	public static void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public static void push(int n) {
		count++;
		int temp_id = count;
		array[temp_id] = n;
		
		while(temp_id>1) {
			int root = temp_id/2; // 부모 노드 
			if(array[temp_id] > array[root]) {
				swap(temp_id, root);
				temp_id = temp_id/2;
			}
			else {
				// 제자리를 찾은 경우 
				break;
			}
		}
	}
	public static void pop() {
		int start = 1;
		array[start] = array[count];
		array[count] = 0;
		count --;
		
		while(true) {
			// 자식들 보다 큰 경우 (제자리에 있을 경우)
			if((array[start] > array[start*2]) && (array[start] > array[start*2+1])) {
				break;
			}
			else if(array[start*2]>array[start*2+1]) {
				swap(start, start*2);
				start = start*2;
			}
			else {
				swap(start, start*2+1);
				start = start*2+1;
			}
		}
	}
}
