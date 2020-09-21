package test;

public class SearchInShiftedArray {
	 public int search(int[] array, int target) {
		    // Assume no duplicate numbers
		    //reduce search space by half for each iteration
		    if(array == null || array.length == 0){
		      return -1;
		    }
		    int left = 0;
		    int right = array.length-1;
		    while(left < right -1){
		      int middle = left + (right - left)/2;
		      if(array[middle] == target){
		        return middle;
		      }else if(within(target,array[left],array[middle])
		      || (array[middle] < array[right] && !within(target,array[middle], array[right]) )){
		        right = middle;
		      }else{
		        left = middle ;
		      }
		    }
		    if(array[left] == target) return left;
		    if(array[right] == target) return right;
		    return -1;
		  }
		  private boolean within (int target, int left ,int right){

			  return target >= left && target <= right;
		  }
		  public static void main(String args[]) {
			  SearchInShiftedArray test = new SearchInShiftedArray();
			  int[] input =new int[] { 15,1,3,6,10};
			  System.out.println(test.search(input, 10));
		  }
}
