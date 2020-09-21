package dataStructure;

public class Remove {
	 public String deDup(String input) {
		   if(input == null || input.length()<=1){
		     return input;
		   }
		   char[] array = input.toCharArray();
		   int end = 0;
		   //instead of using a extra stack, reuse the left side of the original char[] as a stack
		   //end is where the top of stack is
		   for(int i=1; i< array.length;i++){
		     //if the stack is empty,when end = -1 or there is no duplicate chars
		     //we are able to push the character into the stack
		     //empty or new one != top
		   if(end==-1 || array[i] != array[end]){
		     array[end++] = array[i];
		     //otherwise, we need to pop the top element by end--
		     //and ignore all the consecutive duplicate chars
		     // not empty and new one == top
		   }else{
		     end--;
		     while(i+1 < array.length && array[i] == array[i+1] ){
		       i++;
		     }
		   }
		   }
		   return new String(array,0,end+1);
		 }


}
