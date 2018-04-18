public class Automobile {
	String name;
	int numWheels;
	
	Automobile(){
		name = "generic vehicle";
		numWheels = 4;
	}
	
	void printNumWheels() {		
		System.out.println("This " + name + " has " + numWheels + " wheels.");
	}
	
	void identity() {
		System.out.println("I am an Automobile!");
	}
}
