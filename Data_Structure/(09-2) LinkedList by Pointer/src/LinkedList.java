// LinkedList  
// pg311 
// 연결리스트 

import java.util.Comparator;

public class LinkedList<E> {
	// 연결 리스트 생성자 
	public LinkedList() {
		// 처음에는 빈 연결리스트 생성 
		head = crnt = null;
	}
	// 노드 검색 
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 스캔 중인 노드 (제일 처음은 머리 노드)
		
		// ptr이 null 이면 꼬리 노드까지 탐색된 것 (즉 스캔할 노드가 없으므로 찾고자하는 노드 없음.)
		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { // 검색 성공
				crnt = ptr; // 현재 선택 노드 
				return ptr.data;
			}
			ptr = ptr.next; // 다음 노드 선택 
		}
		return null; // 검색 실패 
	}
	// 머리에 노드 삽입 
	public void addFirst(E obj) {
		Node<E> ptr = head; // 기존에 머리 노드를 ptr에 저장 
		// head를 새로운 노드로 저장과 동시에 새로운 노드의 next를 기존의 head로 설정 
		head = crnt = new Node<E>(obj, ptr); 
	}
	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		// 빈 리스트의 경우 머리에 삽입과 같음. 
		if(head == null) {
			addFirst(obj);
		}else {
			// 머리부터 꼬리까지 찾아감. 
			Node<E> ptr = head;
			while(ptr.next!=null)
				ptr = ptr.next;
			// 여기서 ptr은 기존 꼬리 노드로 참조하던 null값을 새로운 노드로 대체 
			// 새로운 노드의 next는 null로 설정 
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	// 머리 노드를 삭제 
	public void removeFirst() {
		if(head != null) // 빈 리스트가 아닐 경우만 
			head = crnt = head.next; // 두 번째 노드를 머리로 설정 
	}
	// 꼬리 노드를 삭제 
	public void removeLast() {
		if(head!= null) {
			if(head.next!=null) // 노드가 하나만 있을 경우 
				removeFirst();
		}else {
			Node<E> ptr = head; // 스캔 중인 노드 
			Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드 (ptr의 앞쪽 노드)
			while(ptr.next != null) {
				pre = ptr;
				ptr = ptr.next; 
			}
			pre.next = null; // 마지막에서 앞쪽 노드를 꼬리 노드로 설정
			crnt = pre;
		}
	}
	// 노드 p 삭제 
	public void remove(Node p) {
		if(head != null) {
			if(p == head)
				removeFirst();
			else {
				Node<E> ptr = head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) return; // p가 리스트에 없을 경우 
				}
				// ptr은 여기서 p의 앞쪽 노드 
				// ptr의 다음을 p가 아닌 p의 앞쪽 노드로 설정 (p를 제거)
				ptr.next = p.next; 
				crnt = ptr;
			}
		}
	}
	// 선택 노드를 삭제 
	public void removeCurrentNode() {
		remove(crnt);
	}
	// 모든 노드를 삭제 
	public void clear() {
		while(head !=null) { // 리스트가 빌 때까지 
			removeFirst(); // 머리 노드 삭제 
		}
		crnt = null; 
	}
	// 선택 노드를 하나 뒤쪽으로 이동 
	public boolean next() {
		if(crnt == null || crnt.next==null) // 뒤쪽으로 이동 불가 
			return false;
		crnt = crnt.next;
		return true;
	}
	// 선택한 노드를 출력 
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다. ");
		else
			System.out.println(crnt.data);
	}
	// 모든 노드 출력 
	public void dump() {
		Node<E> ptr = head;
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	// 노드 클래스 
	class Node<E>{
		private E data; // 데이터 
		private Node<E> next; // 뒤쪽 포인터 (다음 노드를 참조)
		// 생성자 
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	private Node<E> head; // 머리 노드 
	private Node<E> crnt; // 선택 노드 
	
}
