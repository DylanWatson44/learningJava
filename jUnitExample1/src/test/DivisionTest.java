package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import example.Division;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class DivisionTest {

	@Test
	public void testTheDivisionValue() {

		System.out.println( "\ntestTheDivisionValue" );


		double result = new Division().divide( 6, 0 );

		assertTrue( Double.isInfinite( result ) );
	}
}
