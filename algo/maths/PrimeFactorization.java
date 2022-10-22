package com.algo.maths;

import java.util.*;

public class PrimeFactorization {
	
	public static void primeFactors(int n)
	{
		int c = 2;
		while (n > 1) {
			if (n % c == 0) {
				System.out.print(c + " ");
				n /= c;
			}
			else
			{
				c++;
			}				
		}
	}

	/* Driver code */
	public static void main(String[] args)
	{
		int n = 315;
		primeFactors(n);
	}
}
