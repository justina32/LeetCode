package test;

public class KCloset {
	 public int[] kClosest(int[] array, int target, int k) {
		    // Write your solution here
		    if(array==null || array.length == 0){
		      return new int[0];
		    }
		    int left= 0;
		    int right = array.length-1;
		    while(left < right-1){
		      int mid = left + (right - left)/2;
		      if(array[mid]>= target){
		        right = mid;
		      }else{
		        left = mid;
		      }
		    }
		    int[] result = new int[k];
		    for(int i=0; i<k;i++){
		      if(( right>=array.length || left >= 0 && (Math.abs(array[left]-target) <= Math.abs(array[right] - target) ) )){
		        result[i] = array[left];
		        left--; 
		      }else{
		       result[i] = array[right];
		        right++;
		      }
		    }
		    return result;
		  }
	 public static void main(String args[]){
		 KCloset test = new KCloset();
		 int[] array = new int[]{1,5};
		
		int[] result = test.kClosest(array, 10, 1);
		for (int i=0; i<result.length;i++) {
			System.out.println(result[i]);
		}
	 }
}

