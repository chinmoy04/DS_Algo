package com.algo.dp;

//Java program to get maximum and minimum
//values of an expression
import java.io.*;
import java.util.*;


public class MinMaxExpr
{

	//Utility method to check whether a character
	//is operator or not
	static boolean isOperator(char op)
	{
		return (op == '+' || op == '*');
	}

	//method prints minimum and maximum value
	//obtainable from an expression
	static void printMinAndMaxValueOfExp(String exp)
	{
		Vector<Integer> num = new Vector<Integer>();
		Vector<Character> opr = new Vector<Character>();
		String tmp = "";

		// store operator and numbers in different vectors
		for (int i = 0; i < exp.length(); i++)
		{
			if (isOperator(exp.charAt(i)))
			{
				opr.add(exp.charAt(i));
				num.add(Integer.parseInt(tmp));
				tmp = "";
			}
			else
			{
				tmp += exp.charAt(i);
			}
		}

		// storing last number in vector
		num.add(Integer.parseInt(tmp));

		int len = num.size();
		int[][] minVal = new int[len][len];
		int[][] maxVal = new int[len][len];

		// initializing minval and maxval 2D array
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				minVal[i][j] = Integer.MAX_VALUE;
				maxVal[i][j] = 0;

				// initializing main diagonal by num values
				if (i == j)
					minVal[i][j] = maxVal[i][j]
							= num.get(i);
			}
		}

		// looping similar to matrix chain multiplication
		// and updating both 2D arrays
		for (int L = 2; L <= len; L++)
		{
			for (int i = 0; i < len - L + 1; i++)
			{
				int j = i + L - 1;
				for (int k = i; k < j; k++)
				{
					int minTmp = 0, maxTmp = 0;

					// if current operator is '+', updating
					// tmp variable by addition
					if (opr.get(k) == '+')
					{
						minTmp = minVal[i][k]
								+ minVal[k + 1][j];
						maxTmp = maxVal[i][k]
								+ maxVal[k + 1][j];
					}

					// if current operator is '*', updating
					// tmp variable by multiplication
					else if (opr.get(k) == '*')
					{
						minTmp = minVal[i][k]
								* minVal[k + 1][j];
						maxTmp = maxVal[i][k]
								* maxVal[k + 1][j];
					}

					// updating array values by tmp
					// variables
					if (minTmp < minVal[i][j])
						minVal[i][j] = minTmp;
					if (maxTmp > maxVal[i][j])
						maxVal[i][j] = maxTmp;
				}
			}
		}

		// last element of first row will store the result
		System.out.print(
				"Minimum value : " + minVal[0][len - 1]
						+ ", Maximum value : " + maxVal[0][len - 1]);
	}

	//Driver code to test above methods
	public static void main(String[] args)
	{
		String expression = "1+2*3+4*5";
		printMinAndMaxValueOfExp(expression);
	}
}


