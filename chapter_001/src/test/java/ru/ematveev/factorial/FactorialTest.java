package ru.ematveev.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class FactorialTest{

@Test
public void factorialTest(){

	Factorial f = new Factorial(6);
	int result = f.factorial();

	assertThat(result, is(720));
}

}