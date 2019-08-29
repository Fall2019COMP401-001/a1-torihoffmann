package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int count = scan.nextInt();
		
		Customer[] customers = new Customer[count];
		
		for (int i=0; i<count; i++) {
			customers[i] = new Customer();
			customers[i].setFirst(scan.next());
			customers[i].setLast(scan.next());
			customers[i].setItemsBought(scan.nextInt());
			Item[] items = new Item[customers[i].itemsBought];
			
			for (int j=0; j<customers[i].itemsBought; j++) {
				items[j] = new Item();
				items[j].setQ(scan.nextInt());
				items[j].setType(scan.next());
				items[j].setPrice(scan.nextDouble());
				customers[i].totalCost = customers[i].totalCost + items[j].calcTotalPrice();
			}
			
			
			System.out.println(customers[i].first.charAt(0) + ". " + customers[i].last + ": " + String.format("%.2f", customers[i].totalCost));
		}
		
		scan.close();
		
		
			
		
	}
	
	

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
