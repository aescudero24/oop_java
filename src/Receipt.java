import java.util.*;

class Customer {
    String name;
    boolean isRewardMember;
    int points;

    // Parameterized constructor
    Customer(String name, boolean isRewardMember, int points) {
        this.name = name;
        this.isRewardMember = isRewardMember;
        this.points = points;
    }
}

public class Receipt {
    public static void main(String[] args) {
        Scanner response = new Scanner(System.in);
        String name;
        boolean isRewardsMember = false;
        int points = 0;

        System.out.print("Enter your name: ");
        name = response.nextLine();

        System.out.println("Are you a rewards member, " + name + "? [y/n]");
        if (response.nextLine().equals("y")) {
            isRewardsMember = true;
        }

        Customer customer1 = new Customer(name, isRewardsMember, points);
        System.out.println("Hey, " + customer1.name + "!");

        HashMap<String, Integer> receipt = new HashMap<>();
        String item;
        int price;
        int pointsEarned = 0;

        while (true) {
            System.out.println("Would you like to [purchase] an item or [quit]?");
            switch (response.nextLine()) {
                case "purchase":
                    System.out.println("What item are you purchasing? ");
                    item = response.nextLine();

                    System.out.println("What is the price of your item? ");
                    try {
                        price = Integer.parseInt(response.nextLine());
                        receipt.put(item, price);
                        pointsEarned += 10;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a valid numerical value.");
                    }
                    break;
                case "quit":
                    if (receipt.isEmpty()) {
                        System.out.println("No items purchased.");
                        if (customer1.isRewardMember) {
                            System.out.println("No points earned.");
                        }
                    } else {
                        System.out.println("Here is your receipt: ");
                        for (Map.Entry<String, Integer> entry : receipt.entrySet()) {
                            String itemName = entry.getKey();
                            int itemPrice = entry.getValue();
                            System.out.println("Item: " + itemName + ", Price: " + itemPrice);
                        }
                        if (customer1.isRewardMember) {
                            System.out.println("Points Earned: " + pointsEarned);
                            customer1.points += pointsEarned;
                        }
                    }

                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please enter 'purchase' or 'quit'.");
                    break;
            }
        }
    }
}
