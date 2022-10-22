package com.algo.strings;

public class ReverseString {
	
	public static char[] reverse(char[] iStr) {
		
		char[] res = iStr;
		if(iStr.length == 0) {
			System.out.println("Invalid input");
			return null;
		}
		
		int front = 0;
		int back = iStr.length-1;
		
		while(front <= back) {
			char temp = res[front];
			res[front] = res[back];
			res[back] = temp;
			front++;
			back--;
		}
				
		return res;		
	}
	
	public static void main(String[] args) {
		
		char[] iStr = {'C','a','t'};
		char[] iStr1 = {'T','h','e',' ','D','a','i','l','y',' ','B','y','t','e'};
		String iStr2 = "Civic";
		reverse(iStr);
		reverse(iStr1);		
		System.out.println(iStr);
		System.out.println(iStr1);
		System.out.println(reverse(iStr2.toCharArray()));
	}

}
