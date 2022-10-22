package com.algo.maths;

public class DirectionOfPoint {



	// structure for point in cartesian plane.
	static class point
	{
		int x, y;
	};

	// constant integers for directions
	static int RIGHT = 1, LEFT = -1, ZERO = 0;

	static int directionOfPoint(point A,
			point B, point P)
	{
		// subtracting co-ordinates of point A
		// from B and P, to make A as origin
		B.x -= A.x;
		B.y -= A.y;
		P.x -= A.x;
		P.y -= A.y;

		// Determining cross Product
		int cross_product = B.x * P.y - B.y * P.x;

		// return RIGHT if cross product is positive
		if (cross_product > 0)
			return RIGHT;

		// return LEFT if cross product is negative
		if (cross_product < 0)
			return LEFT;

		// return ZERO if cross product is zero.
		return ZERO;
	}

	// Driver code
	public static void main(String[] args)
	{
		point A = new point(),
				B = new point(), P = new point();
		A.x = -30;
		A.y = 10; // A(-30, 10)
		B.x = 29;
		B.y = -15; // B(29, -15)
		P.x = 15;
		P.y = 28; // P(15, 28)

		int direction = directionOfPoint(A, B, P);
		if (direction == 1)
			System.out.println("Right Direction");
		else if (direction == -1)
			System.out.println("Left Direction");
		else
			System.out.println("Point is on the Line");
	}
}