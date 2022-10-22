package com.algo.binary;

import java.io.*;

public class ToggleBits
{
	// Function to toggle bits in the given range
	static int toggleBitsFromLToR(int n, int l, int r)
	{
		// calculating a number 'num' having 'r'
		// number of bits and bits in the range l
		// to r are the only set bits
		//int num = ((1 << r) - 1) ^ ((1 << (l - 1)) - 1);

		// toggle bits in the range l to r in 'n'
		// and return the number
		//Besides this, we can calculate num as: num=(1<<r)-l .
		//return (n ^ num);
		
		
		int value = 0;
		int mask = 1;
		int idx = 1;
		int power = 0;
		
		while(idx<l) {
			if((mask & n) > 0) {
				value += Math.pow(2, power);
			}
			idx++;
			power++;
			mask = mask << 1;
		}
		
		while(idx <= r) {
			if(!((mask & n) > 0)) {
				value += Math.pow(2, power);
			}
			idx++;
			power++;
			mask = mask << 1;
		}
		
		while(idx<=10) {
			if((mask & n) > 0) {
				value += Math.pow(2, power);
			}
			idx++;
			power++;
			mask = mask << 1;
		}
		
		return value;
	}

	// driver program
	public static void main (String[] args)
	{
		int n = 50;
		int l = 2, r = 5;
		System.out.println(toggleBitsFromLToR(n, l, r));
	}
}

