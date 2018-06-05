package pack;

public class cosFunction {
	private static Double parent = 0.00;
	private static Double child = 0.00;
	
	
public static Double findx(Double x){
	Double output = 0.0000;
	for(int i=1;i<6;i++){
		output+= i*Math.cos((i+1)*x +i);
	}
	
	return output;
	
}


public static void main(String[] args) {
	for(int i = 0; i<10;i++){
	Double input = (Double)(Math.random()*19 -10);
	parent = input;
	System.out.println("input value = " + parent);
	long time = System.currentTimeMillis();
	while(System.currentTimeMillis() - time <3000){
		Double mutationAmount = (Double)(Math.random()*10 - 5);
		child = parent + mutationAmount;
		if(findx(child)>findx(parent)){
			parent =child;
		}
		//System.out.println(findx(parent));
	}
	System.out.println("Input value was " + input + " The final x result " + findx(parent) + " the final input was " + child);
	}
}

}
