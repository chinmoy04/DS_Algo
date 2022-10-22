package com.algo.maths;

//Java implementation to check
//if a straight line can be
//formed using N points
import java.util.*;

public class StraightLine{

	static class pair
	{
		int first, second;
		pair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
	}

	//Function to check if a straight line
	//can be formed using N points
	static void isStraightLinePossible(
			ArrayList<pair> arr, int n)
	{

		// First pair of point (x0, y0)
		int x0 = arr.get(0).first;
		int y0 = arr.get(0).second;

		// Second pair of point (x1, y1)
		int x1 = arr.get(1).first;
		int y1 = arr.get(1).second;

		int dx = x1 - x0, dy = y1 - y0;

		// Loop to iterate over the points
		for(int i = 0; i < n; i++)
		{
			int x = arr.get(i).first;
			int y = arr.get(i).second;
			if (dx * (y - y1) != dy * (x - x1))
			{
				System.out.println("NO");
			}
		}
		System.out.println("YES");
	}

	//Driver code
	public static void main(String[] args)
	{

		// Array of points
		ArrayList<pair> arr = new ArrayList<>();
		arr.add(new pair(0, 0));
		arr.add(new pair(1, 1));
		arr.add(new pair(3, 3));
		arr.add(new pair(2, 2));

		int n = 4;

		// Function Call
		isStraightLinePossible(arr, n);
	}
}