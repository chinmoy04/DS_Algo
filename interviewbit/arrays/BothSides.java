package com.interviewbit.arrays;

import java.util.ArrayList;

public class BothSides {
	
	public static int solve(ArrayList<Integer> A, int B) {
        int sum1 = 0;
        int sum2 = 0;
        int min;
        
        int n = A.size();
        
        for(int i=0; i<n; i++){
            sum1 += A.get(i);
        }
        
        int x=0, y=A.size()-B-1;
        
        for(int i=x; i<=y; i++){
            sum2 += A.get(i); 
        }
        min = sum2;
        x++;
        y++;
        
        while(y < n){
            sum2 -= A.get(x-1);
            sum2 += A.get(y);
            
            min = sum2 < min ? sum2 : min;
            x++;
            y++;
        }
        
        return sum1 - min;
    }
	
	
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(5);
		x.add(-2);
		x.add(100);
		x.add(3);
		x.add(1);
		x.add(2);
		
		int ans = solve(x, 3);
		
		System.out.println(ans);
	}

}
