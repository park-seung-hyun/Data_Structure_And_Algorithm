// BinTree  
// pg378 
// 이진 트리 

import java.util.Comparator;

public class BinTree<K,V> {
	// 노드 
	static class Node<K,V>{
		private K key; // 키 
		private V data; // 데이터 
		private Node<K,V> left; // 왼쪽 자식 
		private Node<K,V> right; // 오른쪽 자식 
		
		Node(K key, V data, Node<K,V> left, Node<K,V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		K getKey() {
			return key;
		}
		V getValue() {
			return data;
		}
		void print() {
			System.out.println(data);
		}
	}
	private Node<K,V> root; // 루트 
	private Comparator<? super K> comparator = null; // 비교자 
	
	// 생성자 
	public BinTree(){
		// 자연 순서에 따라 키 값을 비교 
		root = null;
	}
	public BinTree(Comparator<? super K> c) {
		// 비교자로 키 값을 비교 
		this();
		comparator = c;
	}
	
	// 두 키 값을 비교 
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
					: comparator.compare(key1, key2);
	}
	// 키에 의한 검색 
	public V search(K key) {
		Node<K,V> p = root;
		while(true) {
			if(p==null)
				return null;
			int cond = comp(key, p.getKey());
			if(cond == 0)
				return p.getValue();
			else if(cond < 0)
				p = p.left;
			else
				p = p.right;
		}
	}
	
	// node를 루트로 하는 서브 트리에 노드 <K,V>를 삽입 
	private void addNode(Node<K,V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if(cond == 0) return;
		else if(cond < 0) {
			if(node.left == null)
				node.left = new Node<K,V>(key,data,null,null);
			else
				addNode(node.left, key, data);
		}else {
			if(node.right == null)
				node.right = new Node<K,V>(key,data,null,null);
			else
				addNode(node.right, key, data);
		}
	}
	// 노드를 삽입 
	public void add(K key, V data) {
		if(root == null) // 루트가 없는 빈 트리일 경우 
			// 루트를 해당 노드로 
			root = new Node<K,V>(key, data, null, null);
		else
			addNode(root, key, data);
	}
	// 키 값이 key인 노드를 삭제 
	public boolean remove(K key) {
		
		Node<K,V> p = root; // 스캔 중인 노드 
		Node<K,V> parent = null; // 스캔 중인 노드의 부모 노드 
		boolean isLeftChild = true; // p는 부모의 왼쪽 자식 노드 인지 여부 
		
		while(true) { // 해당 노드 찾기 
			if(p ==null)
				return false; // 그 키 값은 없습니다. 
			int cond = comp(key, p.getKey());
			if(cond == 0) break;
			else {
				parent = p;
				if(cond<0) {
					isLeftChild = true;
					p = p.left;
				}else {
					isLeftChild = false;
					p = p.right;
				}
			}
		}
		
		if(p.left == null) { // 해당 노드의 왼쪽 자식이 없을 경우 
			if(p == root) root = p.right; // p가 루트일 경우 
			else if(isLeftChild) // p가 누군가의 왼쪽 자식이였을 경우 
				parent.left = p.right;
			else // p가 누군가의 오른쪽 자식이였을 경우 
				parent.right = p.right;
		}else if(p.right == null) { // 해당 노드의 오른쪽 자식이 없을 경우 
			if(p == root)
				root = p.left;
			else if(isLeftChild)
				parent.left = p.left;
			else
				parent.right = p.left;
		}else { // 둘 다 있을 경우 
			parent = p;
			Node<K,V> left = p.left;
			isLeftChild = true;
			while(left.right !=null) { // p의 왼쪽 중에서 가장 큰 노드 찾기 
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key = left.key;
			p.data = left.data;
			if(isLeftChild)
				parent.left = left.left;
			else
				parent.right = left.left;
		}
		return true;
	}
	// node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력 
	private void printSubTree(Node node) {
		if(node != null) {
			printSubTree(node.left);
			System.out.println(node.key + " "+ node.data );
			printSubTree(node.right);
		}
	}
	// 모든 노드를 키 값의 오름차순으로 출력 
	public void print() {
		printSubTree(root);
	}
}
