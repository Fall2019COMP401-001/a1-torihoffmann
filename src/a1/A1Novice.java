package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// read customer count and create a customer array of that length
		
		int count = scan.nextInt();
		
		Customer[] customers = new Customer[count];
		
		// loop through the customer array 
		// for each customer, use scan to take in their first name, last name, and number of items bought
		// use methods defined in the customer class to set each of these values.
		// create an item array for each of the customers that is the length of the number of items they bought 
		
		
		for (int i=0; i<count; i++) {
			customers[i] = new Customer();
			customers[i].setFirst(scan.next());
			customers[i].setLast(scan.next());
			customers[i].setItemsBought(scan.nextInt());
			Item[] items = new Item[customers[i].itemsBought];
			
			// loop through each customers item array 
			// create a new item at each index
			// for that item use scan to take in the quantity, name, and price of that item and assign them to the item object 
			// calculate the customers total cost to the customer by adding the items price to the former total cost of the customer 
			// the items price is calculated by calling a method defined in the items class 
			
			for (int j=0; j<customers[i].itemsBought; j++) {
				items[j] = new Item();
				items[j].setQ(scan.nextInt());
				items[j].setType(scan.next());
				items[j].setPrice(scan.nextDouble());
				customers[i].totalCost = customers[i].totalCost + items[j].calcTotalPrice();
			}
			
			// print the customers name along with the total price calculated
			
			System.out.println(customers[i].first.charAt(0) + ". " + customers[i].last + ": " + String.format("%.2f", customers[i].totalCost));
		}
		
		// all input parsed, so scanner closed. 
		
		scan.close();
		
		
			
		
	}
	
	// customer class keeps track of customer's name, number of items bought and total cost
	// it has constructors for reach of these values 

	static class Customer {
		 String first;
		 String last;
		 int itemsBought;
		 double totalCost=0; 
		 
		
		 public void setFirst (String fir) {
			 first = fir;
		 }
		 
		 public void setLast (String las) {
			 last = las;
		 }
		 
		 public void setItemsBought (int ib) {
			 itemsBought = ib;
		 }
		 
		 
	 }
	
	// Item class keeps track of the quantity, name and price of each numbers
	// it has constructors defined for each of its values 
	// it also has a method defined to calculate the total price that an item will cost by multiplying the price by quantity 
	 
	 static class Item {
		 int quantity; 
		 String type; 
		 double price;
		 
		 public void setQ (int q) {
			 quantity = q;
		 }
		 
		 public void setType (String ty) {
			 type = ty;
		 }
		 
		 public void setPrice (double p) {
			 price = p;
		 }
		 
		 public double calcTotalPrice () {
			 return quantity*price;
		 }
	 }
	
}
