package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader {
	//initialize 
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//Reading Line by Line
	public String readAllLines(BufferedReader reader)throws IOException{
		StringBuilder content = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			content.append(line);
			content.append(System.lineSeparator());
		}
		return content.toString();
	}
	
	//Reading a Single Character
	public String readAllCharsOneByOne(BufferedReader reader)throws IOException{
		StringBuilder content = new StringBuilder();
		int value;
		while((value = reader.read()) != -1) {
			content.append((char)value);
			
		}
		return content.toString();
	}
	
	// Reading Multiple Characters
	public String readMultipleChars(BufferedReader reader)throws IOException{
		int length = 5;  //Initiate this length
		char[] chars = new char[length];
		int charsReader = reader.read(chars,0,length);
		String result;
		if(charsReader != -1) {
			result = new String(chars,0,charsReader);
		}else {
			result = "";
		}
		return result;
	}

	
	//read matrix
	public char[][] readMatrix(BufferedReader reader)throws IOException{
		char[][] grid;
	    String[] words;
	    String[] results;
		// get grid size from reading first line of file
	      int gridSize = Integer.parseInt(reader.readLine());
	       grid = new char[gridSize][gridSize];
	      // construct grid.
	      for (int i = 0; i < gridSize; i++) {
	        int count = 0;
	        for (String character : reader.readLine().split(" ")) {
	          grid[i][count++] = character.toCharArray()[0];
	        }
	      }
	      // read number of words
	      int wordsCount = Integer.parseInt(reader.readLine());
	      words = new String[wordsCount];
	      // construct word array
	      words = reader.readLine().split(" ");
	      return grid;  
	}
}
