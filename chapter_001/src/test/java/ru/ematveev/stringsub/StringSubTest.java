package ru.ematveev.stringsub;



import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class StringSubTest{
	@Test
	public void containsTest(){
		StringSub d = new StringSub();
		assertThat(d.contains("Светлана", "dве"), is(false));
		assertThat(d.contains("Светлана", "етла"), is(true));
	}
}