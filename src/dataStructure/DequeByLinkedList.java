package dataStructure;

public class DequeByLinkedList {
	private DoublyListNode head;
	private DoublyListNode tail;
	int size = 0;
	public DequeByLinkedList() {
		head = tail = null;
	}
	
	public void offerFirst(int ele) {
		DoublyListNode newNode = new DoublyListNode(ele);
		if(head == null) {
			head = newNode;
			tail = head;			
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = head.prev;
		}
		size++;		
	}
	
	public void offerLast(int ele) {
		DoublyListNode newNode = new DoublyListNode(ele);
		if(head == null) {
			tail = newNode;
			head = tail;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;			
		}
		size++;
	}
	public Integer pollFirst() {
		if(head == null) {
			return null;
		}
			DoublyListNode cur = head;
			head = head.next;
			if(head == null) {
				tail = null;
			}else {
				head.prev = null;
						
			}
			cur.next = null;
			size--;
			return cur.value;
	
	}
	public Integer pollLast() {
		if(tail == null) {
			return null;
		}
			DoublyListNode cur = tail;
			tail = tail.prev;
			if(tail == null) {
				head = null;
			}else {
				tail.next = null;
						
			}
			cur.prev = null;
			size--;
			return cur.value;
	}

	public Integer peekFirst() {
		if(head == null) {
			return null;
		}
		return head.value;
	}
	public Integer peekLast() {
		if(tail == null) {
			return null;
		}
		return tail.value;
	}
	
	public int size() {
		return size;
		
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public static void main(String[] args) {
		DequeByLinkedList deque = new DequeByLinkedList();
		deque.offerFirst(1);
		deque.offerLast(2);
		deque.offerFirst(3);
		deque.offerLast(4);
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		deque.pollFirst();
		deque.pollLast();
		deque.pollFirst();
		System.out.println(deque.pollFirst());
		System.out.println(deque.size());
		System.out.println(deque.isEmpty());
		System.out.println(deque.pollFirst());
		System.out.println(deque.peekLast());
	}

}
