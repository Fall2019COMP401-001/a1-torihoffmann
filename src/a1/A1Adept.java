package a1;

import java.util.Scanner;

import a1.A1Novice.Customer;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int count = scan.nextInt();
		
		Item[] possibleItems = new Item[count];
		
		for (int i=0; i<count; i++) {
			possibleItems[i] = new Item();
			possibleItems[i].setName(scan.next());
			possibleItems[i].setPrice(scan.nextDouble());
		}
		
		
		int cCount = scan.nextInt();
		
		Customer[] customers = new Customer[cCount];
		
		for (int i=0; i<cCount; i++) {
			customers[i] = new Customer();
			customers[i].setName(scan.next(), scan.next());
			customers[i].setItemsBought(scan.nextInt());
			// determine customer price and assign it to the object
			for (int j=0; j<customers[i].itemsBought; j++) {
				//find the prices of the 3 items bought and multiply by number of them to assign to total price
				// if you get rid of this for loop errors disappear 
				int q = scan.nextInt(); 
				String n = scan.next(); 
			
				for (int k=0; k<count; k++) {
					if (possibleItems[k].name.equals(n)) {
					customers[i].setTotalPrice(q, possibleItems[k].price);
					} 
				}	
			}
			
		
		
		
		// use for loop to loop through the customers and find who has the min and max total price
		// same for loop can determine the customer avg price
		
		}
		
		scan.close();
		
		
		double min = customers[0].totalPrice;
		String minN = customers[0].name; 
		double max = customers[0].totalPrice; 
		String maxN = customers[0].name; 
		
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
		
		System.out.println("Biggest: " + maxN + "(" + String.format("%.2f", max) + ")");
		System.out.println("Smallest: " + minN + "(" + String.format("%.2f", min) + ")");
		
		double total = 0;
		
		for (int i=0; i<cCount; i++) {
			total = total + customers[i].totalPrice; 
		}
		
		double avg = total / cCount; 
		
		System.out.println("Average " + String.format("%.2f", avg));
		
	}
	
	static class Item {
		String name; 
		double price; 
		
		 public void setName (String n) {
			 name = n;
		 }
		 
		 public void setPrice (double p) {
			 price = p;
		 }
	}
	
	
	static class Customer {
		String name;
		int itemsBought;
		double totalPrice;

		 
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
