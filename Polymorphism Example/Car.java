public class Car extends Automobile{
	Car(){
		super();
		name = "car";
	}
	
	void identity() {
		System.out.println("I am a " + name + " and I have " + numWheels + " wheels!");
		super.identity();
	}
}
