package test;

public class SearchInShiftedArrayII {
	  public int search(int[] array, int target) {
		    if(array == null || array.length == 0){
		      return -1;
		    }
		    int left = 0;
		    int right = array.length-1;
		    while(left < right -1){
		      int middle = left + (right - left)/2;
		      if(array[middle] == target){
		        return middle;
		      }
		      if(array[left] == target) {
		    	  return left;
		      }
		      if(array[right] == target) {
		    	  return right;
		      }
		      
		      if(within(target,array[left],array[middle])
		      || (array[middle] < array[right] && !within(target,array[middle], array[right]) )){
		        right = middle;
		    }else if((within(target,array[middle], array[right]) && array[middle] < array[right])
		    ||( array[left] < array[middle] && !within(target,array[left], array[middle]))){
		      left = middle;
		    }else{
		      left ++;
		      right --;
		    }
		  }
		  if(array[left] == target){
		    return left;
		  }
		  if(array[right] == target){
		    return right;
		  }
		  return -1;
		}
		private boolean within(int target, int left, int right){
		  return target>=left && target<=right;
		}
		 public static void main(String args[]) {
			  SearchInShiftedArrayII test = new SearchInShiftedArrayII();
			  int[] input =new int[] { 3,1,1};
			  System.out.println(test.search(input, 3));
		  }
}
