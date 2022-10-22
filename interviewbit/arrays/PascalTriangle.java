package com.interviewbit.arrays;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
       // Adding 1 as first element of every row is 1
       res.add(1);
       for (int i = 1; i <= A; i++) {
           res.add((res.get(i - 1) * (A - i + 1)) / (i));
       }
       return res;
    }
}
