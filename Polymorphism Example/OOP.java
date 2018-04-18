public class OOP {
		
	public static void main(String [] args) {
		
		System.out.println("Hello World");
		
		Automobile car = new Car();
		
		if (car != null) {
			car.printNumWheels();
		}
		
		Semi truck = new Semi();
		
		if (truck != null) {
			truck.printNumWheels();
		}
		
		car.identity();
		
		truck.identity();
	}
}
