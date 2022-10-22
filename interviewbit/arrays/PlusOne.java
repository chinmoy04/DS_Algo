package com.interviewbit.arrays;

import java.util.ArrayList;

public class PlusOne {

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int carry = 1;
		int idx = A.size() - 1;
		int rem = 0;
		
		while (idx >= 0) {
			int sum = A.get(idx) + carry;
			
			if (sum > 9) {
				rem = sum%10;
				carry = sum/10;
			}
			else {
				rem = sum;
				carry = 0;
			}
			
			A.set(idx, rem);
			idx--;
		}
		
		if (carry > 0) {
			A.add(0, carry);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		idx = 0;
		
		while (idx < A.size() && A.get(idx) == 0) {
			idx++;
		}
		
		while (idx < A.size()) {
			list.add(A.get(idx++));
		}
		
		return list;

	}

	public static void main(String[] args) {

		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(0);
		x.add(5);
		x.add(2);
		x.add(1);
		x.add(3);
		x.add(1);
		x.add(2);
		x.add(9);

		ArrayList<Integer> ans = plusOne(x);
		// TODO Auto-generated method stub

	}

}
