import java.util.Scanner;

public class InventManageSys {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String filename = "inventory.dat";

        try {
            inventory = Inventory.loadInventory(filename);
            System.out.println("Inventory loaded successfully.");
        } catch (Exception e) {
            System.out.println("No existing inventory data found. Starting fresh.");
        }

        while (true) {
            System.out.println("      Inventory Management System     ");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Fulfill Order");
            System.out.println("4. Save and Exit");
            System.out.print("Enter your choice:  ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter Product ID:  ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name:  ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity:  ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price:  ");
                    double price = scanner.nextDouble();

                    Product product = new Product(id, name, quantity, price);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;

                case 2: 
                    System.out.println("             Inventory Details                  ");
                    inventory.viewInventory();
                    break;

                case 3: 
                    System.out.print("Enter Order ID:  ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter Product ID:  ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter Quantity:  ");
                    int orderQuantity = scanner.nextInt();

                    Order order = new Order(orderId, productId, orderQuantity);
                    inventory.fulfillOrder(order);
                    break;

                case 4: 
                    try {
                        inventory.saveInventory(filename);
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;
                    } catch (Exception e) {
                        System.out.println("Error saving inventory:  " + e.getMessage());
                    }
                    break;

                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
