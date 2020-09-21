package test;

public class FindCombinations {
	public int findCombinations(int[] array, int target){
		if(array.length <3) {
			return 0;
		}
		
		  int result = 0;
		   
		   for(int i = 0; i<array.length-2 ; i++){
		            for (int j = i+1, k=array.length-1; j<k; ){
		                     if(array[i] + array[j] + array[k] < target){
		                               j++;
		                     }else if(array[i] + array[j] + array[k] > target){
		                              k--;
		                     }else{ // == target		           
		                             result ++;
		                             if(j+1 < k && array[j] == array[j+1]) {
		                            	 j++;
		                             }else if(k-1 > j && array[k] == array[k-1]) {		                             
		                             k--;
		                             }else {
		                            	 j++;
		                            	 k--;
		                             }
		                     }
		                    
		            }
		   }
		  return result;
		}  
public static void main(String[] args) {
	FindCombinations fc = new FindCombinations();
	int[] array = new int[] {1, 1, 2, 2, 4, 5};
	int target = 7;
	System.out.println(fc.findCombinations(array, target));
	
}

}
