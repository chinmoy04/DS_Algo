package com.interviewbit.arrays;

import java.util.ArrayList;

public class MaxSubArray {
	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		
		int start = 0;
		int end = -1;
		long sum = 0;
		long maxsum = Long.MIN_VALUE;
		int maxStart = 0;
		int maxEnd = -1;
		for(int i = 0; i<A.size();i++){
			if(A.get(i)>=0){
				end++;
				sum+=A.get(i);
			}
			else{
				start = i+1;
				end = i;
				sum = 0;
			}
			if(sum > maxsum){
				maxsum = sum;
				maxStart = start;
				maxEnd = end;
			}
			else if(sum == maxsum){
				if((end-start) > (maxEnd-maxStart)){
					maxEnd = end;
					maxStart = start;
				}

			}
		}
		ArrayList<Integer> res = new ArrayList<>();

		if(maxsum < 0 || (maxEnd < maxStart))
			return res;
		for(int i = maxStart; i<=maxEnd;i++){
			res.add(A.get(i));
		}
		
		return res;
	}
}
