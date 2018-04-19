//Implementation of the fractional knapsack problem and solution.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class FractionalKnapsack {		
	
	public static void main(String [] args) {
		Item[] items = new Item[5];
		Random rand = new Random();
		Bag bag = new Bag(20);
		
		//Generate Array of items		
		for(int i = 0; i < items.length; i++) {
			items[i] = new Item(1 + rand.nextInt(11),rand.nextInt(11));
			System.out.println("Item[" + i + "] w:" + items[i].weight + " v:" + items[i].value + " d:" + items[i].density);
		}		
		System.out.print("\n");
		
		//Sort descending order
		Arrays.sort(items, new SortByDensity());
				
		//print resulting array.
		for(int i = 0; i < items.length; i++) {
			System.out.println("Item[" + i + "] w:" + items[i].weight + " v:" + items[i].value + " d:" + items[i].density);			
		}
		System.out.print("\n");
		
		for(int i = 0; i < items.length; i++) {
			if (bag.capacity > 0) {							//If there is room in the bag,				
				if (bag.capacity - items[i].weight >=0) {	//if there is room to put the entire object in. do so
					bag.capacity -= items[i].weight;
					bag.value += items[i].value;
				} else {									//Else, fill the remaining space with as much of the object as possible.
					bag.value += bag.capacity * items[i].density;	
					bag.capacity = 0;								
				}
			}
		}
		System.out.println("Bag Capacity remaining:" + bag.capacity + " Bag Value:" + bag.value);		
	}	
}

class Bag {
	double capacity;
	double value;

	Bag(double cap){
		capacity = cap;
		value = 0;
	}
}

class Item {
	double weight;
	double value;
	double density;
	
	Item(double w,double v){
		weight = w;
		value = v;
		density = v / ((w <= 0) ? -1 : w);
	}
}

//Sorts by density in descending order. For ascending order use: {A - B}
class SortByDensity implements Comparator<Item>{
	public int compare(Item a, Item b) {
		if (b.density - a.density == 0)
			return 0;
		return ((b.density - a.density > 0) ? 1:-1);
	}
}