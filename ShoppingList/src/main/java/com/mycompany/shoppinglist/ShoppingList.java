/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;
import java.util.*;

/**
 *
 * @author TTang2026
 */
public class ShoppingList {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            ArrayList<String> shoppingList = new ArrayList<>();
            
            System.out.println("Your Shopping List Manager");
            
            // getting the items from the user
            System.out.println("Enter items for your shopping list (type 'done' when finished):");
            while (true) {
                System.out.print("Add item: ");
                String item = scan.nextLine();
                if (item.equalsIgnoreCase("done")) {
                    break;
                }
                shoppingList.add(item);
            }
            
            // displaying the list
            System.out.println("\nYour Shopping List:");
            displayList(shoppingList);
            
            // allowing the user to remove an item
            System.out.println("\nWould you like to remove an item? (yes/no)");
            String response = scan.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter the number of the item to remove:");
                int itemNumber;
                try {
                    itemNumber = Integer.parseInt(scan.nextLine());
                    if (itemNumber > 0 && itemNumber <= shoppingList.size()) {
                        shoppingList.remove(itemNumber - 1);
                        System.out.println("Item removed successfully.");
                    } else {
                        System.out.println("Invalid number. No item removed.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
            
            // displaying the updated list
            System.out.println("\nUpdated Shopping List:");
            displayList(shoppingList);
            
            System.out.println("\nThank you for using the Shopping List Manager. Cya!");
        }
    }

    // method to display the shopping list with numbers
    private static void displayList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("Your shopping list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}