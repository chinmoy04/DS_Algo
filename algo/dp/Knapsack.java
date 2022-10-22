package com.algo.dp;

public class Knapsack {
	
	private static int max(int i, int j) {
		return i>j? i: j;
	}
	
	private static int knapsack(int W, int n, int val[], int wt[]) {
		int k[][] = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=W; j++) {
				if(i==0 || j==0) {
					k[i][j] = 0;
				}
				
				else if (wt[i-1] <= j) {
					k[i][j] = max(val[i-1] + k[i-1][j-wt[i-1]], k[i-1][j]);
				}
				
				else {
					k[i][j] = k[i-1][j];
				}
			}
		}
		
		return k[n][W];
		
	}

	public static void main(String[] args) {
		int W = 50;
		int wt[] = new int[]{10, 20, 30};
		int val[] = new int[]{60, 100, 120};
		int n = wt.length;
		
		System.out.println(knapsack(W, n, val, wt));

	}

}
