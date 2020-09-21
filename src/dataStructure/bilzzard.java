package dataStructure;

public class bilzzard {
	public int[] calculate() {
	int i=0;
	int j=0;
	while(i < 10) {
		while(j < 100) {
			if(j>50) {
				break;
			}
			j++;
		}
		if(i >=5) {
			break;
		}
		i++;
	}
	int [] result = new int[2];
	result[0] = j;
	result[1] = i;
	return result;
	
	}
	public static void main(String[] args) {
		bilzzard test = new bilzzard();
		int[] result = test.calculate();
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		
	}

}
