package dataStructure;

import java.util.NoSuchElementException;

/**
 * capacity limited min-heap containing only int values
 * this is for demonstration of percolateUp/percolate Down methods and how to
 * utilize these methods to do basic heap operations
 * the public methods are
 * size()
 * isEmpty()
 * isFull()
 * peek()
 * poll()
 * offer()
 * update(int index, int value)- update the element at index to a given new value
 * @author justina32
 *
 */
public class Heap {
	private int[] array;
	private int size;
	public Heap(int[] array) {
		if(array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	private void heapify() {
		//non-leaf node needs heapify()
		for(int i = size/2-1; i>=0; i--) {
			percolateDown(i);
		}
	
	}
	public Heap(int cap) {
		if(cap <=0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
		}
		array = new int[cap];
		size = 0;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == array.length;
	}
	private void percolateUp(int index) {
		//element needs to be moved up to maintain property
		//when offering a new element into the heap
		while(index>0) {
			int parentIndex = (index-1)/2;
			if(array[parentIndex] > array[index]) {
				swap(array, parentIndex, index);
			}else {
				break;
			}
			index = parentIndex;
		}
		
	}
	private void percolateDown(int index) {
		//check if index is legal
		while(index <= size/2-1) {
			int leftChildIndex = index*2+1;
			int rightChildIndex = index*2+2;
			//smallest one among left and right child
			int swapCandidate = leftChildIndex;
			//update swapCandidate if right child exists and it is smaller than left child
			if(rightChildIndex <= size-1 && array[leftChildIndex]>= array[rightChildIndex]) {
				swapCandidate = rightChildIndex;
			}
			//swap if necessary
			if(array[index] > array[swapCandidate]) {
				swap(array, index, swapCandidate);
			}else {
				break;
			}
			index = swapCandidate;
		}		
	}
	private void swap(int[]array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public int peek() {
		if(size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}
	public int poll() {
		if(size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int result = array[0];
		array[0] = array[size-1];
		size--;
		percolateDown(0);
		return result;
	}
	public void offer(int ele) {
		if(size == array.length) {
			int[] newArray = new int[array.length*2];
//			copy(array, newArray);
			array = newArray;
		}
		array[size] = ele;
		size++;
		percolateUp(size-1);
	}
	public int update(int index, int ele) {
		if(index <0 || index > size-1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int result = array[index];
		array[index] = ele;
		if(result > ele) {
			percolateUp(index);
		}else {
			percolateDown(index);
		}
		return result;
	}
}
