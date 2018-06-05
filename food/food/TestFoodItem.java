
package food;


public class TestFoodItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	double flourpri;


	FoodItem flour = new FoodItem("flour", 500, 40);
	System.out.println(flour.toString());
	
	flourpri = 2*(flour.getCents());
	flour.setCents(flourpri);
	//FoodItem flour2 = new FoodItem("flour", 500, flourpri);
	System.out.println(flour.toString());
	//newflour = flour.setCents(flourpri);
	
	//System.out.println(flourpri);
	
	
	FoodItem vanilla = new FoodItem("vanilla", 30, 5);
	System.out.println(vanilla.toString());
	}

}
