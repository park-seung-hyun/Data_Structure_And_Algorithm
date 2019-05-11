// 큐 
// FIFO 

import java.util.NoSuchElementException;
public class Queue<T> {
	
	// 연결리스트로 구현하기 때문에 노드 클래스 구현
	private static class QueueNode<T>{
		// 각 노드는 해당 노드의 data 와 다음 노드 정보를 가짐. 
		private T data;
		private QueueNode next;
		public QueueNode (T data) {
			this.data = data;
		}
	}
	// 초기 first, last 설정
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	// add 
	public void add(T item) {
		QueueNode t = new QueueNode(item);
		if(last != null) last.next = t;
		
		// 만약 비어있을 경우? 
		last = t;
		if(first ==	null) first = last;
	}
	// remove
	public T remove() {
		if(first == null) throw new NoSuchElementException();
		T data = first.data; // 반환하기 위한 데이터 
		first = first.next; // 두번째 데이터를 첫번째로 
		if(first == null) last = null;
		return data;
	}
	// peek 
	public T peek() {
		if(first == null) throw new NoSuchElementException();
		return first.data;
	}
	// isEmpty
	public boolean isEmpty() {
		return first == null;
	}
}
