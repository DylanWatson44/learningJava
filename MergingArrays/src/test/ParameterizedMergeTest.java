package test;


import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


import method.Merging;



public class ParameterizedMergeTest {
	@Parameter(value = 0)
	public int[] x;

	@Parameter(value = 1)
	public int[] y;

	@Parameter(value = 2)
	public int[] result;
	@Parameters
	public static Collection<Object[]> data(){

		Object[][] data = new Object[][]{ {new int[]{1,3,5}, new int[]{2,4}, new int[]{1,2,3,4,5}}};

		return Arrays.asList( data );
	}
	@Test
	public void parameterizedTestOfTheMerging() {
int[] thing = Merging.sortTheArrays(x, y);
Assert.assertArrayEquals("The arrays are not equal", thing, result);
	}
}
