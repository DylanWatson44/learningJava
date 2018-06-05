package test;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import matrix.AdjacencyMatrix;
import traversal.DFS;

@RunWith(value = Parameterized.class)
public class ParameterizedDFS_Test {
	
@Parameter(value=0)
public AdjacencyMatrix inputMatrix;
@Parameter(value=1)
public ArrayList<Integer> desiredList;

@Parameters
public static Collection<Object[]> data(){
	AdjacencyMatrix matrix1 = new AdjacencyMatrix(6);
	matrix1.addEdge(0, 1);
	matrix1.addEdge(0, 2);
	matrix1.addEdge(2, 3);
	matrix1.addEdge(2, 4);		//normal
	matrix1.addEdge(3, 5);
	matrix1.addEdge(4, 5);
	
	AdjacencyMatrix matrix2 = new AdjacencyMatrix(5);
	matrix2.addEdge(0,1);
	matrix2.addEdge(1,2);
	matrix2.addEdge(2,3);		//ring
	matrix2.addEdge(3, 4);
	matrix2.addEdge(0, 4);
	
	AdjacencyMatrix matrix3 = new AdjacencyMatrix(5);
	matrix3.setAllTrue();		//net
		
	ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(0,2,4,5,3,1));
	ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(0,4,3,2,1));
	Object[][] data = new Object[][]{{matrix1, list1}, {matrix2, list2},{matrix3, list2}};//Parameters I want to test
	return Arrays.asList( data );
}
@Test
public void parameterizedTestOfTheDFSMethod(){	
	assertThat(DFS.traverseBTM(0, inputMatrix), is(desiredList));  //can test traverseBTM or TOP, but different desired output lists would be needed for positive result
}
}
