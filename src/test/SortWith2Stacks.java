package test;

import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stacks {
	  public void sort(LinkedList<Integer> s1) {
		    LinkedList<Integer> s2 = new LinkedList<Integer>();
		    // Write your solution here.
		    if(s1 == null || s1.size() <= 1)return ;
		    sort (s1,s2);
		  }
		  private void sort(Deque<Integer> input, Deque <Integer> buffer){
		    while (!input.isEmpty()){
		      int curMin = input.peek();
		      int count = 0;
		    while(!input.isEmpty()){
		      int cur = input.pollFirst();
		      if (cur < curMin){
		        curMin = cur;
		        count = 1;
		      }else if (cur == curMin){
		        count++;
		      }
		      buffer.offerFirst(cur);
		    }
		    while (!buffer.isEmpty() && buffer.peekFirst() >= curMin){
		      int tmp = buffer.pollFirst();
		      if(tmp != curMin){
		        input.offerFirst(tmp);
		      }
		    }
		    while(count -- > 0){
		      buffer.offerFirst(curMin);
		    }
		    }
		    while(!buffer.isEmpty()){
		      input.offerFirst(buffer.pollFirst());
		    }
		  }
	  
	public static void main(String[] args){
		SortWith2Stacks test = new SortWith2Stacks();
		LinkedList<Integer> s1 = new LinkedList<Integer>();
		s1.addLast(3);
		s1.addLast(21);
		s1.addLast(2);
		s1.addLast(7);
		test.sort(s1);
		for(int i=0; i<s1.size(); i++) {
			System.out.println(s1.pollLast());
		}
	}
	
	
}
