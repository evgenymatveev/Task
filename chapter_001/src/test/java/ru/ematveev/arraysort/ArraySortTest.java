package ru.ematveev.arraysort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class ArraySortTest{
		@Test
		public void arraySortTest(){
			ArraySort array = new ArraySort();
			int [] arr = new int[]{23, 8, 5, 9, 2};
			assertThat((array.arraySort(arr)), is(new int[]{2, 5, 8, 9, 23}));
		}
}