public class Semi extends Automobile{
		
	Semi(){
		name = "Semi-Truck";
		numWheels = 16;
	}
	
	void identity() {
		System.out.println("I am a " + name + " and I have " + numWheels + " wheels!");
		super.identity();
	}	
}
