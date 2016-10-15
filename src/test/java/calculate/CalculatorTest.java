package calculate;

import calculate.Calculate;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest{
	@Test
public void testAdd(){

	Calculate calc = new Calculate();
		double result = calc.add(1, 7);
		Assert.assertEquals(result, 8.0);

	}
	@Test
	public void testSubstruct(){

	Calculate calc = new Calculate();
		double result = calc.substruct(8, 3);
		Assert.assertEquals(result, 5.0);

	}
	@Test
	public void testDiv(){

	Calculate calc = new Calculate();
		double result = calc.div(12, 2);
		Assert.assertEquals(result, 6.0);

	}
	@Test
	public void testMultiple(){

	Calculate calc = new Calculate();
		double result = calc.multiple(2, 7);
		Assert.assertEquals(result, 14.0);

	}

}