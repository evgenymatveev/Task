package ru.ematveev.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CalculatorTest{
		@Test
		public void testAdd(){

				Calculate calc = new Calculate();
				calc.add(1,7);
				double result = calc.getResult();
				assertThat(result, is(8d);

	}
		@Test
		public void testSubstruct(){

				Calculate calc = new Calculate();
				calc.substruct(8,3);
				double result = calc.getResult();
				assertThat(result, is(5d);

	}
		@Test
		public void testDiv(){

				Calculate calc = new Calculate();
				calc.div(12,2);
				double result = calc.getResult();
				assertThat(result, is(6d));

	}
		@Test
		public void testMultiple(){

				Calculate calc = new Calculate();
				calc.multiple(2,7);
				double result = calc.getResult();
				assertThat(result, is(14d));

	}

}