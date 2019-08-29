package a1;

import java.util.Scanner;

import a1.A1Adept.Customer;
import a1.A1Adept.Item;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
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
			
			int temp = 0;
			String tempN;
			
			for (int j=0; j<customers[i].itemsBought; j++) {
				temp = scan.nextInt();
				tempN = scan.next();
				for (int k=0; k<possibleItems.length; k++) {
					if (possibleItems[k].name.equals(tempN))  {
						possibleItems[k].updateTotal(temp);
						possibleItems[k].updateCC();
					}
				}
			}
		}
		
		scan.close();
		
		
		for (int i=0; i<possibleItems.length; i++) { 
			if (possibleItems[i].customerCount == 0) {
				System.out.println("No customers bought " + possibleItems[i].name);
			} else {
				System.out.println(possibleItems[i].customerCount + " customers bought " + possibleItems[i].totalQ + " " + possibleItems[i].name);
			}
		}
	}
		
	
	
}
