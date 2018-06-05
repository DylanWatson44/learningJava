package example;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class Average {

	public double calculate( double[] x ){

		double sum = 0.0;

		for( int i = 0; i < x.length; ++i ) sum += x[ i ];

		return sum/(double)x.length;
	}
}
