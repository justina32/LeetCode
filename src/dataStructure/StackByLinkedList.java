package dataStructure;

public class StackByLinkedList {
	int size = 0;
	private ListNode head;
	
	public void offer(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		size++;
		head = newNode;
	}
	public Integer poll() {
		if(head == null) {
			return null;
		}
		ListNode prev = head;
		head = head.next;
		prev.next = null;
		size --;
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
	  return head == null;
	}
   public static void main (String[] args){
	   StackByLinkedList stack = new StackByLinkedList();
	   stack.offer(1);
	   stack.offer(2);
	   stack.offer(3);
	   System.out.println(stack.poll());
	   System.out.println(stack.peek());
	   System.out.println(stack.size());
	   System.out.println(stack.isEmpty());
	   
   }
}
