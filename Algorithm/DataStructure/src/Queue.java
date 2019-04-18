// 큐 
// FIFO 

import java.util.NoSuchElementException;
public class Queue<T> {
	private static class QueueNode<T>{
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
	public T peek() {
		if(first == null) throw new NoSuchElementException();
		return first.data;
	}
	public boolean isEmpty() {
		return first == null;
	}
}
