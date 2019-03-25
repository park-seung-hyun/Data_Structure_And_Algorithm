// IntQueue
// pg148 
// 큐 구현 (Int형)
// 스택과 달리 그냥 배열로는 Dequeue 과정에서 O(n) 시간 복잡도를 가지므로 비효율적 
// Ring Buffer 개념 사용하여 O(1) 시간 복잡도로 구현 

public class IntQueue {
	private int max; // 큐 용량 
	private int front; // 첫 번째 요소 
	private int rear; // 마지막 요소 (+1)
	private int num; // 현재 데이터 수 
	private int[] que; // 큐 본체 (본체를 참조하는) 
	
	// 실행 시 예외: 큐가 비어있음.
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {
			System.out.println("큐가 비어 있습니다. ");
		}
	}
	// 실행 시 예외: 큐 가득 참. 
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {
			System.out.println("큐가 가득 찼습니다. ");
		}
	}
	// 생성자 
	public IntQueue(int capacity) {
		num = front = rear = 0; // 데이터가 없으므로 모두 0 
		max = capacity; // 큐 용량 
		try {
			que = new int[max]; // 큐 본체 생성 
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 인큐 (enque)
	public int enque(int x) throws OverflowIntQueueException {
		if(num>= max)
			throw new OverflowIntQueueException();
		
		// 인큐 작업 
		que[rear++] = x; // rear는 마지막 원소 +1 이니까 대입 후 증가 
		num ++;
		
		// 인덱스 에러 방지 
		if(rear == max) // rear(인덱스) 가 배열의 크기랑 같아지면 0으로 변경 
			rear = 0;
		
		return x;
	}
	
	// 디큐 (deque)
	public int deque() throws EmptyIntQueueException {
		if(num <=0)
			throw new EmptyIntQueueException();
		
		// 디큐 작업 
		int x = que[front++];
		num--;
		
		// 인덱스 에러 방지 
		if(front == max)
			front = 0;
		
		return x;
	}
	
	// 피크 (peek) 
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		
		// front 위치의 요소를 반환 
		int x = que[front];
		
		return x;
	}
	
	// indexOf 
	public int indexOf(int x) {
		for(int i=0;i<num;i++) {
			int idx = (i+front) % max; // idx는 첫번째 요소부터 
			
			if(x == que[idx])
				return idx;
		}
		return -1;
	}
	
	// clear
	public void clear() {
		num = front = rear = 0;
	}
	
	// 용량 capacity 
	public int capacity() {
		return max;
	}
	
	// size
	public int size() {
		return num;
	}
	
	// isEmpty 
	public boolean isEmpty() {
		return (num <=0 );
	}
	
	// isFull 
	public boolean isFull() {
		return (num >= max);
	}
	
	// dump 
	public void dump() {
		if(num <=0)
			System.out.println("큐 비어있음. ");
		else {
			for(int i=0;i< num;i++) {
				System.out.print(que[(i+front)%max] + " ");
			}
			System.out.println();
		}
	}
}
