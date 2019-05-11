// 리스트 
// https://opentutorials.org/module/1335/8715
// https://opentutorials.org/module/1335/8857

public class List {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.addFirst(1);
		al.addFirst(2);
		al.addFirst(3);
		System.out.println(al.toString());
		al.add(2, 4);
		System.out.println(al.toString());
		al.remove(2);
		System.out.println(al.toString());
		
		System.out.println();
		
		LinkedList ll = new LinkedList();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		System.out.println(ll.toString());
		ll.add(2, 4);
		System.out.println(ll.toString());
		ll.remove(2);
		System.out.println(ll.toString());
	}
}

// ArrayList
// ArrayList는 배열을 사용함. 
// 인덱싱은 빠름.
// 추가, 제거는 느림.

class ArrayList {
	// 사이즈 
    private int size = 0;
    // 저장하는 배열 
    // ArrayList는 기본적으로 배열을 사용함. 
    private Object[] elementData = new Object[100];
 
    public ArrayList() {}
     
    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }
    public boolean add(int index, Object element) {
    		// 추가 배열을 사용하지 않도록 뒤에서부터 한칸씩 뒤로땡김. 
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }
    public boolean addFirst(Object element){
        return add(0, element);
    }
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];
            if (i < size - 1)
                str += ",";
        }
        return str + "]";
    }
    public Object remove(int index) {
    		// return을 위해 삭제 대상 저장 
        Object removed = elementData[index];
        // 삭제된 요소 바로 뒤부터 끝까지 하나씩 앞으로 땡김. 
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }   
    public Object removeFirst(){
        return remove(0);
    }
    public Object removeLast(){
        return remove(size-1);
    }
    public Object get(int index) {
        return elementData[index];
    }
    public int size() {
        return size;
    }
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
        		// 첫 번째 요소 만나면 반환  
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }
 
    public ListIterator listIterator() {
        // ListIterator 인스턴스를 생성 후 반환 
        return new ListIterator();
    }
    class ListIterator {
        private int nextIndex = 0;

        public boolean hasNext() {
            return nextIndex < size();
        }
         
        public Object next() {
            return elementData[nextIndex++];
        }
         
        public boolean hasPrevious(){
            return nextIndex > 0;
        }
         
        public Object previous(){
            return elementData[--nextIndex];
        }
         
        public void add(Object element){
            ArrayList.this.add(nextIndex++, element);
        }
         
        public void remove(){
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
         
 
    }
 
}

// LinkedList
// 노드 사용. 
// 인덱스로 탐색 느림.
// 추가, 제거는 빠름.
// 사실 추가/제거 과정에서 해당 노드를 찾아야하므로 n만큼 걸리긴함.

class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;
    
    private class Node{
        private Object data;
        // 다음 노드 
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input){
        // 노드 생성 
        Node newNode = new Node(input);
        // 기존 헤드를 두번째로 설정 
        newNode.next = head;
        // 해당 노드를 헤드로 설정 
        head = newNode;
        size++;
        if(head.next == null){
            tail = head;
        }
    }
    public void addLast(Object input){
        // 노드 생성 
        Node newNode = new Node(input);
        // 리스트가 비어있다면? 
        if(size == 0){
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }
    public void add(int k, Object input){
        // k=0 -> 처음에 추가 
        if(k == 0){
            addFirst(input);
        } else {
        		// k-1 번째 노드 -> temp1 
            Node temp1 = node(k-1);
            // k 번째 노드 -> temp2 
            Node temp2 = temp1.next;
            
            // temp1, temp2 사이에 넣을 노드 생성 
            Node newNode = new Node(input);
            // 둘 사이에 삽입을 위해 next 설정 
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            // 새로운 노드의 다음 노드가 없을 경우 (null) -> tail로 설정 
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }
    public String toString() {
        if(head == null){
            return "[]";
        }       
        Node temp = head;
        String str = "[";
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str+"]";
    }
    public Object removeFirst(){
        // 두번째 노드를 헤드로 설정 
        Node temp = head;
        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    public Object remove(int k){
        if(k == 0)
            return removeFirst();
        // k-1번째 노드 -> temp 
        Node temp = node(k-1);
        // k번째 노드 -> todoDeleted 
        Node todoDeleted = temp.next;

        temp.next = temp.next.next;
        Object returnData = todoDeleted.data; 
        if(todoDeleted == tail){
            tail = temp;
        }
        todoDeleted = null; 
        size--;
        return returnData;
    }
    public Object removeLast(){
        return remove(size-1);
    }
    public int size(){
        return size;
    }
    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
    public int indexOf(Object data){
       
        Node temp = head;
        int index = 0;
        while(temp.data != data){
            temp = temp.next;
            index++;
            if(temp == null)
                return -1;
        }
        return index;
    }
 
    public ListIterator listIterator() {
        return new ListIterator();
    }
     
    class ListIterator{
        private Node lastReturned;
        private Node next;
        private int nextIndex;
         
        ListIterator(){
            next = head;
            nextIndex = 0;
        }
          
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
         
        public boolean hasNext() {
            return nextIndex < size();
        }
         
        public void add(Object input){
            Node newNode = new Node(input);
            if(lastReturned == null){
                head= newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }
         
        public void remove(){
            if(nextIndex == 0){
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
         
    }
 
}