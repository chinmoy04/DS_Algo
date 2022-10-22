package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {


	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		int ROW = A.size();
		int COL = A.get(0).size();

		ArrayList<Integer> sol = new ArrayList<Integer>();

		int dir = 0;
		int i=0, j=COL-1, k=ROW-1, l=0;

		while(i <= k && l <= j){
			if(dir == 0){
				for(int x=l; x<=j; x++){
					System.out.println(A.get(i).get(x));
					sol.add(A.get(i).get(x));
					//dir = 1;
					
				}
				i++;
			}

			else if(dir == 1){
				for(int x=i; x<=k; x++){
					System.out.println(A.get(x).get(j));
					sol.add(A.get(x).get(j));
					//dir = 2;
					
				}
				j--;
			}

			else if(dir == 2){
				for(int x=j; x>=l; x--){
					System.out.println(A.get(k).get(x));
					sol.add(A.get(k).get(x));
					//dir = 3;
					
				}
				k--;
			}

			else if(dir == 3){
				for(int x=k; x>=i; x--){
					System.out.println(A.get(x).get(l));
					sol.add(A.get(x).get(l));
					//dir = 0;
					
				}
				l++;
			}

			dir = (dir+1)%4;
		}

		return sol;
	}




	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(4);
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(5);
		y.add(6);
		y.add(7);
		y.add(8);
		ArrayList<Integer> z = new ArrayList<Integer>();
		z.add(9);
		z.add(10);
		z.add(11);
		z.add(12);
		
		List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(x);
		A.add(y);
		A.add(z);
		
		ArrayList<Integer> sol = spiralOrder(A);

	}

}
