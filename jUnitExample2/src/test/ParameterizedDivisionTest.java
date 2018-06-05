package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import example.Division;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */

@RunWith(value = Parameterized.class)
public class ParameterizedDivisionTest {

	//@Parameter attributes should be public.
	@Parameter(value = 0)
	public double x;

	@Parameter(value = 1)
	public double y;

	@Parameter(value = 2)
	public double result;


	//Creating test data.
	@Parameters
	public static Collection<Object[]> data(){

		Object[][] data = new Object[][]{ {10, 2, 4}, {0, 1, 0} };

		return Arrays.asList( data );
	}


	@Test
	public void parameterizedTestOfTheDivisionValue() {

		assertThat( new Division().divide( x, y ), is(result) );
	}
}
