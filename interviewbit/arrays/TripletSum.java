package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

public class TripletSum {
	
	public static int solve(ArrayList<Integer> A) {
	    int maxSum = Integer.MIN_VALUE;
	    if (A.size() < 3) return 0;
	    int[] maxR = new int[A.size()];
	    int max = Integer.MIN_VALUE;
	    for (int i = A.size() - 1; i >= 0; i--) {
	        if (A.get(i) > max) {
	            maxR[i] = A.get(i);
	            max = A.get(i);
	        } else maxR[i] = max;
	    }
	    TreeSet<Integer> maxL = new TreeSet<>();
	    maxL.add(A.get(0));

	    for (int i = 1; i < A.size() - 1; i++) {
	        Integer left = maxL.lower(A.get(i));
	        if (maxR[i + 1] > A.get(i) && left != null) {
	            int sum = A.get(i) + left + maxR[i + 1];
	            if (sum > maxSum) maxSum = sum;
	        }
	        maxL.add(A.get(i));
	    }

	    return maxSum;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(5);
		x.add(2);
		x.add(3);
		x.add(1);
		x.add(4);
		x.add(9);
		
		int ans = solve(x);
		
		System.out.println(ans);
	}

}
