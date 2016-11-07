package ru.ematveev.arraysquare;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class ArraySquareTest{
	@Test
	public void arraySquareTest(){
	ArraySquare array = new ArraySquare();
	int [][] arr = new int[][]{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};
	assertThat((array.arraySquare(arr)), is(new int[][]{
		{7, 4, 1},
		{8, 5, 2},
		{9, 6, 3}
	}));
}

}