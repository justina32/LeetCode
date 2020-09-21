package test;

public class Chest {
	public void printChest(int n){
		if(n <= 0){
		   return;
		}
	    for(int i=0; i<n; i++){
	       for(int j=0; j<n ; j++){
	          if(i%2 == 0 && j%2 == 0 ){
	              if(j != n-1){
	                System.out.print("W" + " ");
	              }else{
	                System.out.print("W");
	              }
	          }else{
	              if(j != n-1){
	                  System.out.print("B" + " ");
	              }else{
	                  System.out.print("B");
	              }
	          }
	       }
	       System.out.println();
	    }
	}
public static void main (String args[]) {
	Chest chest = new Chest();
	chest.printChest(5);
}

}
