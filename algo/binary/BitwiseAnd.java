package com.algo.binary;

public class BitwiseAnd {
	
	public static int bitwiseAnd(int m, int n)
	{
		int count = 0;

		while (m!=n && m!=0)
		{
			// Checking if last bit is set
			if (m!=n)
			{
				m = m >> 1;
				n = n >> 1;
				count++;
			}
		}
		
		return m << count;

	}

	//Driver Code
	public static void main(String[] args)
	{
		int n = 10;
		int m = 15;

		// Function call
		int ans = bitwiseAnd(n, m);
		
		System.out.println(ans);		
	}

}
