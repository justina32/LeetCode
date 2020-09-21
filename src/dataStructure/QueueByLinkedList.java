package dataStructure;

public class QueueByLinkedList {
	private ListNode head;
	private ListNode tail;
	int size = 0;
	public QueueByLinkedList() {
		head = tail = null;
	}
	public void offer(int value) {
		if(head == null) {
			head = new ListNode(value);
			tail = head;
		}else {
			ListNode newNode = new ListNode(value);
			tail.next = newNode;
			tail = newNode;
		}	
		size++;
	}
	public Integer poll() {
		if(head == null) {
			return null;
		}
		ListNode prev = head;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		prev.next = null;
		size--;
		return prev.value;
		
	}
	public Integer peek() {
		if(head == null) {
			return null;
		}
		return head.value;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public static void main (String[] args){
		   QueueByLinkedList queue = new QueueByLinkedList();
		   queue.offer(1);
		   queue.offer(2);
		   queue.offer(3);
		   System.out.println(queue.poll());
		   System.out.println(queue.peek());
		   System.out.println(queue.size());
		   System.out.println(queue.isEmpty());		   
	   }

}
