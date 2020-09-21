package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
	public String decode(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		Deque<String> strStack = new ArrayDeque<>();
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				sb.append(c);
			}else if(c >= '0' && c <= '9') {
				count = count * 10 + c -'0';
			}else if( c == '(') {
				if(sb.length() != 0) {
				 strStack.push(sb.toString());
				 sb.setLength(0);				 
				}
			}else if(c =='}') {
				if(count > 0) {
					StringBuilder tmp = new StringBuilder();
					String temp = strStack.pop();
					for(int n=0; n< count; n++) {
						result.append(temp);
					}
					count = 0;
					
					
				}
			}
		}
		return result.toString();
	}
	public static void main(String[] args) {
		DecodeString test = new DecodeString();
		String s = "(ab(d){3}){2}";
		System.out.println(test.decode(s));
	}

}
