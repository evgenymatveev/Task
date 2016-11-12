package ru.ematveev.arraydublicate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class ArrayDublicateTest{
	@Test
	public void arrayDublicateTest(){
		ArrayDublicate array = new ArrayDublicate();
		String [] arr = new String []
						{"Света", "Женя", "Кристина", "Женя", "Света", "Маша", "Женя", "Кристина", "Роман"};
		assertThat((array.arrayDublicate(arr)), is(new String[]
						{"Света", "Маша", "Женя", "Кристина", "Роман", null, null, null, null}));

	}
}



	