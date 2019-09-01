package a1;

import java.util.Scanner;

import a1.A1Novice.Customer;

public class A1Adept {

	public static void main(String[] args) {
		
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int count = scan.nextInt();
		
		// create array of all the possible items of length item count
		
		Item[] possibleItems = new Item[count];
		
		// iterate through possibleItems array and create new item at each index
		// read and assign item information 
		
		for (int i=0; i<count; i++) {
			possibleItems[i] = new Item();
			possibleItems[i].setName(scan.next());
			possibleItems[i].setPrice(scan.nextDouble());
		}
		
		// use scan to take in the count of customers 
		
		int cCount = scan.nextInt();
		
		// create a customer array with length of customer count
		
		Customer[] customers = new Customer[cCount];
		
		// iterate through the customer array and create new customer at each index 
		// read and assign customer information 
		
		for (int i=0; i<cCount; i++) {
			customers[i] = new Customer();
			customers[i].setName(scan.next(), scan.next());
			customers[i].setItemsBought(scan.nextInt());
			
			// determine customer price and assign it to the object
			
			
			for (int j=0; j<customers[i].itemsBought; j++) {
				
				// use scan to take in object quantity and name
				
				int q = scan.nextInt(); 
				String n = scan.next(); 
				
				// iterate through the possibleItems array 
				// update customer total price  
			
				for (int k=0; k<count; k++) {
					if (possibleItems[k].name.equals(n)) {
						customers[i].setTotalPrice(q, possibleItems[k].price);
					} 
				}	
			}
		
		}
		
		// all input parsed, so scanner closed.
		
		scan.close();
		
		// initialize max and min variables to be the price and name of the first customer 
		
		double min = customers[0].totalPrice;
		String minN = customers[0].name; 
		double max = customers[0].totalPrice; 
		String maxN = customers[0].name; 
		
		// loop through the customer array and update min and max variables 
		
		for (int i=0; i<cCount; i++) {
			if (customers[i].totalPrice>max) {
				max=customers[i].totalPrice;
				maxN=customers[i].name;
			}
			if (customers[i].totalPrice<min) {
				min=customers[i].totalPrice;
				minN=customers[i].name;
			}
		}
		
		// print information of customers with the max and min total price
		
		System.out.println("Biggest: " + maxN + " (" + String.format("%.2f", max) + ")");
		System.out.println("Smallest: " + minN + " (" + String.format("%.2f", min) + ")");
		
		// initialize total to keep track of the total amount spent by all customers 
		
		double total = 0;
		
		// iterate through customer array and calculate total price 
		
		for (int i=0; i<cCount; i++) {
			total = total + customers[i].totalPrice; 
		}
		
		// calculate the average price 
		
		double avg = total / cCount; 
		
		// print the average value 
		
		System.out.println("Average: " + String.format("%.2f", avg));
		
	}
	
	// Item class stores information about each individual item 
	// class has constructors to set values 
	// Methods defined to update values 
	
	static class Item {
		String name;
		int timesCounted = 0;
		double price;
		int totalQ = 0; 
		int totalQf = 0;
		int customerCount; 
		
		
		 public void setName (String n) {
			 name = n;
		 }
		 
		 public void setPrice (double p) {
			 price = p;
		 }
		 
		 public void updateTotal (int q) {
			 totalQ = totalQ + q;
		 }
		 
		 public void updateCC () {
			 customerCount += 1;
		 }
		 
		 public void updatetc () {
			 timesCounted += 1;
		 }
		 
		 public void updateTotalf (int q) {
			 totalQf = totalQf + q;
		 }
		 
		 public void resetTotalf () {
			 totalQf = 0;
		 }
		 
		 
	}
	
	// Customer class stores information about each customer 
	// has constructors to set values and method to calculate total price
	
	static class Customer {
		String name;
		int itemsBought;
		double totalPrice; 
		Item[] pItems;

		 
		 public void setName (String f, String l) {
			 name = f + " " + l;
		 }
		 
		 public void setItemsBought (int ib) {
			 itemsBought = ib;
		 }
		 
		 public void setTotalPrice (int quantity, double price) {
			 totalPrice = totalPrice + (quantity * price);
		 }
		 
	}
}
