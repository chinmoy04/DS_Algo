package com.interviewbit.arrays;

import java.util.ArrayList;

public class MinSteps {
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int counter=0;
		int a =0;
		int b=0;
		for(int i=0;i<A.size()-1;i++){
			a = Math.abs(A.get(i) - A.get(i+1));
			b = Math.abs(B.get(i) - B.get(i+1));
			counter = counter + Math.max(a,b);
		}
		
		return counter;
	}

}
