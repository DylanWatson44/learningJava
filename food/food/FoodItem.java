
package food;

public class FoodItem {
/** insert documentation here*/
	
	private String description; 
	private double size;
	private double cents;
	public FoodItem(String descP, int sizeP, double centP){
		size = sizeP;
		cents = centP;
		description = descP;
	}
	
	
	
	public void setSize(int sizeP){
		size = sizeP;}
	
	public void setCents(double centP){
		cents = centP;}
	
	public void setDesc(String descP){
		description = descP;
		;}	 //setters
	
	public double getSize(){
		return size;}
	
	public String getDesc(){
		return description;}
	
	public double getCents(){
		return cents;}
	 						//getters
	public double calcUnitPrice(){
		double pricepergram= size/cents;
		return pricepergram;
	}
	
public String toString(){
		String s="food item: " + description+ " " 
+ size + " grams, $" + (cents/100) + ", $" + (calcUnitPrice()/100) + " per gram";
		return s;
	}
		
		
}



