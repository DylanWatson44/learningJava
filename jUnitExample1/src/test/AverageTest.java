package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import example.Average;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class AverageTest {

	@Test
	public void testTheAverageValue() {

		//System.out.println( "\ntestTheAverageValue" );


		double[] x = new double[]{ 6, 6 };

		double result = new Average().calculate( x );

		assertTrue( result == 6 );
	}
}
