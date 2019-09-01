package a1;

// import java.util.LinkedList;
import java.util.Scanner;

import a1.A1Adept.Customer;
import a1.A1Adept.Item;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);
		
		// use scan to take in item count
		
		int count = scan.nextInt();
		
		// create item array of length count
		
		Item[] possibleItems = new Item[count];
		
		// iterate through possibleItems array and create new item at each index 
		// for each item use scan to take in and set the name and price 
		
		for (int i=0; i<count; i++) {
			possibleItems[i] = new Item();
			possibleItems[i].setName(scan.next());
			possibleItems[i].setPrice(scan.nextDouble());
		}
		
		// use scan to take in customer count 
		
		int cCount = scan.nextInt();
		
		// create customer array of length customer count 
		
		Customer[] customers = new Customer[cCount]; 
		 
		// iterate through customers array and create new customer object at each index 
		// use scan to take in and set each customer's name and number of item's bought 
		
		for (int i=0; i<cCount; i++) {
			customers[i] = new Customer();
			customers[i].setName(scan.next(), scan.next());
			customers[i].setItemsBought(scan.nextInt());
			
			// initialize variable to hold current item quantity and name that 
	
			int temp = 0;
			String tempN;
			
			
			 for (int j=0; j<customers[i].itemsBought; j++) {
				temp = scan.nextInt();
				tempN = scan.next();
				
				// iterate through the possibleItems array 
				// if the name(tempN) matched the name of the item at that index, update the total 
				// to be the previous total plus the quantity of that item bought (temp)
				// also update the fluctuating total in the same way 
				
				for (int k=0; k<possibleItems.length; k++) {
					if (possibleItems[k].name.equals(tempN)) {
						possibleItems[k].updateTotal(temp);
						possibleItems[k].updateTotalf(temp);
							
					}
				} 
				
			}
			
			 // iterate through the possible items array 
			 // if the fluctuating total is now greater than zero, then the quantity has been updated for this customer 
			 // Update the customer count for that item and then reset the fluctuating total to zero 
			 
			 for (int k=0; k<possibleItems.length; k++) {
					if (possibleItems[k].totalQf>0) {
						possibleItems[k].updateCC();
						possibleItems[k].resetTotalf();
					}
				
				}
			 
		}
		
		// all input parsed, so scanner closed. 
		scan.close();
		
		// iterate through the possibeItems array and determine whether each item has been bought 
		// if customer count is 0, then has not been bought and can print that statement 
		// if customer count > 0, then the item has been bought 
		// print the necessary information about the item at that index
		
		for (int i=0; i<possibleItems.length; i++) { 
			if (possibleItems[i].customerCount == 0) {
				System.out.println("No customers bought " + possibleItems[i].name);
			} else {
				System.out.println(possibleItems[i].customerCount + " customers bought " + possibleItems[i].totalQ + " " + possibleItems[i].name);
			}
		}
		
		
	} 
		
	
	}

