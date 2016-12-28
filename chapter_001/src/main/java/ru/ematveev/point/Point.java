
package ru.ematveev.point;

import java.lang.Math.*;


public class Point {
	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point) {
		//calculate distance between two points

		double l1 = this.x - point.x;
		double l2 = this.y - point.y;


		double l = Math.sqrt(Math.pow(l1, 2) + Math.pow(l2, 2));

		return l;

	}

}
	




