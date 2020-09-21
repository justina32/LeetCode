package dataStructure;
//Use ListNode to implement operations in LinkedList
public class LinkedListOperation {
	public int length(ListNode head) {
		int length = 0;
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	public ListNode get(ListNode head, int index) {
		while(index >0 && head != null) {
			head = head.next;
			index--;
		}
		// index <=0 || head == null
		return head;
	}
	public ListNode appendHead(ListNode head, int value) {
		ListNode newHead = new ListNode(value);
		newHead.next = head;
		return newHead;
	}
	public ListNode appendTail(ListNode head, int value) {
		//1. head == null
		if(head == null) {
			return new ListNode(value);
		}
		//2. head !=null, find the last node in the list
		ListNode prev = head;
		while(prev.next != null) {
			prev = prev.next;
		}
		//exit the while loop when prev.next == null
		prev.next = new ListNode(value);
		return head;
	}
	public ListNode remove(ListNode head, int value) {
		//1. head == null
		if(head == null) {
			return null;
		}else if(head.value == value) { //2. remove head
			return head.next;
		}
		//3.
		ListNode cur = head;
		while(cur.next != null && cur.next.value != value) {
			cur = cur.next;
		}
		//out of the while loop, cur.next == null || cur.next.value == value
		if(cur.next !=null) {
			cur.next = cur.next.next;
		}
		return head;
	}

}
