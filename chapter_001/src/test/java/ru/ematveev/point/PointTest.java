package ru.ematveev.point;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class PointTest{

	@Test
	public void distanceToTest(){

		Point a = new Point(5, 2);
		Point b = new Point(5, 8);
		double result = a.distanceTo(b);
		assertThat(result, closeTo(6d, 0.001));
	}

	@Test
	public void areaTest(){

			Point a = new Point(4, 2);
			Point b = new Point(5, 8);
			Point c = new Point(3, 6);
			double result = new Triangle(a, b, c).area();
			assertThat(result, closeTo(5d, 0.001));
	}
}

