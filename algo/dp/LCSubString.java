package com.algo.dp;

public class LCSubString {
    public static String longestPalindrome(String s) {
        
        char[] str = s.toCharArray();
        int len = str.length;
        
        boolean T[][] = new boolean[len][len];
        int max = 1;
        int start = 0;
        
        for(int i=0; i<len; i++){
            T[i][i] = true;
        }
        
        for(int i=0; i<len-1; i++){
            if(str[i] == str[i+1]){
                T[i][i+1] = true;
                start = i;
                max = 2;
            }
        }
        
        for(int i=3; i<=len; i++){
            for(int j=0; j<len-i+1; j++){
                int k = i+j-1;
                if(T[j+1][k-1] == true && str[j] == str[k]){
                    T[j][k] = true;                    
                    
                    if(i>max){
                        start = j;
                        max = i;
                    }
                }
            }
        }
        
        return s.substring(start, start+max);
    }
    
    public static void main(String[] args)
    {
 
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalindrome(str));
    }
}
