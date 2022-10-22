package com.algo.binary;

//Java program of the above approach
import java.io.*;

public class PowerOfTwo {
	
	public static double log2(int N)
    {
  
        // calculate log2 N indirectly
        // using log() method
        double result = Math.log(N) / Math.log(2);
  
        return result;
    }

	// Function to check if x is power of 2
	static boolean isPowerofTwo(int n)
	{
		if (n == 0)
			return false;
		//if ((n & (~(n - 1))) == n)
		//	return true;
		
		if(Math.floor(log2(n)) == Math.ceil(log2(n)))
			return true;
		
		return false;
	}
	
	public static void main(String[] args)
	{
		if (isPowerofTwo(30) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

		if (isPowerofTwo(128) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
