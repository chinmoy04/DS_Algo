package com.algo.binary;

//Java program for the above approach
public class Concatenation
{

	// Function to find the decimal value by
	// concatenating the numbers from 1 to N
	static int concatenatedBinary(int n)
	{

		// Stores count of
		// bits in a number
		int l = 0;

		// Stores decimal value by
		// concatenating 1 to N
		int ans = 0;

		// Iterate over the range [1, n]
		for (int i = 1; i < n + 1; i++){

			// If i is a power of 2
			if ((i & (i - 1)) == 0)
				l += 1;

			// Update ans
			ans = ((ans << l) | i);
		}

		// Return ans
		return ans;
	}

	// Driver Code
	public static void main (String[] args)
	{
		int n = 3;

		// Function Call
		System.out.println(concatenatedBinary(n));
	}
}