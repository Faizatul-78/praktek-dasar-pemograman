package week14;

import java.util.Scanner;

public class kafe09 {
    public static void menu(String customerName, boolean isMember) {
        System.out.println("Welcome, " + customerName + "!");

        if (isMember) {
            System.out.println("You are a member, enjoy 10% off every purchase!");
        }
        System.out.println("===== CAFE RESTAURANT MENU =====");
        System.out.println("1. Black Coffee - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Toast - Rp 10,000");
        System.out.println("6. Fried Noodles - Rp 18,000");
        System.out.println("=================================");
        System.out.println("Please choose the menu you would like.");
    }

    public static int calculateTotalPriceAttendanceNo(int menuChoice, int itemCount, boolean isMember) {
        int[] itemPrices = { 15000, 20000, 22000, 12000, 10000, 18000 };

        int totalPrice = itemPrices[menuChoice - 1] * itemCount;

        if (isMember) {
            int discount = totalPrice * 10 / 100;   // 10% of the total
            totalPrice = totalPrice - discount;
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter customer name (type 'done' to stop): ");
            String customerName = sc.nextLine();

            if (customerName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Is the customer a member? (yes/no): ");
            boolean isMember = sc.nextLine().equalsIgnoreCase("yes");

            menu(customerName, isMember);

            System.out.print("\nEnter the menu number you want to order: ");
            int menuChoice = sc.nextInt();
            System.out.print("Enter the number of items you want to order: ");
            int itemCount = sc.nextInt();
            sc.nextLine(); // clear the leftover Enter

            int totalPayment = calculateTotalPriceAttendanceNo(menuChoice, itemCount, isMember);

            System.out.println("Total price for your order: Rp" + totalPayment);
        }

        System.out.println("Thank you, the program has ended.");
        sc.close();
    }
}
