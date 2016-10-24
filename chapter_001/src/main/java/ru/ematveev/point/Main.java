package ru.ematveev.point;

public class Main{
					
	public static void main ( String[] args ){

			Point a = new Point(4, 2);
			Point b = new Point(5, 3);
			Point c = new Point(2, 7);

			double area = new Triangle(a, b, c).area();


	}
		
}