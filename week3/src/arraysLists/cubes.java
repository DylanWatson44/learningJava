package arraysLists;

import java.util.ArrayList;

import ecs100.UI;

public class cubes {

	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<Integer>();
		ArrayList<Integer> cubes = new ArrayList<Integer>();
		for(int i =0; i <=1000; i++){
			squares.add(i*i);
			cubes.add(i*i*i);
		}
for(int j = squares.size()-1; j>=0; j--){
	UI.printf( "%3d  %6d  %9d%n",j,squares.get(j),cubes.get(j));
}
	}

}
