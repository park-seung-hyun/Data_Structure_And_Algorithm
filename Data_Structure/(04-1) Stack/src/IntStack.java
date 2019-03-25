// IntStack 
// pg136 
// 스택 구현 (Int형)

public class IntStack {
	private int max; // 스택 용량 
	private int ptr; // 스택 포인터 (현재 쌓여있는 데이터 수)
	private int[] stk; // 스택 본체 (본체를 참조하는)
	
	// 실행 시 예외: 스택이 비어있음.
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
			System.out.println("스택이 비어 있습니다. ");
		}
	}
	// 실행 시 예외: 스택이 가득 참. 
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
			System.out.println("스택이 가득 찼습니다. ");
		}
	}
	// 생성자 
	public IntStack(int capacity) {
		ptr = 0; // 데이터가 없으므로 0 
		max = capacity; // 스택 용량 
		try {
			stk = new int[max]; // 요솟수가 max인 스택 배열 본체를 생성 
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 푸시 (push)
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) // 스택이 가득 찰 경우 예외를 던짐. 
			throw new OverflowIntStackException();
		return stk[ptr++] = x; // 반환값은 푸쉬한 값 
	}
	
	// 팝 (pop)
	public int pop() throws EmptyIntStackException{
		if(ptr <= 0) // 스택이 빌 경우 예외를 던짐. 
			throw new EmptyIntStackException();
		// 스택 포인터 감소시킴. 
		return stk[--ptr]; // 반환값은 팝된 값 
	}
	
	// 피크 (peek)
	public int peek() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		// 스택 포인터를 감소시키지 않음. 
		return stk[ptr -1]; // 반환값은 top 값 
	}
	
	// indexOf 
	public int indexOf(int x) {
		for(int i= ptr-1;i>=0;i--) { // Top -> bottom (Pop에 가장 가까운 index 찾음.)
			if(stk[i] == x)
				return i;
		}
		return -1;
	}
	
	// clear 
	public void clear() {
		// 스택 내 데이터를 모두 비움. 
		// ptr만 변경하면 끝. (pop과 같은 원리)
		ptr = 0;
	}
	
	// 용량 capacity 
	public int capacity() {
		// 스택 가용 용량 
		return max;
	}
	
	// size
	public int size() {
		// 스택 내 데이터 수 
		return ptr;
	}
	
	// isEmpty 
	public boolean isEmpty() {
		// 비어있을 경우 ptr은 0 
		return (ptr <= 0);
	}
	
	// isFull 
	public boolean isFull() {
		// 가득 차있을 경우 ptr은 max 
		return (ptr >= max);
	}
	
	// dump 
	public void dump() {
		// Bottom -> Top 순으로 데이터 출력 
		if(ptr <=0)
			System.out.println("스택 비어있음. ");
		else {
			for(int i=0;i<ptr;i++) {
				System.out.println(stk[i]+" ");
			}
			System.out.println();
		}
	}
}
