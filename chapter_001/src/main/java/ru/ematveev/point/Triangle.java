package ru.ematveev.point;

import java.lang.Math.*;


public class Triangle {
	public Point a;
	public Point b;
	public Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double area() {
		//calculate the triangle area

		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);

		double d = (ab + bc + ca)/2;
		double s = Math.sqrt(d*(d-ab)*(d-bc)*(d-ca));

		if (s > 0)

			return s;

		else

			return -1;
	}

}