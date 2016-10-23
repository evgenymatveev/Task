
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

public class Main{
					
	public static void main ( String[] args ){

			Point a = new Point();
			Point b = new Point();
			Point c = new Point();

			double area = new Triangle(a, b, c).area();


	}
		
}

