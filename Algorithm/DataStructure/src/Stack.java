// 스택 
// LIFO 

import java.util.NoSuchElementException;
public class Stack<T> {
	private static class StackNode<T>{
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
	public T peek() {
		if(top == null)  throw new NoSuchElementException();
		return top.data;
	}
	public boolean isEmpty() {
		return top == null;
	}
}
