// 스택 
// LIFO 

import java.util.NoSuchElementException;
public class Stack<T> {
	
	// 연결리스트로 구현하기 때문에 노드 클래스 구현 
	private static class StackNode<T>{
		// 각 노드는 해당 노드의 data 와 다음 노드 정보를 가짐. 
		private T data;
		private StackNode next;
		public StackNode (T data) {
			this.data = data;
		}
	}
	
	// 초기 top 설정 
	private StackNode<T> top;

	// pop 
	public T pop() {
		if(top == null)  throw new NoSuchElementException();
		T item = top.data; // 현재 top의 data 
		top = top.next; // top 갱신 
		return item;
	}
	
	// push 
	public void push(T item) {
		StackNode t = new StackNode(item);
		// 들어온 item을 새로운 top로 갱신 
		t.next = top;
		top = t;
	}
	
	// peek 
	public T peek() {
		if(top == null)  throw new NoSuchElementException();
		return top.data;
	}
	
	// isEmpty
	public boolean isEmpty() {
		return top == null;
	}
}
