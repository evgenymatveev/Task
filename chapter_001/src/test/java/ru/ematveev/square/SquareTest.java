package ru.ematveev.square;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class SquareTest{

	@Test
	public void calculate(){

		Square square = new Square(2, 3, 4);
		
		double result = square.calculate(2);

		assertThat(result, closeTo(18d, 0.001));

	}

}