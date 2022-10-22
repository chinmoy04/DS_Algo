package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Rotate90 {
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        
        int n = a.size();
        Collections.reverse(a);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            {
                int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
        
    }
    
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(4);
		
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(5);
		y.add(5);
		y.add(7);
		y.add(8);
		
		ArrayList<Integer> z = new ArrayList<Integer>();
		z.add(9);
		z.add(10);
		z.add(11);
		z.add(12);
		
		ArrayList<Integer> k = new ArrayList<Integer>();
		k.add(13);
		k.add(14);
		k.add(15);
		k.add(16);
		
		arr.add(x);
		arr.add(y);
		arr.add(z);
		arr.add(k);
		
		rotate(arr);
				
	}
}
