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
		
		// loop through array of possible items
		// at each index create new item 
		// for each item use scan to take in and set the name and price 
		
		for (int i=0; i<count; i++) {
			possibleItems[i] = new Item();
			possibleItems[i].setName(scan.next());
			possibleItems[i].setPrice(scan.nextDouble());
		}
		
		// use scan to take in the count of customers 
		
		int cCount = scan.nextInt();
		
		// create a customer array with length of customer count
		
		Customer[] customers = new Customer[cCount];
		
		// loop through the customer array 
		// at each index create a new customer 
		// for each customer use scan to take in and set their name in items bought 
		
		for (int i=0; i<cCount; i++) {
			customers[i] = new Customer();
			customers[i].setName(scan.next(), scan.next());
			customers[i].setItemsBought(scan.nextInt());
			
			// determine customer price and assign it to the object
			
			
			for (int j=0; j<customers[i].itemsBought; j++) {
				
				// use scan to take in object quantity and name
				
				int q = scan.nextInt(); 
				String n = scan.next(); 
				
				// loop through the possible items array 
				// if the name of the possible item matches the name of n, then use set total price method to 
				// calculate the price of that item and add it to the customer's total 
			
				for (int k=0; k<count; k++) {
					if (possibleItems[k].name.equals(n)) {
					customers[i].setTotalPrice(q, possibleItems[k].price);
					} 
				}	
			}
			
		
		
		
		// use for loop to loop through the customers and find who has the min and max total price
		// same for loop can determine the customer avg price
		
		}
		
		// all input parsed, so scanner closed.
		
		scan.close();
		
		// initialize max and min variables to be the price and name of the first customer 
		
		double min = customers[0].totalPrice;
		String minN = customers[0].name; 
		double max = customers[0].totalPrice; 
		String maxN = customers[0].name; 
		
		// loop through the customer array 
		// is the total price for that customer is greater than the max or less than the min then update the variable's values 
		
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
		
		// iterate through customer array and add their total price to total 
		
		for (int i=0; i<cCount; i++) {
			total = total + customers[i].totalPrice; 
		}
		
		// calculate the average price by dividing total by the customer count
		
		double avg = total / cCount; 
		
		// print the average value 
		
		System.out.println("Average: " + String.format("%.2f", avg));
		
	}
	
	// Create item class to store information about each individual item (name, price, times counted, how many customers bought...)
	// class has constructors to set values 
	// class has methods to update customer count, the times counted, and the fluctuating total
	
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
	
	// Customer array keeps track of information about each customer (name, items bought, total price)
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
