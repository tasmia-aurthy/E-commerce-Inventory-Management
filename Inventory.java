import java.io.*;
import java.util.*;

public class Inventory implements Serializable {
    private Map<Integer, Product> products = new HashMap<>();
    private int orderCounter = 1;

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public void viewInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    public void fulfillOrder(Order order) {
        Product product = products.get(order.getProductId());
        if (product != null && product.getQuantity() >= order.getQuantity()) {
            product.setQuantity(product.getQuantity() - order.getQuantity());
            System.out.println("Order fulfilled: " + order);
        } else {
            System.out.println("Order cannot be fulfilled. Insufficient stock.");
        }
    }

    public void saveInventory(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Inventory saved to file: " + filename);
        }
    }

    public static Inventory loadInventory(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Inventory) ois.readObject();
        }
    }
}