package ru.ematveev.mergesort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class MergeSortTest{
	@Test
	public void mergeSortTest(){
		MergeSort m = new MergeSort();
		int[] a = new int[]{1, 2, 3, 10, 65};
		int[] b = new int[]{10, 20, 30};
		assertThat((m.mergeSort(a, b)), is(new int[]{1, 2, 3, 10, 10, 20, 30, 65}));
	}
}		





		